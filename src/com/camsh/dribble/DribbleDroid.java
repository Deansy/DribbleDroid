package com.camsh.dribble;

import android.app.Application;


/**
 * Created by Cameron on 16/05/13.
 */
public class DribbleDroid extends Application {
    public API getApi() {
        return api;
    }

    private API api = new API();

}
