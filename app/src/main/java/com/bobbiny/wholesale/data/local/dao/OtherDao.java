package com.bobbiny.wholesale.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.bobbiny.wholesale.data.local.entity.Other;

import java.util.List;

/**
 * Data Access Object for the other table.
 */
@Dao
public interface OtherDao {

    /**
     * Select all other items from the other table.
     *
     * @return all other items.
     */
    @Query("SELECT * FROM other_table")
    List<Other> getAllOthers();

    /**
     * Insert all other items to the other table.
     */
    @Insert
    void insertAllOthers(List<Other> otherList);
}
