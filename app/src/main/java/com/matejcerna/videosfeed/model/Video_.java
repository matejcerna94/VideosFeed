
package com.matejcerna.videosfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video_ {

    @SerializedName("handler")
    @Expose
    private String handler;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("poster")
    @Expose
    private String poster;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("length")
    @Expose
    private Integer length;

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

}
