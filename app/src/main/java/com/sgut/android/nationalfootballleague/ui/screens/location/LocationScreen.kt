package com.sgut.android.nationalfootballleague.ui.screens.location

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

//@OptIn(ExperimentalPermissionsApi::class, ExperimentalAnimationApi::class)
//@Composable
//fun LocationScreen(
//    locationViewModel: LocationViewModel = hiltViewModel(),
//) {
//    val locationPermissions = rememberMultiplePermissionsState(
//        permissions = listOf(
//            android.Manifest.permission.ACCESS_COARSE_LOCATION,
//            android.Manifest.permission.ACCESS_FINE_LOCATION
//
//        )
//    )
//    LaunchedEffect(key1 = locationPermissions.allPermissionsGranted) {
//        if(locationPermissions.allPermissionsGranted) {
//            locationViewModel.getCurrentLocation()
//        }
//    }
//
//    val currentLocation = locationViewModel.currentLocation
//    Box(
//        modifier = Modifier.fillMaxWidth(),
//        contentAlignment = Alignment.Center
//    ) {
//        AnimatedContent(
//            targetState = locationPermissions.allPermissionsGranted
//        ) { areGranted ->
//            Column (
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.spacedBy(10.dp)
//                    ) {
//                if(areGranted){
//                    Text(text = "${currentLocation?.latitude ?: 0.0} ${currentLocation?.longitude ?: 0.0}")
//                    Button(
//                        onClick = { locationViewModel.getCurrentLocation() }
//                    ) {
//                        Text(text = "GET CURRENT LOCATION")
//                    }
//                } else {
//                    Text(text = "WE NEED UR CURRENT LOCATION - PERMISSIONS")
//                    Button(onClick = { locationPermissions.launchMultiplePermissionRequest()}) {
//                        Text(text = "ACCEPT")
//                    }
//                }
//            }
//
//        }
//    }
//}