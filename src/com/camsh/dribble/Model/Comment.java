package com.camsh.dribble.Model;

import com.google.gson.JsonObject;

import org.json.JSONObject;


public class Comment {
    int likes_count;
    Player author;
    String body;
    int id;
    //Date created_at;

    public Comment() {

    }

    public Comment(JsonObject object) {
        try {
            likes_count = object.get("likes_count").getAsInt();
            author = new Player(object.get("player").getAsJsonObject());
            body = object.get("body").getAsString();
            id = object.get("id").getAsInt();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getLikeCount() {
        return likes_count;
    }

    public Player getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public int getId() {
        return id;
    }
}
