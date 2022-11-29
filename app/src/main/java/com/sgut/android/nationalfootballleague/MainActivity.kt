package com.sgut.android.nationalfootballleague


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sgut.android.nationalfootballleague.ui.theme.NationalFootballLeagueTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NationalFootballLeagueTheme {


                EspnApp()



            }
        }
    }
}


