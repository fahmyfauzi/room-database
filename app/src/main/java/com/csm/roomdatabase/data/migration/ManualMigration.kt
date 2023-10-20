package com.csm.roomdatabase.data.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val migration2To3 = object : Migration(2,3){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE word_table ADD COLUMN year INTEGER NOT NULL DEFAULT 0")
    }

}