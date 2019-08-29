package com.bobbiny.wholesale.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.bobbiny.wholesale.data.local.entity.Macrame;

import java.util.List;

/**
 * Data Access Object for the macrame table.
 */
@Dao
public interface MacrameDao {

    /**
     * Select all macrame from the macrame table.
     *
     * @return all macrame.
     */
    @Query("SELECT * FROM macrame_table")
    List<Macrame> getAllMacrame();

    /**
     * Insert all macrame to the macrame table.
     */
    @Insert
    void insertAllMacrame(List<Macrame> macrameList);
}