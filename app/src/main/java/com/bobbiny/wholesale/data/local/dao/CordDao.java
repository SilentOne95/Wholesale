package com.bobbiny.wholesale.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.bobbiny.wholesale.data.local.entity.Cord;

import java.util.List;

/**
 * Data Access Object for the cords table.
 */
@Dao
public interface CordDao {

    /**
     * Select all cords from the cord table.
     *
     * @return all cords.
     */
    @Query("SELECT * FROM cord_table")
    LiveData<List<Cord>> getAllCords();

    /**
     * Insert all cords to the cord table.
     */
    @Insert
    void insertAllCords(List<Cord> cordList);
}
