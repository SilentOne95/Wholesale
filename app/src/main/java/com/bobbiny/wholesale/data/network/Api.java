package com.bobbiny.wholesale.data.network;

import com.bobbiny.wholesale.data.local.entity.Contractor;
import com.bobbiny.wholesale.data.local.entity.Item;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

public interface Api {

    @Streaming
    @GET("/contractors")
    Single<List<Contractor>> getAllContractors();

    @Streaming
    @GET("/items")
    Single<List<Item>> getAllItems();
}
