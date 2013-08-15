package com.camsh.dribble.Model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class Shot {
    String image_teaser_url;
    int views_count;
    int comments_count;
    int likes_count;
    int id;
    int width;
    int height;
    String title;
    Player player;
    String rebound_source_url;
    String url;
    //NSDate *_created_at;
    String image_url;
    String short_url;
    int rebounds_count;
    boolean hasComments = false;

    ArrayList<Comment> comments;


    public Shot() {

    }

    public Shot(JsonObject object) {
        // If an exemption is thrown then it will not parse any elements after it.
        // NEED TO FIX ASAP
        try {
            image_url = object.get("image_url").getAsString();
            short_url = object.get("short_url").getAsString();
            image_teaser_url = object.get("image_teaser_url").getAsString();
            views_count = object.get("views_count").getAsInt();
            comments_count = object.get("comments_count").getAsInt();
            likes_count = object.get("likes_count").getAsInt();
            id = object.get("id").getAsInt();
            width = object.get("width").getAsInt();
            height = object.get("height").getAsInt();
            title = object.get("title").getAsString();
            url = object.get("url").getAsString();
            player = new Player(object.get("player").getAsJsonObject());
            rebound_source_url = object.get("rebound_source_url").getAsString();
            rebounds_count = object.get("rebounds_count").getAsInt();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Shot(JsonObject object, JsonArray commentArray) {
        try {

            hasComments = true;
            comments = new ArrayList<Comment>();

            for (int i = 0; i < commentArray.size(); i++) {
                comments.add(new Comment(commentArray.get(i).getAsJsonObject()));
            }

            image_teaser_url = object.get("image_teaser_url").getAsString();
            image_url = object.get("image_url").getAsString();
            short_url = object.get("short_url").getAsString();
            views_count = object.get("views_count").getAsInt();

            //Gives the total number of comments
            comments_count = object.get("comments_count").getAsInt();


            likes_count = object.get("likes_count").getAsInt();
            id = object.get("id").getAsInt();
            width = object.get("width").getAsInt();
            height = object.get("height").getAsInt();
            title = object.get("title").getAsString();
            player = new Player(object.get("player").getAsJsonObject());
            rebound_source_url = object.get("rebound_source_url").getAsString();
            url = object.get("url").getAsString();

            rebounds_count = object.get("rebounds_count").getAsInt();


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Player getPlayer() {
        return player;
    }

    public boolean hasComments() {
        return hasComments;
    }

    public ArrayList<Comment> getComments() {
        return comments;

    }

    public Comment getComment(int comment) {
        try {
            return comments.get(comment);
        }
        catch (Exception e) {
            return new Comment(0, null, "NULL", 666);
        }
    }


    public String getImageTeaserUrl() {
        return image_teaser_url;
    }

    public int getViewCount() {
        return views_count;
    }

    public int getCommentCount() {
        return comments_count;
    }

    public int getLikeCount() {
        return likes_count;
    }

    public int getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }

    public String getReboundSourceUrl() {
        return rebound_source_url;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return image_url;
    }

    public String getShortUrl() {
        return short_url;
    }

    public int getReboundCount() {
        return rebounds_count;
    }
}
