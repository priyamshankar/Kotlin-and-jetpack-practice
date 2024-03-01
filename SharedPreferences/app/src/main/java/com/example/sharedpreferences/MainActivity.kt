package com.example.sharedpreferences

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
import com.example.sharedpreferences.ui.theme.SharedPreferencesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SharedPreferencesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    SharedPreferences sharedPrefObj = getSharedpref
//                    Greeting("Android")
                    val sharedPref = getSharedPreferences("mysharedPrefFile", MODE_PRIVATE)
                    val sharedPrefEditObj = sharedPref.edit()
                    sharedPrefEditObj.putString("name","priyam is the name")
                    sharedPrefEditObj.putString("role", "Sde is the role")
                    sharedPrefEditObj.apply()
                    val sharedPrefGetObj = getSharedPreferences("mysharedPrefFile", MODE_PRIVATE)
                    val name = sharedPrefGetObj.getString("name","")
                    val role = sharedPrefGetObj.getString("role","")
                    saveSharedPrefComposableTester(name = name, role = role)
//                    saveSharedPrefComposableTester(name =sharedPrefGetObj.getString("name","") , role =sharedPrefGetObj.getString("role","") )
                }
            }
        }
    }
}

@Composable
fun saveSharedPrefComposableTester(name : String?, role : String?){
//    SharedPreferences sharedPreferences = getSharedPreferences("")
//    val sharedPref =
    Text(text = "$name" +
            " $role")
}