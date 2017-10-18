package com.example.pancho.homeawaychallenge.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Pancho on 10/18/2017.
 */

public class Functions {

    public static String DateConversion(String s){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("E, dd MMMM yyyy hh:mm a").format(date);
    }
}
