package com.camsh.dribble.Model;

import org.json.JSONArray;
import org.json.JSONObject;

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

    ArrayList<Comment> comments;


    public Shot() {

    }
    public Shot(JSONObject object) {
        // If an exemption is thrown then it will not parse any elements after it.
        // NEED TO FIX ASAP
        try {

            image_url = object.getString("image_url");
            short_url = object.getString("short_url");
            image_teaser_url = object.getString("image_teaser_url");
            views_count = object.getInt("views_count");
            comments_count = object.getInt("comments_count");
            likes_count = object.getInt("likes_count");
            id = object.getInt("id");
            width = object.getInt("width");
            height = object.getInt("height");
            title = object.getString("title");
            url = object.getString("url");
            player = new Player(object.getJSONObject("player"));
            rebound_source_url = object.getString("rebound_source_url");
            rebounds_count = object.getInt("rebounds_count");
        }
        catch (Exception e) {

        }
    }
    public Shot(JSONObject object, JSONArray commentArray) {
        try {

            comments = new ArrayList<Comment>();

            for (int i = 0; i < commentArray.length(); i++) {
                comments.add(new Comment(commentArray.getJSONObject(i)));
            }

            image_teaser_url = object.getString("image_teaser_url");
            image_url = object.getString("image_url");
            short_url = object.getString("short_url");
            views_count = object.getInt("views_count");
            comments_count = object.getInt("comments_count");
            likes_count = object.getInt("likes_count");
            id = object.getInt("id");
            width = object.getInt("width");
            height = object.getInt("height");
            title = object.getString("title");
            player = new Player(object.getJSONObject("player"));
            rebound_source_url = object.getString("rebound_source_url");
            url = object.getString("url");

            rebounds_count = object.getInt("rebounds_count");


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRebounds_count() {
        return rebounds_count;
    }
    public int getViews_count() {
        return views_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public Player getPlayer() {
        return player;
    }

    public String getRebound_source_url() {
        return rebound_source_url;
    }



    public String getShort_url() {
        return short_url;
    }

    public ArrayList<Comment> getComments() {
        return comments;

    }

    public Comment getComment(int comment) {
        return comments.get(comment);
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
