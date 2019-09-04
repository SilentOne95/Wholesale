package com.bobbiny.wholesale.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.bobbiny.wholesale.data.local.entity.Contractor;

import java.util.List;

/**
 * Data Access Object for the contractor table.
 */
@Dao
public interface ContractorDao {

    /**
     * Select all contractors from the contractor table.
     *
     * @return all contractors.
     */
    @Query("SELECT * FROM contractor_table")
    List<Contractor> getAllContractors();

    /**
     * Insert all contractors to the user table.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllContractors(List<Contractor> contractorList);
}
