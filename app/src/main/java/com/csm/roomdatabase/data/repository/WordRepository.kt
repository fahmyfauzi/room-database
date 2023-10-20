package com.csm.roomdatabase.data.repository

import com.csm.roomdatabase.data.WordDatabase
import com.csm.roomdatabase.data.WordLocalDataSource
import com.csm.roomdatabase.data.daos.WordDao
import com.csm.roomdatabase.data.models.Word
import javax.inject.Inject

//Repository adalah komponen arsitektur yang umumnya digunakan dalam aplikasi Android untuk memisahkan sumber data (dalam hal ini, database) dari lapisan antarmuka pengguna.

//Anotasi @Inject digunakan untuk memberitahu Hilt bahwa kelas WordRepository adalah kelas yang dapat diinjeksi, yang berarti Hilt akan mengambil alih pembuatan instance kelas ini dan menyediakan instance yang diperlukan ke konstruktor

//WordLocalDataSource : Ini adalah implementasi konkrit yang digunakan untuk berkomunikasi dengan data lokal seperti database atau penyimpanan lokal.
class WordRepository @Inject constructor(private val localDataSource: WordLocalDataSource) {
    suspend fun insertWord(word:Word){
       localDataSource.insertWord(word)
    }

     fun getAllWords() = localDataSource.getAllWords()
}