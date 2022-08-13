package com.example.rccar

import android.text.Layout
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.End
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController=navController)
        }
        composable(
            route=Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name")
                {
                    type= NavType.StringType
                    defaultValue="Hello"
                    nullable= true
                }
            )
        ) { entry->
            DetailScreen(name = entry.arguments?.getString("name"),navController )
        }
    }
}

@Composable
fun MainScreen(navController: NavController){
    var text by remember {
        mutableStateOf("")
    }
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
            ){
                TextField(
                    value = text,
                    onValueChange = {
                                    text = it
                },
                    modifier = Modifier.fillMaxWidth()

                )
                Spacer(
                    modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        navController.navigate(Screen.DetailScreen.withArgs(text))
                },
                    modifier = Modifier.align(Alignment.End)
                )

                {
                    Text(text = "To DetailScreen")
                }

    }
}

@Composable
fun DetailScreen(name : String?,navController: NavController)
{
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
            ){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(text = "Hello,$name")
                }
                Spacer(
                    modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        navController.navigate(Controls.Controller.route)
                    },
                    modifier = Modifier.align(Alignment.End)
                )
                {
                    Text(text = "Start")
                }
    }

}

@Composable
fun Controller(name:String?, navController: NavController)
{
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ){
        //left
        Button(
            onClick = {
                navController.navigate(Controls.Left.route)
            },
            modifier = Modifier.align(Alignment.End)
        )
        {
            Text(text = "Left")
        }
        Spacer(
            modifier = Modifier.height(8.dp)
        )

        //right
        Button(
            onClick = {
                navController.navigate(Controls.Right.route)
            },
            modifier = Modifier.align(Alignment.End)
        )
        {
            Text(text = "Right")
        }
        Spacer(
            modifier = Modifier.height(8.dp)
        )

        //forward
        Button(
            onClick = {
                navController.navigate(Controls.Forward.route)
            },
            modifier = Modifier.align(Alignment.End)
        )
        {
            Text(text = "Forward")
        }
        Spacer(
            modifier = Modifier.height(8.dp)
        )

        //backward
        Button(
            onClick = {
                navController.navigate(Controls.Backward.route)
            },
            modifier = Modifier.align(Alignment.End)
        )
        {
            Text(text = "Backward")
        }
    }
}