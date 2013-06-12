package com.camsh.dribble.Model;

import org.json.JSONObject;

import java.util.Date;

public class Player {
    String name;
    String website_url;
    String twitter_screen_name;
    String username;
    String location;
    String url;
    String avatar_url;
    int likes_count;
    int comments_count;
    int followers_count;
    int id;
    int shots_count;
    int likes_recieved_count;
    int drafted_by_player_id;
    int draftees_count;
    int following_count;
    int rebounds_count;
    int rebounds_recieved_count;
    //Date created_at;

    public Player(JSONObject object) {
        try {
            name = object.getString("name");
            website_url = object.getString("website_url");
            twitter_screen_name = object.getString("twitter_screen_name");
            username = object.getString("username");
            location = object.getString("location");
            url = object.getString("url");
            avatar_url = object.getString("avatar_url");
            likes_count = object.getInt("likes_count");
            comments_count = object.getInt("comments_count");
            followers_count = object.getInt("followers_count");
            id = object.getInt("id");
            shots_count = object.getInt("shots_count");
            likes_recieved_count = object.getInt("likes_recieved_count");
            drafted_by_player_id = object.getInt("drafted_by_player_id");
            draftees_count = object.getInt("draftees_count");
            following_count = object.getInt("following_count");
            rebounds_count = object.getInt("rebounds_count");
            rebounds_recieved_count = object.getInt("rebounds_recieved_count");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Player() {

    }


    public String getName() {
        return name;
    }

    public String getWebsiteUrl() {
        return website_url;
    }

    public String getTwitterScreenName() {
        return twitter_screen_name;
    }

    public String getUsername() {
        return username;
    }

    public String getLocation() {
        return location;
    }

    public String getUrl() {
        return url;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }

    public int getLikeCount() {
        return likes_count;
    }

    public int getCommentCount() {
        return comments_count;
    }

    public int getFollowerCount() {
        return followers_count;
    }

    public int getId() {
        return id;
    }

    public int getShotCount() {
        return shots_count;
    }

    public int getLikesRecievedCount() {
        return likes_recieved_count;
    }

    public int getDrafted_by_player_id() {
        return drafted_by_player_id;
    }

    public int getDrafteeCount() {
        return draftees_count;
    }

    public int getFollowingCount() {
        return following_count;
    }

    public int getReboundCount() {
        return rebounds_count;
    }

    public int getReboundsRecievedCount() {
        return rebounds_recieved_count;
    }




}
