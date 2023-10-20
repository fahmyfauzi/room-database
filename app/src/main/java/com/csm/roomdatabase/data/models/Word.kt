package com.csm.roomdatabase.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "word_table",indices = [Index(value = ["word"], unique = true)]) //index/ndces untuk mempercepat query
data class Word(
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    var word:String="",
    @Ignore var counter:Int=0,
//    @ColumnInfo(name = "createDate")
    var createdDate: Date =Date() ,//SQLite tidak memiliki tipe data yang mendukung langsung penyimpanan tanggal (Date), maka harus di converter

    @ColumnInfo(defaultValue = "0")
    var year:Int = 0
)
