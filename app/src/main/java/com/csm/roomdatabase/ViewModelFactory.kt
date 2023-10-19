package com.csm.roomdatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.csm.roomdatabase.data.repository.WordRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(private val wordRepository: WordRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        //apakah tipe modelClass yang diminta adalah assignable (dapat ditugaskan) sebagai MainViewModel.
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            //true jika modelClass adalah  MainViewModel, yang berarti ViewModel yang diminta adalah MainViewModel.
            return MainViewModel(wordRepository) as T
        }

        //Jika modelClass tidak sesuai dengan tipe MainViewModel, maka fungsi ini akan melempar pengecualian (exception) IllegalArgumentException. Ini berarti bahwa ViewModel dengan kelas yang diminta tidak dikenal, dan Anda akan mendapatkan pesan kesalahan yang sesuai.
        throw IllegalArgumentException("unknown view model class")
    }
}