package com.camsh.dribble.Model;

import org.json.JSONObject;


public class Comment {
    int likes_count;
    Player author;
    String body;
    int id;
    //Date created_at;

    public Comment() {

    }

    public Comment(JSONObject object) {
        try {
            likes_count = object.getInt("likes_count");
            author = new Player(object.getJSONObject("player"));
            body = object.getString("body");
            id = object.getInt("id");
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
