package com.certificacion.db;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.certificacion.model.Mansion;

import java.util.List;

public interface MansionDao {

    @Query("SELECT * FROM mansion_list")
    LiveData<List<Mansion>> getMansionesOfline();
}
