package com.csm.roomdatabase

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.csm.roomdatabase.data.WordDatabase
import com.csm.roomdatabase.data.daos.WordDao
import com.csm.roomdatabase.data.models.Word
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WordTest {

    private lateinit var wordDatabase:WordDatabase
    private lateinit var wordDao:WordDao

    @Before
    fun setup(){
        wordDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            WordDatabase::class.java,
        ).build()

        wordDao = wordDatabase.wordDao()
    }

    @Test
    fun afterInsertingOneWord_mustSeeThatWord()  = runBlocking {
        wordDao.insertWord(Word(word = "abc"))

        val words = wordDao.getWords().toList()
        assertTrue(words.isNotEmpty())
        assertEquals(1,words.size)
        assertEquals("abc",words[0].word)
    }

    @Test
    fun afterInsertingManyWord_mustSeeThatWords() = runBlocking {
        wordDao.insertWord(Word(word = "vvv"))
        wordDao.insertWord(Word(word = "bc"))
        wordDao.insertWord(Word(word = "abc"))
        wordDao.insertWord(Word(word = "jkl"))

        val words = wordDao.getAlphabeticallySort()
        assertEquals(4, words.size)

        //ini test akan error
//        assertEquals("vvv",words[0].word)
//        assertEquals("bc",words[0].word)
//        assertEquals("abc",words[0].word)
//        assertEquals("jkl",words[0].word)


        //success
        assertEquals("abc",words[0].word)
        assertEquals("bc",words[1].word)
        assertEquals("jkl",words[2].word)
        assertEquals("vvv",words[3].word)



    }

    @After
    fun tearDown(){
        wordDatabase.close()
    }


}