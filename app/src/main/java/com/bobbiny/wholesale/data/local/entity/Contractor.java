package com.bobbiny.wholesale.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "contractor_table")
public class Contractor {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
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

    @SerializedName("currency")
    @Expose
    @ColumnInfo(name = "currency")
    private String mCurrency;

    @SerializedName("delivery_price")
    @Expose
    @ColumnInfo(name = "delivery_price")
    private Float mDeliveryPrice;

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

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String mCurrency) {
        this.mCurrency = mCurrency;
    }

    public Float getDeliveryPrice() {
        return mDeliveryPrice;
    }

    public void setDeliveryPrice(Float mDeliveryPrice) {
        this.mDeliveryPrice = mDeliveryPrice;
    }
}
