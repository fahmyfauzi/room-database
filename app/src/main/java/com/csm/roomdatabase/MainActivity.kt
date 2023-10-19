package com.csm.roomdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.csm.roomdatabase.data.WordDatabase
import com.csm.roomdatabase.data.repository.WordRepository
import com.csm.roomdatabase.ui.theme.RoomDatabaseTheme

class MainActivity : ComponentActivity() {

    //by lazy, yang artinya objek MainViewModel akan diinisialisasi hanya saat pertama kali digunakan.
    private val viewModel:MainViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelFactory(WordRepository(WordDatabase.getDatabaseInstance(this)))
        ).get(MainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomDatabaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(viewModel)
                }
            }
            // akan mengamati perubahan data yang diambil dari ViewModel.
            viewModel.getAllWords().observe(this){
                println(it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(viewModel: MainViewModel) {
    var text by remember {
        mutableStateOf("word")
    }

    Column {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "Label") }
        )
        Button(onClick = { viewModel.addWord(text) }) {
            Text(text = "Insert")
        }
    }

}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    RoomDatabaseTheme {
//        Greeting("Android")
//    }
//}