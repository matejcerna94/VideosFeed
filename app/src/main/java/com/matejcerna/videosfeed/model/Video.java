
package com.matejcerna.videosfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("createdBefore")
    @Expose
    private String createdBefore;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("sportGroup")
    @Expose
    private SportGroup sportGroup;
    @SerializedName("video")
    @Expose
    private Video_ video;
    @SerializedName("description `# #leomessi #pepe #neymar #sergioramos #championsleague`")
    @Expose
    private String descriptionLeomessiPepeNeymarSergioramosChampionsleague;
    @SerializedName("athlete")
    @Expose
    private Athlete athlete;
    @SerializedName("bookmarked")
    @Expose
    private Boolean bookmarked;
    @SerializedName("views")
    @Expose
    private String views;
    @SerializedName("description")
    @Expose
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBefore() {
        return createdBefore;
    }

    public void setCreatedBefore(String createdBefore) {
        this.createdBefore = createdBefore;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public SportGroup getSportGroup() {
        return sportGroup;
    }

    public void setSportGroup(SportGroup sportGroup) {
        this.sportGroup = sportGroup;
    }

    public Video_ getVideo() {
        return video;
    }

    public void setVideo(Video_ video) {
        this.video = video;
    }

    public String getDescriptionLeomessiPepeNeymarSergioramosChampionsleague() {
        return descriptionLeomessiPepeNeymarSergioramosChampionsleague;
    }

    public void setDescriptionLeomessiPepeNeymarSergioramosChampionsleague(String descriptionLeomessiPepeNeymarSergioramosChampionsleague) {
        this.descriptionLeomessiPepeNeymarSergioramosChampionsleague = descriptionLeomessiPepeNeymarSergioramosChampionsleague;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public Boolean getBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(Boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
