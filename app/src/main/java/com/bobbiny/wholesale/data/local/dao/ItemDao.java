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
     * Select all items from the item table.
     *
     * @return all items.
     */
    @Query("SELECT * FROM item_table")
    List<Item> getAllItems();

    /**
     * Select items with certain id and category from the item table.
     *
     * @return all items that match requirements.
     */
    @Query("SELECT * FROM item_table WHERE id_relation = :id AND category = :category")
    List<Item> getCategoryItems(int id, String category);

    /**
     * Insert all items to the item table.
     */
    @Insert
    void insertAllItems(List<Item> cordList);
}

