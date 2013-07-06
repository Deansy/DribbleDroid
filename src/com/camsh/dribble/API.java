package com.camsh.dribble;

import android.content.Context;

import com.camsh.dribble.Model.Player;
import com.camsh.dribble.Model.Shot;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;


public class API {

    public ArrayList<Shot> getPopularList(Context context, int count, int page) {
        ArrayList<Shot> popularList = new ArrayList<Shot>();
        try {
            if (count> 30) {
                count = 30;
            }
            if (count < 1) {
                count = 1;
            }

            if (page < 1) {
                page = 1;
            }
            JsonObject object = Ion.with(context, "http://api.dribbble.com/shots/popular?per_page=" + count + "&page=" + page).asJsonObject().get();
            JsonArray shotArray = object.get("shots").getAsJsonArray();

           for (int i = 0; i < shotArray.size(); i++) {
               JsonElement tempObj = shotArray.get(i);
               JsonObject obj = tempObj.getAsJsonObject();
               popularList.add(new Shot(obj));
            }

            return popularList;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Shot> getEveryoneList(Context context, int count, int page) {
        ArrayList<Shot> popularList = new ArrayList<Shot>();
        try {
            if (count> 30) {
                count = 30;
            }
            if (count < 1) {
                count = 1;
            }

            if (page < 1) {
                page = 1;
            }
            JsonObject object = Ion.with(context, "http://api.dribbble.com/shots/everyone?per_page=" + count + "&page=" + page).asJsonObject().get();
            JsonArray shotArray = object.get("shots").getAsJsonArray();

            for (int i = 0; i < shotArray.size(); i++) {
                JsonElement tempObj = shotArray.get(i);
                JsonObject obj = tempObj.getAsJsonObject();
                popularList.add(new Shot(obj));
            }

            return popularList;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Shot> getDebutList(Context context, int count, int page) {
        ArrayList<Shot> popularList = new ArrayList<Shot>();
        try {
            if (count> 30) {
                count = 30;
            }
            if (count < 1) {
                count = 1;
            }

            if (page < 1) {
                page = 1;
            }
            JsonObject object = Ion.with(context, "http://api.dribbble.com/shots/debuts?per_page=" + count + "&page=" + page).asJsonObject().get();
            JsonArray shotArray = object.get("shots").getAsJsonArray();

            for (int i = 0; i < shotArray.size(); i++) {
                JsonElement tempObj = shotArray.get(i);
                JsonObject obj = tempObj.getAsJsonObject();
                popularList.add(new Shot(obj));
            }

            return popularList;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Shot getShot(int shotID, boolean withComments, Context context) {
        try {

            JsonObject object = Ion.with(context, "http://api.dribbble.com/shots/" + shotID).asJsonObject().get();

            if (withComments) {
                JsonObject commentObject = Ion.with(context, "http://api.dribbble.com/shots/" + shotID + "/comments").asJsonObject().get();
                JsonArray commentArray = commentObject.get("comments").getAsJsonArray();

                return new Shot(object, commentArray);
            }
            else {
                return new Shot(object);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        // Return blank shot
        return new Shot();
    }

    public Player getPlayer(String playerName, Context context) {
        try {
            //JsonObject object = Ion.with(context, "http://api.dribble.com/players/" + playerName).asJsonObject().get();
        }
        catch (Exception e) {

        }
        return null;
    }
}
