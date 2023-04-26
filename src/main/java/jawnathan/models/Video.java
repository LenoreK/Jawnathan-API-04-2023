package jawnathan.models;

import java.util.ArrayList;
import java.util.List;

public class Video {
    private int videoId;
    private String url;
    private String name;
    private String photo;
    private int groupId;

    public Video(int videoId, String url, String name, String photo, int groupId) {
        this.videoId = videoId;
        this.url = url;
        this.name = name;
        this.photo = photo;
        this.groupId = groupId;
    }

    public Video() {
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}