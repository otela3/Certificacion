package com.certificacion.network;

import com.certificacion.model.MansionResponse;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.GET;

public interface MansionApiService {

    @GET("mansion")
    Observable<MansionResponse> getMansiones();
}
