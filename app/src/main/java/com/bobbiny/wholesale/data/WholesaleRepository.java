package com.bobbiny.wholesale.data;

import androidx.annotation.NonNull;

import java.util.List;

public class WholesaleRepository implements WholesaleDataSource {

    private static WholesaleRepository INSTANCE = null;

    private final WholesaleDataSource mWholesaleRemoteDataSource;
    private final WholesaleDataSource mWholesaleLocalDataSource;

    // Prevent direct instantiation
    private WholesaleRepository(@NonNull WholesaleDataSource wholesaleRemoteDataSource,
                                @NonNull WholesaleDataSource wholesaleLocalDataSource) {
        mWholesaleRemoteDataSource = wholesaleRemoteDataSource;
        mWholesaleLocalDataSource = wholesaleLocalDataSource;
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @param wholesaleRemoteDataSource the backend data source
     * @param wholesaleLocalDataSource  the device storage data source
     * @return the {@link WholesaleRepository} instance
     */
    public static WholesaleRepository getInstance(WholesaleDataSource wholesaleRemoteDataSource,
                                                  WholesaleDataSource wholesaleLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new WholesaleRepository(wholesaleRemoteDataSource, wholesaleLocalDataSource);
        }

        return INSTANCE;
    }

    @Override
    public void getAllContractors(@NonNull LoadDataCallback callback) {
        mWholesaleRemoteDataSource.getAllContractors(new LoadDataCallback() {
            @Override
            public void onDataLoaded(List<?> data) {
                saveContractors(data);
                callback.onDataLoaded(data);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void saveContractors(@NonNull List<?> dataList) {
        mWholesaleLocalDataSource.saveContractors(dataList);
    }
}
