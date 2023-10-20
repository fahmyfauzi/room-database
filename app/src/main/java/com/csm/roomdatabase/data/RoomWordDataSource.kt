package com.csm.roomdatabase.data

import com.csm.roomdatabase.data.daos.WordDao
import com.csm.roomdatabase.data.models.Word
import kotlinx.coroutines.flow.Flow

//WordLocalDataSource :  Ini adalah implementasi dari data source lokal (local data source) yang berhubungan dengan Room

//Dengan menggunakan RoomWordDataSource, Anda mengabstraksi semua operasi database Room terkait dengan kata dan memungkinkan lapisan bisnis (business logic) atau ViewModel untuk berinteraksi dengan sumber data lokal tanpa harus tahu detail implementasi database. Ini adalah contoh bagaimana prinsip Clean Architecture digunakan untuk memisahkan lapisan data dari lapisan bisnis dalam sebuah aplikasi.
class RoomWordDataSource(private val wordDao: WordDao) : WordLocalDataSource {
    override fun getAllWords(): Flow<List<Word>> {
        return wordDao.getAllWords()
    }

    override suspend fun insertWord(word: Word):Long {
        return wordDao.insertWord(word)
    }
}