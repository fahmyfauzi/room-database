package com.csm.roomdatabase.data.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.csm.roomdatabase.data.RoomWordDataSource
import com.csm.roomdatabase.data.WordDatabase
import com.csm.roomdatabase.data.WordLocalDataSource
import com.csm.roomdatabase.data.daos.WordDao
import com.csm.roomdatabase.data.migration.migration2To3
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module //menandai kelas RoomModule sebagai modul Hilt.
@InstallIn(SingletonComponent::class) //Ini adalah anotasi yang digunakan untuk memberitahu Hilt di komponen mana modul ini akan diinstal
//SingletonComponent::class  yang berarti dependensi yang didefinisikan dalam modul ini akan memiliki siklus hidup aplikasi dan berbagi instance yang sama selama aplikasi berjalan

object RoomModule {

    @Provides // Ini adalah anotasi yang digunakan untuk menandai metode yang menyediakan dependensi

    //Metode ini menyediakan instance dari kelas WordDatabase. Anotasi @ApplicationContext digunakan untuk memberi tahu Hilt bahwa parameter context yang diperlukan adalah konteks aplikasi. Metode ini menggunakan Room.databaseBuilder untuk membangun dan mengonfigurasi instance database Room.
    fun providerWordDatabase(@ApplicationContext context: Context):WordDatabase{
        return Room.databaseBuilder(
            context,
            WordDatabase::class.java,
            "word.db"
        ).addMigrations(migration2To3).build()
    }

    @Provides
    fun providerWordDao(wordDatabase: WordDatabase):WordDao{
        return wordDatabase.wordDao()
    }

    //mendefinisikan fungsi yang akan menyediakan implementasi dari WordLocalDataSource yang akan digunakan dalam aplikasi
    @Provides
    //Ini adalah fungsi yang akan memberikan implementasi dari WordLocalDataSource
    fun provideLocalWordDataSource(wordDao: WordDao):WordLocalDataSource {
        return RoomWordDataSource(wordDao)
    }
}

//Dengan konfigurasi ini, Hilt akan secara otomatis menghasilkan kode yang diperlukan untuk menginjeksi WordDatabase dan WordDao ke dalam kelas yang membutuhkannya. Selain itu, modul ini mengizinkan Anda untuk menggantinya atau memodifikasinya dengan mudah jika Anda ingin menyediakan implementasi lain atau konfigurasi yang berbeda untuk database atau DAO.