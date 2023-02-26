package com.example.rickandmortycleanarc.data.db

import androidx.room.TypeConverter
import com.example.rickandmortycleanarc.data.model.Origin

class Converters {

    @TypeConverter
    fun fromOrigin(origin: Origin):String{
        return origin.name
    }

    @TypeConverter
    fun toOrigin(name:String):Origin{
        return Origin(name,name)
    }


}