package com.csm.roomdatabase.data.useCase

import com.csm.roomdatabase.data.models.Word
import com.csm.roomdatabase.data.repository.WordRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllWordsToDeviceUseCase @Inject constructor(private val wordRepository: WordRepository) {
    operator fun invoke() : Flow<List<Word>>{
        return wordRepository.getAllWords()
    }
}