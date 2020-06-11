package com.example.component2_greenthumbgardening;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;

import java.util.List;

public class PlantRepository {

    private PlantDatabase mPlantDatabase;

    public PlantRepository(Context context) {
        mPlantDatabase = PlantDatabase.getInstance(context);
    }

    public void insertNoteTask(Plant plant){
        new InsertAsyncTask(mPlantDatabase.getPlantDao()).execute(plant);
    }

    public void updateNoteTask(Plant plant){
        new UpdateAsyncTask(mPlantDatabase.getPlantDao()).execute(plant);
    }

    public LiveData<List<Plant>> retrieveNotesTask() {
        return mPlantDatabase.getPlantDao().getPlants();
    }

    public void deleteNoteTask(Plant plant){
        new DeleteAsyncTask(mPlantDatabase.getPlantDao()).execute(plant);
    }

    public static class InsertAsyncTask extends AsyncTask<Plant,Void,Void>{
        private PlantDao mPlantDao;

        public InsertAsyncTask(PlantDao dao) {
            mPlantDao = dao;
        }


        @Override
        protected Void doInBackground(Plant... plants) {
            mPlantDao.insertPlants(plants);
            return null;
        }
    }

    public static class DeleteAsyncTask extends AsyncTask<Plant,Void,Void>{
        private PlantDao mPlantDao;

        public DeleteAsyncTask(PlantDao dao) {
            mPlantDao = dao;
        }


        @Override
        protected Void doInBackground(Plant... plants) {
            mPlantDao.insertPlants(plants);
            return null;
        }
    }

    public static class UpdateAsyncTask extends AsyncTask<Plant,Void,Void>{
        private PlantDao mPlantDao;

        public UpdateAsyncTask(PlantDao dao) {
            mPlantDao = dao;
        }


        @Override
        protected Void doInBackground(Plant... plants) {
            mPlantDao.updatePlants(plants);
            return null;
        }
    }
}
