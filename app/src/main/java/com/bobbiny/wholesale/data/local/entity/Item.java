package com.bobbiny.wholesale.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "item_table")
public class Item {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
    private Integer mId;

    @SerializedName("id_relation")
    @Expose
    @ColumnInfo(name = "id_relation")
    private Integer mIdRelation;

    @SerializedName("category")
    @Expose
    @ColumnInfo(name = "category")
    private String mCategory;

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    private String mName;

    @SerializedName("price")
    @Expose
    @ColumnInfo(name = "price")
    private Float mPrice;

    public Integer getId() {
        return mId;
    }

    public void setId(Integer mId) {
        this.mId = mId;
    }

    public Integer getIdRelation() {
        return mIdRelation;
    }

    public void setIdRelation(Integer mIdRelation) {
        this.mIdRelation = mIdRelation;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public Float getPrice() {
        return mPrice;
    }

    public void setPrice(Float mPrice) {
        this.mPrice = mPrice;
    }
}
