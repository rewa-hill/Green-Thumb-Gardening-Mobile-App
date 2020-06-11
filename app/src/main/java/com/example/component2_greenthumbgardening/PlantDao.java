package com.example.component2_greenthumbgardening;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PlantDao {

    @Insert
    long[] insertPlants(Plant... plants);

    @Query("SELECT * FROM plants")
    LiveData<List<Plant>> getPlants();

    @Delete
    int delete(Plant... plants);

    @Update
    int updatePlants(Plant... plants);
}
