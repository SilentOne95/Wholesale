package com.bobbiny.wholesale.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.bobbiny.wholesale.data.local.dao.ContractorDao;
import com.bobbiny.wholesale.data.local.dao.CordDao;
import com.bobbiny.wholesale.data.local.dao.MacrameDao;
import com.bobbiny.wholesale.data.local.dao.OtherDao;
import com.bobbiny.wholesale.data.local.dao.UserDao;
import com.bobbiny.wholesale.data.local.entity.Contractor;
import com.bobbiny.wholesale.data.local.entity.Cord;
import com.bobbiny.wholesale.data.local.entity.Macrame;
import com.bobbiny.wholesale.data.local.entity.Other;
import com.bobbiny.wholesale.data.local.entity.User;
import com.bobbiny.wholesale.data.utils.CordTypeConverter;

@Database(entities = {Contractor.class, User.class, Cord.class, Macrame.class, Other.class}, version = 1)
@TypeConverters({CordTypeConverter.class})
public abstract class WholesaleRoomDatabase extends RoomDatabase {

    public abstract ContractorDao contractorDao();
    public abstract UserDao userDao();
    public abstract CordDao cordDao();
    public abstract MacrameDao macrameDao();
    public abstract OtherDao otherDao();

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
