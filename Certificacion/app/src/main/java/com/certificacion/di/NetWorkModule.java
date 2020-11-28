package com.certificacion.di;


import com.certificacion.network.MansionApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class NetWorkModule {

    @Provides
    @Singleton
    public static MansionApiService privideMansionApiService(){
        return new Retrofit.Builder()
                .baseUrl("http://my-json-server.typicode.com/Himuravidal/mansions/mansions/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(MansionApiService.class);
    }

}
