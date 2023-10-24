package com.csm.roomdatabase

import androidx.room.testing.MigrationTestHelper
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.csm.roomdatabase.data.WordDatabase
import com.csm.roomdatabase.data.migration.migration2To3
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RoomMigrationTest {

    val databaseName = "wordsdb"

    @get:Rule
    val testHelper =   MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        WordDatabase::class.java
    )
    @Test
    fun testMigration1To2 (){
        val database = testHelper.createDatabase(databaseName,1).apply {
            execSQL("INSERT INTO word_table VALUES (1,'some word',1698111465338)")
        }

        testHelper.runMigrationsAndValidate(databaseName,2,true)

        val cursor =database.query("SELECT * FROM word_table")
        assertArrayEquals(arrayOf("id","word","created"),cursor.columnNames)
    }

//    @Test
//    fun testMigration2To3 (){
//        val database = testHelper.createDatabase(databaseName,2).apply {
//            execSQL("INSERT INTO word_table  VALUES (1,'some word',1698111465338)")
//        }
//
//        testHelper.runMigrationsAndValidate(databaseName,3,true, migration2To3)
//
//        val cursor =database.query("SELECT * FROM word_table")
//        assertArrayEquals(arrayOf("id","word","created","year"),cursor.columnNames)
//        cursor.moveToFirst()
//        assertEquals(1,cursor.getInt(3))
//    }
}