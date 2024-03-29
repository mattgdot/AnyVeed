package com.app.anyveed

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.app.anyveed.ui.navigation.BottomNavigationBar
import com.app.anyveed.ui.navigation.NavGraph
import com.app.anyveed.ui.theme.AnyVeedTheme
import com.yausername.youtubedl_android.YoutubeDL.getInstance
import com.yausername.youtubedl_android.YoutubeDLException


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)

        try {
            getInstance().init(this)
        } catch (e: YoutubeDLException) {
            Toast.makeText(this, "Failed to initialize youtubedl-android", Toast.LENGTH_LONG).show()
        }

        setContent {
            val navController = rememberNavController()
            AnyVeedTheme {
                Scaffold(bottomBar = {
                    BottomAppBar {
                        BottomNavigationBar(navController = navController)
                    }
                }) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                PaddingValues(
                                    0.dp,
                                    innerPadding.calculateTopPadding(),
                                    0.dp,
                                    innerPadding.calculateBottomPadding()
                                )
                            )
                            .safeDrawingPadding()
                    ) {
                        NavGraph(navController = navController)
                    }
                }
            }
        }
    }
}