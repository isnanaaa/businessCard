package com.example.bussiness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.bussiness.ui.theme.BussinessTheme
import kotlinx.coroutines.Job

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BussinessTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BiCardImg(
                        name = getString(R.string.name),
                        tittle = getString(R.string.job),
                        no = getString(R.string.no),
                        socmed = getString(R.string.socmed),
                        email = getString(R.string.email),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun BiCard(name: String, tittle: String, no: String, socmed: String, email: String, modifier: Modifier = Modifier) {
    val hexCol = "0xff337357"
    val color = Color(android.graphics.Color.parseColor((hexCol)))
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize(1f)
            .padding(8.dp)
    ){
        Text(
            text = name,
            fontFamily = FontFamily.Monospace,
            fontSize = 20.sp,
            lineHeight = 10.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 190.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = tittle,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color(0xff337357),
            modifier = Modifier
                .padding(5.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
    Column (
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        Column {
            Row {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "phone icon",
                    modifier = Modifier,
                    tint = color
                )
                Text(
                    text = no,
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(3.dp)
                )
            }
        }
        Column {
            Row {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "account icon"
                )
                Text(
                    text = socmed,
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(3.dp)
                )
            }
        }
        Column {
            Row {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "email icon",
                )
                Text(
                    text = email,
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(3.dp)
                )
            }
        }
    }
}

@Composable
fun BiCardImg(name: String, tittle: String, no: String, socmed: String, email: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.android_logo)
    Box (
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xffd6e3d8))
    ){
        Image(
            painter = image,
            contentDescription = "android logo",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .fillMaxSize()
                .align(Alignment.Center)
                .background(Color(0xff163632))
        )
        BiCard(
            name = name,
            tittle = tittle,
            no = no,
            socmed = socmed,
            email = email,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
            )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Bussiness Card Preview")
@Composable
fun BiCardPreview() {
    BussinessTheme {
        BiCard(
            name = stringResource(R.string.name),
            tittle = stringResource(R.string.job),
            no = stringResource(R.string.no),
            socmed = stringResource(R.string.socmed),
            email = stringResource(R.string.email)
        )
    }
}