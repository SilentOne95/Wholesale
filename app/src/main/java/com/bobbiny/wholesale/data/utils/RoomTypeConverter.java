package com.bobbiny.wholesale.data.utils;

import androidx.room.TypeConverter;

import com.bobbiny.wholesale.data.local.entity.Cord;
import com.bobbiny.wholesale.data.local.entity.Macrame;
import com.bobbiny.wholesale.data.local.entity.Other;
import com.bobbiny.wholesale.data.local.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class RoomTypeConverter {

    private static Gson gson = new Gson();

    @TypeConverter
    public static User stringToUserObject(String data) {
        if (data == null) {
            return new User();
        }

        Type listType = new TypeToken<User>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String objectUserToString(User cordList) {
        return gson.toJson(cordList);
    }


    @TypeConverter
    public static List<Cord> stringToCordList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Cord>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String listCordToString(List<Cord> cordList) {
        return gson.toJson(cordList);
    }


    @TypeConverter
    public static List<Macrame> stringToMacrameList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Macrame>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String listMacrameToString(List<Macrame> cordList) {
        return gson.toJson(cordList);
    }


    @TypeConverter
    public static List<Other> stringToOtherList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Other>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String listOtherToString(List<Other> cordList) {
        return gson.toJson(cordList);
    }
}
