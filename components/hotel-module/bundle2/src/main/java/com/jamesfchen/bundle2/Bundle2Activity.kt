package com.jamesfchen.bundle2

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.blankj.utilcode.util.SDCardUtils
import com.jamesfchen.bundle2.ui.theme.SpacecraftAndroidTheme
import java.io.File
import java.nio.charset.Charset

class Bundle2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val file = File("/data/local/tmp/uidump.xml")
        file.inputStream().use {fis->
                val content =fis.reader().readText()
                Log.d("cjf","content:${content}")
        }
        setContent {
            SpacecraftAndroidTheme {
                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("hotel bundle2")
//                }
                ArtistCard{
//                    startActivity(FlutterActivity.createDefaultIntent(Bundle2Activity.this))
                }
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
    SpacecraftAndroidTheme {
        Greeting("hotel bundle2")
    }
}

@Composable
fun ArtistCard(onClick: () -> Unit) {
    Column {
        Text("Alfred Sisley")
        Text("3 minutes ago")
        Button(onClick =onClick) {

        }
    }
}