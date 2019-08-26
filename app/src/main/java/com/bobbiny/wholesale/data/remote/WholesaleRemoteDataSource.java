package com.bobbiny.wholesale.data.remote;

import com.bobbiny.wholesale.data.WholesaleDataSource;
import com.bobbiny.wholesale.data.network.Api;
import com.bobbiny.wholesale.data.network.RetrofitClient;

import io.reactivex.disposables.CompositeDisposable;

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
}
