package com.bobbiny.wholesale.data.local;

import androidx.annotation.NonNull;

import com.bobbiny.wholesale.data.local.entity.Contractor;
import com.bobbiny.wholesale.utils.AppExecutors;
import com.bobbiny.wholesale.data.WholesaleDataSource;
import com.bobbiny.wholesale.data.local.dao.ContractorDao;
import com.bobbiny.wholesale.data.local.dao.CordDao;
import com.bobbiny.wholesale.data.local.dao.MacrameDao;
import com.bobbiny.wholesale.data.local.dao.OtherDao;
import com.bobbiny.wholesale.data.local.dao.UserDao;

import java.util.List;

/**
 * Concrete implementation of a data source as a db
 */
public class WholesaleLocalDataSource implements WholesaleDataSource {

    private static volatile WholesaleLocalDataSource INSTANCE;

    private ContractorDao mContractorDao;
    private UserDao mUserDao;
    private CordDao mCordDao;
    private MacrameDao mMacrameDao;
    private OtherDao mOtherDao;

    private AppExecutors mAppExecutors;

    // Prevent direct instantiation
    private WholesaleLocalDataSource(@NonNull AppExecutors appExecutors, @NonNull ContractorDao contractorDao,
                                     @NonNull UserDao userDao, @NonNull CordDao cordDao, @NonNull MacrameDao macrameDao,
                                     @NonNull OtherDao otherDao) {
        mAppExecutors = appExecutors;
        mContractorDao = contractorDao;
        mUserDao = userDao;
        mCordDao = cordDao;
        mMacrameDao = macrameDao;
        mOtherDao = otherDao;
    }

    public static WholesaleLocalDataSource getInstance(@NonNull AppExecutors appExecutors, @NonNull ContractorDao contractorDao,
                                                       @NonNull UserDao userDao, @NonNull CordDao cordDao,
                                                       @NonNull MacrameDao macrameDao, @NonNull OtherDao otherDao) {
        if (INSTANCE == null) {
            synchronized (WholesaleLocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WholesaleLocalDataSource(appExecutors, contractorDao, userDao,
                            cordDao, macrameDao, otherDao);
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
            final List<Contractor> menuComponentList = mContractorDao.getAllContractors();

            mAppExecutors.mainThread().execute(() -> {
                if (!menuComponentList.isEmpty()) {
                    callback.onDataLoaded(menuComponentList);
                } else {
                    // This will be called if the table is new or just empty
                    callback.onDataNotAvailable();
                }
            });
        };

        mAppExecutors.diskIO().execute(getRunnable);
    }

    @Override
    public void saveContractors(@NonNull List<?> dataList) {
        Runnable saveRunnable = () -> mContractorDao.insertAllContractors((List<Contractor>) dataList);
        mAppExecutors.diskIO().execute(saveRunnable);
    }
}
