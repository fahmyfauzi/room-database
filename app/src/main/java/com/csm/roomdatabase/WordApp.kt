package com.csm.roomdatabase

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


// @HiltAndroidApp : WordApp adalah kelas aplikasi yang akan di-injeksi oleh Hilt. Dengan kata lain, Hilt akan mengelola komponen aplikasi dan pengelolaan penyediaan dependensi dalam kelas WordApp.
@HiltAndroidApp
class WordApp : Application()