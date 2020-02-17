
package com.matejcerna.videosfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Athlete {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("club")
    @Expose
    private String club;
    @SerializedName("isCelebrity")
    @Expose
    private Boolean isCelebrity;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("sport")
    @Expose
    private Sport sport;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public Boolean getIsCelebrity() {
        return isCelebrity;
    }

    public void setIsCelebrity(Boolean isCelebrity) {
        this.isCelebrity = isCelebrity;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

}
