package com.certificacion.repository;

import androidx.lifecycle.LiveData;

import com.certificacion.db.MansionDao;
import com.certificacion.model.Mansion;
import com.certificacion.model.MansionResponse;
import com.certificacion.network.MansionApiService;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

import javax.inject.Inject;

public class Repository {

    private MansionDao mansionDao;
    private MansionApiService mansionApiService;

    @Inject

    public Repository(MansionDao mansionDao, MansionApiService mansionApiService) {
        this.mansionDao = mansionDao;
        this.mansionApiService = mansionApiService;
    }

    public Observable<MansionResponse> getMansiones(){
        return mansionApiService.getMansiones();
    }

    public void insertMansiones(Mansion mansion){
        mansionDao.insertMansiones(mansion);
    }

    public LiveData<List<Mansion>> getMansionOfline(){
        return mansionDao.getMansionesOfline();
    }
}
