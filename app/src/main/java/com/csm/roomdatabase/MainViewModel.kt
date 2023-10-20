package com.csm.roomdatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.csm.roomdatabase.data.models.Word
import com.csm.roomdatabase.data.repository.WordRepository
import com.csm.roomdatabase.data.useCase.AddWordToDeviceUseCase
import com.csm.roomdatabase.data.useCase.GetAllWordsToDeviceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel // anotasi yang digunakan untuk menandai kelas ViewModel sebagai kelas yang akan diinjeksikan oleh Hilt

//ViewModel berperan sebagai jembatan antara lapisan antarmuka pengguna (UI) dan lapisan bisnis/data
class MainViewModel @Inject constructor(
    private val getAllWordsToDeviceUseCase: GetAllWordsToDeviceUseCase,
    private val addWordToDeviceUseCase: AddWordToDeviceUseCase
    ) : ViewModel() {
    //hasil dikembalikan dari wordRepository di ubah jadi LiveData. Ini memungkinkan lapisan UI untuk mengamati (observe) perubahan data dengan mudah.
    fun getAllWords() = getAllWordsToDeviceUseCase().asLiveData(viewModelScope.coroutineContext)


    fun addWord(word: String) = viewModelScope.launch {
        addWordToDeviceUseCase(Word(word=word))
    }

}
