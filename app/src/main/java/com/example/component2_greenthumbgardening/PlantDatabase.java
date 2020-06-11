package com.example.component2_greenthumbgardening;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Plant.class}, version = 1)
public abstract class PlantDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "plants_db";

    private static PlantDatabase instance;

    static PlantDatabase getInstance(final Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    PlantDatabase.class,
                    DATABASE_NAME
            ).build();
        }
        return  instance;
    }

    public abstract PlantDao getPlantDao();
}
