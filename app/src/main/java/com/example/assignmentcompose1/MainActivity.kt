package com.example.assignmentcompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignmentcompose1.ui.theme.AssignmentCompose1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentCompose1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen( modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var showUsername by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf("") }
    val counter2 by remember { mutableStateOf(0) }
    val counter3 by remember { mutableStateOf(0) }
  Column(modifier = modifier.fillMaxSize(),
  horizontalAlignment = Alignment.CenterHorizontally){
          TextField(value = username, onValueChange = {text->
                username = text
          }, label = {
              Text(text = "Enter Your Username")
          } )
          Button(onClick = {
                           showUsername = username
          },modifier = Modifier.padding(10.dp),
                colors = ButtonDefaults.buttonColors(
                  containerColor = Color.White,
                    contentColor = Color.Black,
              ),
              border = BorderStroke(2.dp, color = Color.Blue)
              ) {
              Text(text = "Show Username")
          }

      Row (modifier = Modifier.fillMaxWidth()){
          Text(text = "Your username is $showUsername", modifier = Modifier.padding(horizontal = 20.dp))
      }

      TextField(value = password, onValueChange = {text->
          password = text
      }, label = {
          Text(text = "Enter Your Username")
      } )
      Button(onClick = {
          showPassword = password
      },modifier = Modifier.padding(10.dp),
          colors = ButtonDefaults.buttonColors(
              containerColor = Color.White,
              contentColor = Color.Black,
          ),
          border = BorderStroke(2.dp, color = Color.Blue)
      ) {
          Text(text = "Show Password")
      }

      Row (modifier = Modifier.fillMaxWidth()){
          Text(text = "Your password is $showPassword", modifier = Modifier.padding(horizontal = 20.dp))
      }

      Button(onClick = {
          showPassword = password
      },modifier = Modifier.padding(10.dp),
          colors = ButtonDefaults.buttonColors(
              containerColor = Color.White,
              contentColor = Color.Black,
          ),
          border = BorderStroke(2.dp, color = Color.Blue)
      ) {
          Text(text = "Generate Password")
      }

      if (username.isNotBlank()&& password.isNotBlank()){
          Text(text = "Hi $username, your \n password is $password", textAlign = TextAlign.Center)
      }

  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    AssignmentCompose1Theme {
        Screen()
    }
}

@Composable
fun EditTextButtonTextCombo(text:String,value:String,showValue:String){
    TextField(value = value, onValueChange = {text->
        value = text
    }, label = {
        Text(text = "Enter Your $text")
    } )
    Button(onClick = {
        showValue = value
    },modifier = Modifier.padding(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black,
        ),
        border = BorderStroke(2.dp, color = Color.Blue)
    ) {
        Text(text = "Show $text")
    }

    Row (modifier = Modifier.fillMaxWidth()){
        Text(text = "Your $text is $showUsername", modifier = Modifier.padding(horizontal = 20.dp))
    }
}