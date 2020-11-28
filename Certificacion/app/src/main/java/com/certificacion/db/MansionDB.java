package com.certificacion.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.certificacion.model.Mansion;

@Database(entities = {Mansion.class},version = 2,exportSchema = false)
public abstract class MansionDB extends RoomDatabase {
    public abstract MansionDao mansionDao();
}
