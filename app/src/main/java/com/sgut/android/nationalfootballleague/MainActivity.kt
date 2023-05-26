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

                val evens = Array(3) {Array(3) {'*'} }
//                evens.map { println(it.contentToString() )}

                for (  i in 0.. evens.size-1){
                    evens[evens.size-1][i] = 'S'

                }
                evens.map { println(it.contentToString() )}
//                println(evens.contentToString())
            }
        }
    }
}


