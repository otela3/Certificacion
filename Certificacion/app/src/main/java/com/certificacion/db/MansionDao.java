package com.certificacion.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.certificacion.model.Mansion;

import java.util.List;
@Dao
public interface MansionDao {

    @Query("SELECT * FROM mansion_list")
    LiveData<List<Mansion>> getMansionesOfline();
}
