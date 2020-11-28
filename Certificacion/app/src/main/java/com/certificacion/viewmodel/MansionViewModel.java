package com.certificacion.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.certificacion.model.Mansion;
import com.certificacion.model.MansionResponse;
import com.certificacion.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MansionViewModel extends ViewModel {
    private static final String TAG = "MansionViewModel";

    private Repository repository;
    private MutableLiveData<ArrayList<Mansion>> mansionList = new MutableLiveData<>();
    private LiveData<List<Mansion>> mansionListOfline = null;

    public MansionViewModel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<ArrayList<Mansion>> getMansionList(){
        return mansionList;
    }

    public void getMansiones(){
        repository.getMansiones()
                .subscribeOn(Schedulers.io())
                .map(new Function<MansionResponse, ArrayList<Mansion>>() {
                    @Override
                    public ArrayList<Mansion> apply(MansionResponse mansionResponse) throws Throwable{
                        ArrayList<Mansion> list = mansionResponse.getResult();
                        for (Mansion mansion : list){
                            String url = mansion.getPhoto();

                        }
                        return list;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> mansionList.setValue(result),
                        error -> Log.e(TAG, "getMansiones: "+ error.getMessage() ));
    }

    public LiveData<List<Mansion>> getMansionListOfline(){
        return mansionListOfline;
    }

    public void getMansionesOfline(){
        mansionListOfline = repository.getMansionOfline();
    }
}
