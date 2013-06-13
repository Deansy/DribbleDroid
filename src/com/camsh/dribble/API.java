package com.camsh.dribble;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.camsh.dribble.Model.Player;
import com.camsh.dribble.Model.Shot;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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

    public Shot getShot(int shotID, boolean withComments) {
        try {
            JSONObject object = new getJSON().execute("http://api.dribbble.com/shots/" + shotID).get();

            if (withComments) {
                //TODO: Change to use gson parsing
                JSONObject commentObject = new getJSON().execute("http://api.dribbble.com/shots/" + shotID + "/comments").get();
                JSONArray commentArray = commentObject.getJSONArray("comments");

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

    public Player getPlayer(String playerName) {
        try {
            JSONObject object = new getJSON().execute("http://api.dribble.com/players/" + playerName).get();
        }
        catch (Exception e) {

        }
        return null;
    }


    private static class getJSON extends AsyncTask<String, Void, JSONObject> {

        protected JSONObject doInBackground(String... url) {
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpGet get = new HttpGet(url[0]);

                HttpResponse response = httpclient.execute(get);

                HttpEntity entity = response.getEntity();
                BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                String returnedJSONString = in.readLine();
                in.close();

                JSONObject object = new JSONObject(returnedJSONString);
                return object;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
