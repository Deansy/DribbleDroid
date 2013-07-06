package com.camsh.dribble.Model;

import com.google.gson.JsonObject;

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

    public Player(JsonObject object) {
        try {
            name = object.get("name").getAsString();
            website_url = object.get("website_url").getAsString();
            twitter_screen_name = object.get("twitter_screen_name").getAsString();
            username = object.get("username").getAsString();
            location = object.get("location").getAsString();
            url = object.get("url").getAsString();
            avatar_url = object.get("avatar_url").getAsString();
            likes_count = object.get("likes_count").getAsInt();
            comments_count = object.get("comments_count").getAsInt();
            followers_count = object.get("followers_count").getAsInt();
            id = object.get("id").getAsInt();
            shots_count = object.get("shots_count").getAsInt();
            likes_recieved_count = object.get("likes_recieved_count").getAsInt();
            drafted_by_player_id = object.get("drafted_by_player_id").getAsInt();
            draftees_count = object.get("draftees_count").getAsInt();
            following_count = object.get("following_count").getAsInt();
            rebounds_count = object.get("rebounds_count").getAsInt();
            rebounds_recieved_count = object.get("rebounds_recieved_count").getAsInt();
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
