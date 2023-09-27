package com.example.learningcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.ui.theme.LearningComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeTheme {
                var count by mutableStateOf(0)
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                    ,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = count.toString())
                    Button(onClick = {

                    }){
                        Text(text = "Click me!")
                    }
                }


            }
        }
    }
}

/*
* This is used to show
* How to use a box
* How to use column and row
* How to use a modifier
* Super classes and sub classes
* */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    /*
    * If you use the texts without the column function they would just write one over the other
    * This way they would be one after the other
    * Box is the super component to Columns and Rows
    * Then columns and rows are extend on the modifiers set by the super component
    * */
    Box (
        modifier = Modifier
            .size(400.dp),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
//            .fillMaxSize() // would fill the whole page
        ){
            Text(
                text = "Hello $name!",
                color = Color.Blue,
                fontSize = 30.sp,
                /*
                * this is a composable exclusive
                * Modifier works sequentially
                * So each modifier works one after the other
                * */
                modifier = Modifier
                    .background(Color.Yellow)
                    .padding(16.dp) // this adds space on the left and right like padding
                    .background(Color.Green)
            )

            Text(
                text = "Some Other Text",
                color = Color.Blue,
                fontSize = 30.sp,
            )
        }
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .align(Alignment.TopCenter)
//            .fillMaxSize() // would fill the whole page
        ){
            Text(
                text = "Hello $name!",
                color = Color.Blue,
                fontSize = 30.sp,
                /*
                * this is a composable exclusive
                * Modifier works sequentially
                * So each modifier works one after the other
                * */
                modifier = Modifier
                    .background(Color.Yellow)
                    .padding(16.dp) // this adds space on the left and right like padding
                    .background(Color.Green)
            )

            Text(
                text = "Some Other Text",
                color = Color.Blue,
                fontSize = 30.sp,
            )
        }
    }



}

/*
* This is used to show
* how to use images
* how to use icons
* how to use for loops and if statements
* */
@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier){
    Column {
        if (name.length > 5) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier.background(Color.Black)
            )
        }else {
            Row {
                for (i in 1..10){
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                }

            }
        }
    }
}

/*
* How to make lists using lazy columns and lazy rows
* */
@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier){
    LazyColumn(modifier = Modifier
        .fillMaxSize()) {

        items(10){i ->
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp),
            )
        }

    }
}

