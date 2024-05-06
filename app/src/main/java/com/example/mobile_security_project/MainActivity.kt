package com.example.mobile_security_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mobile_security_project.ui.interfaces.LoginForm

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val  = rememberNavController()
//            NavHost(navController = navController, startDestination = "login_screen", builder = {
//                composable("login_screen",){
//                    LoginForm(navController)
//                }
//                composable("chucknorris_screen",){
//                    ChuckNorrisForm()
//                }
//            })
            LoginForm()
           // LoginForm()
//            MobilesecurityprojectTheme {
//                Greeting("Android")
//            }
        }
    }
}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Surface {
//        Column(
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.fillMaxSize()
//        ) {
//            Text(
//                text = "Hello $name!",
//                modifier = modifier
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    MobilesecurityprojectTheme {
//        Greeting("Android")
//    }
//}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreviewDark() {
//    MobilesecurityprojectTheme(darkTheme = true) {
//        Greeting("Android")
//    }
//}