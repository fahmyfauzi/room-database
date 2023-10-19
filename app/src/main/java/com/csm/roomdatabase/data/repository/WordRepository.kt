package com.csm.roomdatabase.data.repository

import com.csm.roomdatabase.data.WordDatabase
import com.csm.roomdatabase.data.models.Word

//Repository adalah komponen arsitektur yang umumnya digunakan dalam aplikasi Android untuk memisahkan sumber data (dalam hal ini, database) dari lapisan antarmuka pengguna.
class WordRepository(private val wordDatabase:WordDatabase) {
    suspend fun insertWord(word:Word){
        wordDatabase.wordDao().insertWord(word)
    }

     fun getAllWords() = wordDatabase.wordDao().getAllWords()
}