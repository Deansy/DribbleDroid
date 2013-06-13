package com.camsh.dribble;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.camsh.dribble.Model.Player;
import com.camsh.dribble.Model.Shot;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;


public class API {

    public ArrayList<Shot> getPopularList(Context context) {
        ArrayList<Shot> popularList = new ArrayList<Shot>();
        try {
            JsonObject object = Ion.with(context, "http://api.dribbble.com/shots/popular?per_page=30").asJsonObject().get();
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
                //TODO: Change to use gson parsing

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


    private static class getJSON extends AsyncTask<String, Void, JsonObject> {

        protected JsonObject doInBackground(String... url) {
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpGet get = new HttpGet(url[0]);

                HttpResponse response = httpclient.execute(get);

                HttpEntity entity = response.getEntity();
                BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                String returnedJSONString = in.readLine();
                in.close();

                JsonObject o = new JsonParser().parse(returnedJSONString).getAsJsonObject();
                return o;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
