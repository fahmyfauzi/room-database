package com.csm.roomdatabase.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.csm.roomdatabase.data.models.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word:Word) :Long //Fungsi ini menerima parameter word yang merupakan objek dari kelas Word yang akan dimasukkan ke database. Fungsi ini juga mengembalikan nilai bertipe Long, yang merupakan ID dari kata yang baru dimasukkan. Biasanya, nilai ini digunakan untuk tujuan identifikasi jika Anda perlu mengakses data tersebut lagi nantinya.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWords(word:List<Word>):List<Long>

    @Delete
    suspend fun deleteWord(word:Word):Int

    @Update(onConflict = OnConflictStrategy.ABORT)
    suspend fun updateWord(word:Word):Int

    @Query("SELECT * FROM word_table")
    fun getAllWords(): Flow<List<Word>>
    //Flow adalah salah satu bagian dari Kotlin Coroutines, yang digunakan untuk mengirim aliran (stream) data asinkron. Dalam hal ini, Flow digunakan untuk mengamati perubahan data dalam tabel "word_table".

    //coba test room database
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabeticallySort(): List<Word>

    @Query("SELECT * FROM word_table")
    fun getWords():List<Word>
}