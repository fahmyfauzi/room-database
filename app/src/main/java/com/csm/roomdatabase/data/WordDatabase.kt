package com.csm.roomdatabase.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.csm.roomdatabase.data.converters.RoomConverters
import com.csm.roomdatabase.data.daos.WordDao
import com.csm.roomdatabase.data.models.Word

@Database(
    entities = [Word::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(RoomConverters::class)
abstract class WordDatabase:RoomDatabase() {
    abstract fun wordDao():WordDao


}