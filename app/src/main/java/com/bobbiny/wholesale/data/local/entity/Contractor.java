package com.bobbiny.wholesale.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.bobbiny.wholesale.data.utils.RoomTypeConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "contractor_table")
public class Contractor {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
    private Integer mId;

    @SerializedName("user")
    @Expose
    @ColumnInfo(name = "user")
    @TypeConverters(RoomTypeConverter.class)
    private User mUser;

    @SerializedName("cord")
    @Expose
    @ColumnInfo(name = "cord")
    @TypeConverters(RoomTypeConverter.class)
    private List<Cord> mCordList = null;

    @SerializedName("macrame")
    @Expose
    @ColumnInfo(name = "macrame")
    @TypeConverters(RoomTypeConverter.class)
    private List<Macrame> mMacrameList = null;

    @SerializedName("other")
    @Expose
    @ColumnInfo(name = "other")
    @TypeConverters(RoomTypeConverter.class)
    private List<Other> mOtherList = null;

    public Integer getId() {
        return mId;
    }

    public void setId(Integer mId) {
        this.mId = mId;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User mUser) {
        this.mUser = mUser;
    }

    public List<Cord> getCordList() {
        return mCordList;
    }

    public void setCordList(List<Cord> mCordList) {
        this.mCordList = mCordList;
    }

    public List<Macrame> getMacrameList() {
        return mMacrameList;
    }

    public void setMacrameList(List<Macrame> mMacrameList) {
        this.mMacrameList = mMacrameList;
    }

    public List<Other> getOtherList() {
        return mOtherList;
    }

    public void setOtherList(List<Other> mOtherList) {
        this.mOtherList = mOtherList;
    }
}
