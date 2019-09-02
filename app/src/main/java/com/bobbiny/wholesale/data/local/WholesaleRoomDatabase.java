package com.bobbiny.wholesale.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bobbiny.wholesale.data.local.dao.ContractorDao;
import com.bobbiny.wholesale.data.local.dao.ItemDao;
import com.bobbiny.wholesale.data.local.entity.Contractor;
import com.bobbiny.wholesale.data.local.entity.Item;

@Database(entities = {Contractor.class, Item.class}, version = 1)
public abstract class WholesaleRoomDatabase extends RoomDatabase {

    public abstract ContractorDao contractorDao();
    public abstract ItemDao itemDao();

    private static volatile WholesaleRoomDatabase INSTANCE;

    public static WholesaleRoomDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (WholesaleRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WholesaleRoomDatabase.class, "wholesale_database")
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
