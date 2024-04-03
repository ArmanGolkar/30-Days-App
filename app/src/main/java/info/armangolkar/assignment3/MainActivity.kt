package info.armangolkar.assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import info.armangolkar.assignment3.ui.theme.Assignment3Theme
import info.armangolkar.assignment3.MainScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue

import androidx.compose.runtime.remember


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment3Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val imageId = arrayOf(
                        R.drawable.p1,
                        R.drawable.p2,
                        R.drawable.p3,
                        R.drawable.p4,
                        R.drawable.p5,
                        R.drawable.p6
                    )

                    val names = arrayOf(
                        "Peperoni",
                        "Vegan",
                        "4Cheese",
                        "Margaritta",
                        "American",
                        "Mexican"
                    )

                    val ingredients = arrayOf(
                        "Tomato sos, cheese, oregano, peperoni",
                        "Tomato sos, cheese, oregano, spinach, green paprika, rukola",
                        "Tomato sos, oregano, mozzarella, goda, parmesan, cheddar",
                        "Tomato sos, cheese, oregano, bazillion",
                        "Tomato sos, cheese, oregano, green paprika, red beans",
                        "Tomato sos, cheese, oregano, corn, jalapeno, chicken",
                    )

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainScreen") {
                        composable(route = "MainScreen") {
                            MainScreen(imageId, names, ingredients )
                        }
                    }

                }
            }
        }
    }
}

