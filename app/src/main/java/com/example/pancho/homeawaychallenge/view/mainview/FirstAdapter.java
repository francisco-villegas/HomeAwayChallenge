package com.example.pancho.homeawaychallenge.view.mainview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.beardedhen.androidbootstrap.BootstrapWell;
import com.example.pancho.homeawaychallenge.R;
import com.example.pancho.homeawaychallenge.entitites.Event;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.pancho.homeawaychallenge.util.Functions.DateConversion;

/**
 * Created by Francisco on 10/18/2017.
 */

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.ViewHolder>{
    private static final String TAG = "FirstAdapter";
    List<Event> eventList;
    Context context;

    public FirstAdapter(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Event item = eventList.get(position);

        String url_img = item.getPerformers().get(0).getImage();
        if(url_img != null)
            Picasso.with(context).load(url_img).into(holder.img);
        else
            Picasso.with(context).load(R.drawable.broken_image).into(holder.img);

        if (!item.getTitle().trim().equals(""))
            holder.tvTitle.setText(item.getTitle());
        else
            holder.tvNameParent.setVisibility(holder.tvNameParent.getRootView().GONE);

        if (!item.getVenue().getDisplayLocation().trim().equals(""))
            holder.tvLocation.setText(item.getVenue().getDisplayLocation());
        else
            holder.tvLocation.setVisibility(holder.tvLocation.getRootView().GONE);

        if (!item.getAnnounceDate().trim().equals(""))
            holder.tvDate.setText(DateConversion(item.getAnnounceDate()));
        else
            holder.tvDate.setVisibility(holder.tvDate.getRootView().GONE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((EventListener) context).ItemClick(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Nullable
        @BindView(R.id.img)
        BootstrapCircleThumbnail img;

        @Nullable
        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @Nullable
        @BindView(R.id.tvLocation)
        TextView tvLocation;

        @Nullable
        @BindView(R.id.tvDate)
        TextView tvDate;

        @Nullable
        @BindView(R.id.scroll)
        ScrollView scroll;

        @Nullable
        @BindView(R.id.scroll_parent)
        FrameLayout scroll_parent;

        @Nullable
        @BindView(R.id.tvNameParent)
        BootstrapWell tvNameParent;

        public ViewHolder(View ResultView) {
            super(ResultView);
            ButterKnife.bind(this, ResultView);
        }
    }

    public interface EventListener {
        void ItemClick(Event item);
    }
}
