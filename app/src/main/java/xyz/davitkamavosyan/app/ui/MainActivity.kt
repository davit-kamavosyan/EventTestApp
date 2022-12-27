package xyz.davitkamavosyan.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.getViewModel
import xyz.davitkamavosyan.app.ui.navigation.NavigationGraph
import xyz.davitkamavosyan.app.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            navController.setLifecycleOwner(this)
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    NavigationGraph(
                        navController = navController,
                        navigationViewModel = getViewModel()
                    )
                }
            }
        }
    }
}