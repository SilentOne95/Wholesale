package com.bobbiny.wholesale.data;

import androidx.annotation.NonNull;

import java.util.List;

public interface WholesaleDataSource {

    interface LoadDataCallback {

        void onDataLoaded(List<?> data);

        void onDataNotAvailable();
    }

    interface GetSingleDataCallback<T> {

        void onDataLoaded(T object);

        void onDataNotAvailable();
    }

    void getAllContractors(@NonNull final LoadDataCallback callback);

    void getAllItems(@NonNull final LoadDataCallback callback);

    void saveAllContractors(@NonNull final List<?> dataList);

    void saveAllItems(@NonNull final List<?> dataList);
}
