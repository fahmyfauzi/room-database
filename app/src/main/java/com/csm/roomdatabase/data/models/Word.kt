package com.csm.roomdatabase.data.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "word_table",indices = [Index(value = ["word"], unique = true)]) //index/ndces untuk mempercepat query
data class Word(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val word:String,
    @Ignore val counter:Int,
    val createdDate: Date //SQLite tidak memiliki tipe data yang mendukung langsung penyimpanan tanggal (Date), maka harus di converter
)
