package com.bobbiny.wholesale.data.local;

import androidx.annotation.NonNull;

import com.bobbiny.wholesale.data.local.dao.ItemDao;
import com.bobbiny.wholesale.data.local.entity.Contractor;
import com.bobbiny.wholesale.data.local.entity.Item;
import com.bobbiny.wholesale.utils.AppExecutors;
import com.bobbiny.wholesale.data.WholesaleDataSource;
import com.bobbiny.wholesale.data.local.dao.ContractorDao;

import java.util.List;

/**
 * Concrete implementation of a data source as a db
 */
public class WholesaleLocalDataSource implements WholesaleDataSource {

    private static volatile WholesaleLocalDataSource INSTANCE;

    private ContractorDao mContractorDao;
    private ItemDao mItemDao;

    private AppExecutors mAppExecutors;

    // Prevent direct instantiation
    private WholesaleLocalDataSource(@NonNull AppExecutors appExecutors, @NonNull ContractorDao contractorDao,
                                     @NonNull ItemDao itemDao) {
        mAppExecutors = appExecutors;
        mContractorDao = contractorDao;
        mItemDao = itemDao;
    }

    public static WholesaleLocalDataSource getInstance(@NonNull AppExecutors appExecutors, @NonNull ContractorDao contractorDao,
                                                       @NonNull ItemDao itemDao) {
        if (INSTANCE == null) {
            synchronized (WholesaleLocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WholesaleLocalDataSource(appExecutors, contractorDao, itemDao);
                }
            }
        }

        return INSTANCE;
    }

    /**
     * Get all the data from SQLite database.
     *
     * Note: {@link LoadDataCallback#onDataNotAvailable()} is fired if the database doesn't exist
     * or the table is empty.
     */
    @Override
    public void getAllContractors(@NonNull LoadDataCallback callback) {
        Runnable getRunnable = () -> {
            final List<Contractor> contractorList = mContractorDao.getAllContractors();

            mAppExecutors.mainThread().execute(() -> {
                if (!contractorList.isEmpty()) {
                    callback.onDataLoaded(contractorList);
                } else {
                    // This will be called if the table is new or just empty
                    callback.onDataNotAvailable();
                }
            });
        };

        mAppExecutors.diskIO().execute(getRunnable);
    }

    @Override
    public void getAllItems(@NonNull LoadDataCallback callback) {
        Runnable getRunnable = () -> {
            final List<Item> itemList = mItemDao.getAllItems();

            mAppExecutors.mainThread().execute(() -> {
                if (!itemList.isEmpty()) {
                    callback.onDataLoaded(itemList);
                } else {
                    callback.onDataNotAvailable();
                }
            });
        };

        mAppExecutors.diskIO().execute(getRunnable);
    }

    @Override
    public void saveAllContractors(@NonNull List<?> dataList) {
        Runnable saveRunnable = () -> mContractorDao.insertAllContractors((List<Contractor>) dataList);
        mAppExecutors.diskIO().execute(saveRunnable);
    }

    @Override
    public void saveAllItems(@NonNull List<?> dataList) {
        Runnable saveRunnable = () -> mItemDao.insertAllItems((List<Item>) dataList);
        mAppExecutors.diskIO().execute(saveRunnable);
    }
}
