package com.bobbiny.wholesale.data.remote;

import androidx.annotation.NonNull;

import com.bobbiny.wholesale.data.WholesaleDataSource;
import com.bobbiny.wholesale.data.network.Api;
import com.bobbiny.wholesale.data.network.RetrofitClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Concrete implementation of a data source as a network connection.
 */
public class WholesaleRemoteDataSource implements WholesaleDataSource {

    private static WholesaleRemoteDataSource INSTANCE;

    private Api mApi = RetrofitClient.getApi();
    private CompositeDisposable mDisposable = new CompositeDisposable();

    public static WholesaleRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WholesaleRemoteDataSource();
        }

        return INSTANCE;
    }

    // Prevent direct instantiation
    private WholesaleRemoteDataSource() {}

    /**
     * Get all the data from server.
     *
     * Note: {@link LoadDataCallback#onDataNotAvailable()} is fired if the database doesn't exist
     * or the table is empty.
     */
    @Override
    public void getAllContractors(@NonNull LoadDataCallback callback) {
        mDisposable.add(mApi.getAllContractors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onDataLoaded, throwable -> callback.onDataNotAvailable()));
    }

    @Override
    public void getAllItems(@NonNull LoadDataCallback callback) {
        mDisposable.add(mApi.getAllItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onDataLoaded, throwable -> callback.onDataNotAvailable()));
    }

    @Override
    public void saveAllContractors(@NonNull List<?> dataList) {

    }

    @Override
    public void saveAllItems(@NonNull List<?> dataList) {

    }
}
