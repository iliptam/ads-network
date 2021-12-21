package com.iliptam.adnetwork.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "cam_body")
public class CamBody {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "ad_id")
    public int adId;

    @ColumnInfo(name = "adBodyId")
    public String adBodyId;

    @ColumnInfo(name = "body")
    public String body;

    public CamBody(int adId, String adBodyId, String body) {
        this.adId = adId;
        this.adBodyId = adBodyId;
        this.body = body;
    }
}
