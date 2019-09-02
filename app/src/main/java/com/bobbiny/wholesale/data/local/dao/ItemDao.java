package com.bobbiny.wholesale.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.bobbiny.wholesale.data.local.entity.Item;

import java.util.List;

/**
 * Data Access Object for the cords table.
 */
@Dao
public interface ItemDao {

    /**
     * Select all cords from the cord table.
     *
     * @return all cords.
     */
    @Query("SELECT * FROM item_table")
    List<Item> getAllItems();

    /**
     * Insert all cords to the cord table.
     */
    @Insert
    void insertAllItems(List<Item> cordList);
}

