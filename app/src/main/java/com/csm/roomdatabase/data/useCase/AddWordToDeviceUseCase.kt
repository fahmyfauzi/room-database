package com.csm.roomdatabase.data.useCase

import com.csm.roomdatabase.data.models.Word
import com.csm.roomdatabase.data.repository.WordRepository
import javax.inject.Inject

class AddWordToDeviceUseCase @Inject constructor(private val wordRepository:WordRepository) {
    suspend operator fun invoke(word:Word){
        wordRepository.insertWord(word)
    }
}

//use case untuk memudahkan pengujian dan pemeliharaan. Use case ini menghubungkan antara antarmuka pengguna (UI) dan lapisan data dengan cara yang bersih dan terorganisir.