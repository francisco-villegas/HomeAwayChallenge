package com.example.pancho.homeawaychallengue.model;

import com.example.pancho.homeawaychallengue.entitites.Event;

import java.util.List;

/**
 * Created by Pancho on 10/5/2017.
 */

public interface IRemote {
    void sendError(String s);

    void sendInfo(List<Event> events);
}
