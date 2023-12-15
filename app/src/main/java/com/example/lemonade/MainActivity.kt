package com.example.lemonade

import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) { LimonadaTree() }
            }
        }
    }
}
//hola
@Composable
@Preview(showBackground = true)
fun PreviewMode() {
    LimonadaTree()
}

@Composable
fun LimonadaTree() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Lemonade",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(horizontal = 125.dp, vertical = 25.dp)
                .fillMaxWidth()
        )
    }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var contador by remember { mutableStateOf(0) }//Funcion con Elemento Observador
        val imagenLimonada = when (contador) {
            1 -> R.drawable.lemon_squeeze
            2 -> R.drawable.lemon_drink
            3 -> R.drawable.lemon_restart
            else -> {
                R.drawable.lemon_tree
            }
        }
        val texto = when (contador) {
            1 -> "Keep tapping the lemon to squeeze it"
            2 -> "Tap the lemonade to drink it"
            3 -> "Tap the empty glass to start again"
            else -> {
                "Tap the lemon tree to select a lemon"
            }
        }

        Button(
            onClick = {
                contador++;
                if (contador == 4) {
                    contador = 0
                }// Lambda
            },
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
        )
        {
            Image(
                painter = painterResource(id = imagenLimonada),
                contentDescription = "limonero"
            )
        }

        Spacer(modifier = Modifier.height(25.dp))
        Text(text = texto, fontSize = 18.sp)
    }
}