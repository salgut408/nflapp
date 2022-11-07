package com.sgut.android.nationalfootballleague


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sgut.android.nationalfootballleague.homelistscreen.TeamCardsList
import com.sgut.android.nationalfootballleague.teamdetails.TeamDetailScreen
import com.sgut.android.nationalfootballleague.ui.theme.NationalFootballLeagueTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NationalFootballLeagueTheme {
                // A surface container using the 'background' color from the theme



                TeamCardsList()
//                    TeamDetailScreen()



            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NationalFootballLeagueTheme {
        Greeting("Android")
    }
}