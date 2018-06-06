package com.mkit.ignoreall.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class CatalogModel {
    @SerializedName("id")
    @Expose
    @Getter @Setter
    public Integer id;

    @SerializedName("title")
    @Expose
    @Getter @Setter
    public String title;

    @SerializedName("description")
    @Expose
    @Getter @Setter
    public String description;

    @SerializedName("idImage")
    @Expose
    @Getter @Setter
    public Integer idImage;

    public CatalogModel() {
    }

    public CatalogModel(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public CatalogModel(Integer id, String title, String description, Integer idImage) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.idImage = idImage;
    }
}
