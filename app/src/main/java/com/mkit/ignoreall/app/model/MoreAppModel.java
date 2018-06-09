package com.mkit.ignoreall.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class MoreAppModel {
    @SerializedName("id")
    @Expose
    @Getter @Setter
    public String id;

    @SerializedName("name")
    @Expose
    @Getter @Setter
    public String name;

    @SerializedName("url")
    @Expose
    @Getter @Setter
    public String url;

    @SerializedName("image")
    @Expose
    @Getter @Setter
    public String image;

    public MoreAppModel(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public MoreAppModel(String id, String name, String url, String image) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.image = image;
    }

    public MoreAppModel() {
    }
}
