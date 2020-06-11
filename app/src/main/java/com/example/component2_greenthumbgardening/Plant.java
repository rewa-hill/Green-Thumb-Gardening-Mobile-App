package com.example.component2_greenthumbgardening;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "plants")
public class Plant implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "plantName")
    private String plantName;

    @ColumnInfo(name ="plantSciName")
    private String plantSciName;

    @ColumnInfo(name = "plantDesc")
    private String plantDesc;

    @ColumnInfo(name = "plantImage")
    private String plantImage;

    public Plant(String plantName, String plantSciName, String plantDesc, String plantImage){
        this.plantName = plantName;
        this.plantSciName = plantSciName;
        this.plantDesc = plantDesc;
        this.plantImage = plantImage;
    }

    @Ignore
    public Plant(){}

    protected Plant(Parcel in){
        id = in.readInt();
        plantName = in.readString();
        plantDesc = in.readString();
        plantSciName = in.readString();
        plantImage = in.readString();
    }

    public static final Creator<Plant> CREATOR = new Creator<Plant>() {
        @Override
        public Plant createFromParcel(Parcel in) {
            return new Plant(in);
        }

        @Override
        public Plant[] newArray(int size) {
            return new Plant[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantSciName() {
        return plantSciName;
    }

    public void setPlantSciName(String plantSciName) {
        this.plantSciName = plantSciName;
    }

    public String getPlantDesc() {
        return plantDesc;
    }

    public void setPlantDesc(String plantDesc) {
        this.plantDesc = plantDesc;
    }

    public String getPlantImage() {
        return plantImage;
    }

    public void setPlantImage(String plantImage) {
        this.plantImage = plantImage;
    }


    @Override
    public String toString(){
        return "Plant(" +
                "plantName='" + plantName + '\'' +
                ", plantSciName='" + plantSciName + '\'' +
                ", plantDesc'" + plantDesc + '\'' +
                ", plantImage'" + plantImage + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(plantName);
        parcel.writeString(plantSciName);
        parcel.writeString(plantDesc);
        parcel.writeString(plantImage);

    }
}
