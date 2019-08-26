package com.bobbiny.wholesale.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "other_table")
public class Other {

    @PrimaryKey(autoGenerate = true)
    private Integer mId;

    @SerializedName("item_id")
    @Expose
    @ColumnInfo(name = "item_id")
    private Integer mItemId;

    @SerializedName("item_price")
    @Expose
    @ColumnInfo(name = "item_price")
    private Float mItemPrice;

    public Integer getId() {
        return mId;
    }

    public void setId(Integer mId) {
        this.mId = mId;
    }

    public Integer getItemId() {
        return mItemId;
    }

    public void setItemId(Integer mItemId) {
        this.mItemId = mItemId;
    }

    public Float getItemPrice() {
        return mItemPrice;
    }

    public void setItemPrice(Float mItemPrice) {
        this.mItemPrice = mItemPrice;
    }
}
