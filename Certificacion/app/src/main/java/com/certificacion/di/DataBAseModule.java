package com.certificacion.di;

import android.app.Application;

import androidx.room.Room;

import com.certificacion.db.MansionDB;
import com.certificacion.db.MansionDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DataBAseModule {

    @Provides
    @Singleton
    public static MansionDB provideMansionDB(Application application){
        return Room.databaseBuilder(application,MansionDB.class,"Mansion Database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }
    @Provides
    @Singleton
    public static MansionDao provideMansionDao(MansionDB mansionDB){
        return mansionDB.mansionDao();
    }
}
