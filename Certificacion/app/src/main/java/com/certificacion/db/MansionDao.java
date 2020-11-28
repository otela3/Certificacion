package com.certificacion.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.certificacion.model.Mansion;

import java.util.List;
@Dao
public interface MansionDao {

    @Insert
    void insertMansiones(Mansion mansion);

    @Query("SELECT * FROM mansion_list")
    LiveData<List<Mansion>> getMansionesOfline();
}
