package com.example.omninos;

import java.io.Serializable;
import java.util.List;

public class categories implements Serializable {

    String name;
    List<videos> videos;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.example.omninos.videos> getVideos() {
        return videos;
    }

    public void setVideos(List<com.example.omninos.videos> videos) {
        this.videos = videos;
    }
}
