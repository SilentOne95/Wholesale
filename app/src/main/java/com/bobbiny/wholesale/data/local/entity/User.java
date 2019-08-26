package com.bobbiny.wholesale.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "user_table")
public class User {

    @PrimaryKey(autoGenerate = true)
    private Integer mId;

    @SerializedName("first_name")
    @Expose
    @ColumnInfo(name = "first_name")
    private String mFirstName;

    @SerializedName("last_name")
    @Expose
    @ColumnInfo(name = "last_name")
    private String mLastName;

    @SerializedName("country")
    @Expose
    @ColumnInfo(name = "country")
    private String mCountry;

    public Integer getId() {
        return mId;
    }

    public void setId(Integer mId) {
        this.mId = mId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String mCountry) {
        this.mCountry = mCountry;
    }
}
