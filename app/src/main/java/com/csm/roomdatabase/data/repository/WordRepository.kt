package com.csm.roomdatabase.data.repository

import com.csm.roomdatabase.data.WordDatabase
import com.csm.roomdatabase.data.daos.WordDao
import com.csm.roomdatabase.data.models.Word
import javax.inject.Inject

//Repository adalah komponen arsitektur yang umumnya digunakan dalam aplikasi Android untuk memisahkan sumber data (dalam hal ini, database) dari lapisan antarmuka pengguna.

//Anotasi @Inject digunakan untuk memberitahu Hilt bahwa kelas WordRepository adalah kelas yang dapat diinjeksi, yang berarti Hilt akan mengambil alih pembuatan instance kelas ini dan menyediakan instance yang diperlukan ke konstruktor
class WordRepository @Inject constructor(private val wordDao: WordDao) {
    suspend fun insertWord(word:Word){
       wordDao.insertWord(word)
    }

     fun getAllWords() = wordDao.getAllWords()
}