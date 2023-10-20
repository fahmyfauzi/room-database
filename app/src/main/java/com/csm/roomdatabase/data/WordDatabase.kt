package com.csm.roomdatabase.data


import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.AutoMigrationSpec
import com.csm.roomdatabase.data.converters.RoomConverters
import com.csm.roomdatabase.data.daos.WordDao
import com.csm.roomdatabase.data.migration.Migration1To2
import com.csm.roomdatabase.data.models.Word

@Database(
    entities = [Word::class],
    version = 3,
    exportSchema = true,
    autoMigrations = [AutoMigration(
        from = 1,
        to = 2,
        spec = Migration1To2::class
    )]
)

@TypeConverters(RoomConverters::class)
abstract class WordDatabase:RoomDatabase() {
    abstract fun wordDao():WordDao


}