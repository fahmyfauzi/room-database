package com.csm.roomdatabase.data

import com.csm.roomdatabase.data.models.Word
import kotlinx.coroutines.flow.Flow

//interface wordLocalDatabase : akan diimplementasikan oleh kelas-kelas yang bertanggung jawab terhadap interaksi dengan sumber data lokal, seperti database lokal atau penyimpanan lokal lainnya.
interface WordLocalDataSource {
    fun getAllWords() : Flow<List<Word>>
    suspend fun insertWord(word: Word): Long
}