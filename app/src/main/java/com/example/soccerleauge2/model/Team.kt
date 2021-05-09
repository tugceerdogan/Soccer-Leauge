package com.example.soccerleauge2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Team(

    @ColumnInfo(name = "name")
    @SerializedName("name")
    val takimAdi : String?,

    @ColumnInfo(name = "gorsel")
    @SerializedName("gorsel")
    val takimGorsel : String?,) {


    @PrimaryKey(autoGenerate = true)
    var uuid :Int =0


}


