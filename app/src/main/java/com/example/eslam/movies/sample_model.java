package com.example.eslam.movies;

import java.io.Serializable;

/**
 *
 */
public class sample_model implements Serializable {
    private String poster;
    private String title;
    private String release_date;
    private String description;
    public sample_model(){
        poster="";
        title="";
        release_date="";
        description="";
    }
    public void setPoster(String u){
        poster=u;
    }
    public String getPoster(){
        return poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
