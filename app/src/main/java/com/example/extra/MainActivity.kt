package com.example.extra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainActivityContent() {
    Surface(color = Color.White) {
        allButtons()
    }
}

// Clase MainActivity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Invoca la función MainActivityContent()
            MainActivityContent()
        }
    }
}

@Composable
fun allButtons() {
    Column {
        Text(text = "Buttons", style = typography.headlineLarge,
            modifier = Modifier.padding(8.dp)
        )
        val customColor = Color(0xFF109D58) //Color T
        val ButtonColor = ButtonDefaults.buttonColors( //Color T
            containerColor = customColor,
            contentColor = MaterialTheme.colorScheme.surface
        )
        // Column para el primer grupo de botones
        Row {
            // Create a Main Button or Normal Button
            Button(
                colors = ButtonColor,
                onClick = {},
                modifier = Modifier.padding(8.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Main Button")
            }
            // Create a Text Button
            TextButton(
                colors = ButtonColor,
                onClick = {},
                modifier = Modifier.padding(8.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Text Button")
            }
        }

        // Espacio vertical entre grupos de botones
        Spacer(modifier = Modifier.height(16.dp))

        // Column para el segundo grupo de botones
        Row {
            // Elevated Button
            Button(
                colors = ButtonColor,
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Elevated Button")
            }

            // Rounded Button
            Button(
                colors = ButtonColor,
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = "Rounded")
            }
        }

        // Espacio vertical entre grupos de botones
        Spacer(modifier = Modifier.height(16.dp))


        val customTextColor = Color(0xFF109D58) //Color T
        // Column para el tercer grupo de botones
        Row {
            // Outlined Button
            // add border field and set BorderStroke and its color
            OutlinedButton(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, Color.Red),
                modifier = Modifier.padding(8.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Outlined", color = customTextColor)
            }

            // Outlined Button with icon
            // add border field and set BorderStroke and its color
            // add Icon field
            OutlinedButton(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, Color.Red),
                modifier = Modifier.padding(8.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = customTextColor, //Color I
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(text = "Outlined Icon", color = customTextColor)
            }
        }

        // Column para el cuarto grupo de botones
        Row {
            // Icon Button
            // Icon on the left of text
            Button(colors = ButtonColor,onClick = {}, modifier = Modifier.padding(8.dp),shape = RoundedCornerShape(8.dp)) {
                Row {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 4.dp),
                    )
                    Text(text = "Icon Button")
                }
            }

            // Icon Button
            // Icon on the Right of text
            Button(colors = ButtonColor,onClick = {}, modifier = Modifier.padding(8.dp),shape = RoundedCornerShape(8.dp)) {
                Text(text = "Icon Button")
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }

        //custom background buttons
        // create a variable mainButtonColor and define background Color and content Color
        val mainButtonColor = ButtonDefaults.buttonColors(
            containerColor = Color.Magenta,
            contentColor = MaterialTheme.colorScheme.surface
        )

        // Column para el quinto grupo de botones
        Row {
            Button(colors = mainButtonColor, onClick = {},
                modifier = Modifier
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp)
            )
            {
                Text(text = "Custom colors")
            }
        }

        val customGradientColor = Color(0xFF109D58)
        val blackColor = Color.Black
        // Column para el sexto grupo de botones
        Row {
            // Create variable horizontalGradient and inside color property define start and end color
            val horizontalGradient = Brush.horizontalGradient(
                colors = listOf(customGradientColor, blackColor),
                0f,
                250f
            )
            // Horizontal gradient Button
            // Create a text and set its background to horizontalGradient that we created above
            Text(
                text = "Horizontal gradient",
                style = typography.bodyMedium.copy(color = Color.White),
                modifier = Modifier
                    .padding(12.dp)
                    .clickable(onClick = {})
                    .clip(RoundedCornerShape(4.dp))
                    .background(brush = horizontalGradient)
                    .padding(12.dp)
            )

            // Create variable verticalGradient and inside color property define top and bottom color
            val verticalGradient = Brush.verticalGradient(
                colors = listOf(customGradientColor, blackColor),
                startY = 0f,
                endY = 100f
            )
            // Vertical gradient Button
            // Create a text and set its background to verticalGradient that we created above
            Text(
                text = "Vertical gradient",
                style = typography.bodyLarge.copy(color = Color.White),
                modifier = Modifier
                    .padding(12.dp)
                    .clickable(onClick = {})
                    .clip(RoundedCornerShape(4.dp))
                    .background(brush = verticalGradient)
                    .padding(12.dp)
            )
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    allButtons()
}
