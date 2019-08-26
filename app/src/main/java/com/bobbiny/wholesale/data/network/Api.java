package com.bobbiny.wholesale.data.network;

import com.bobbiny.wholesale.data.local.entity.Cord;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

public interface Api {

    @Streaming
    @GET("/contractors")
    Single<List<Cord>> getAllContractors();
}
