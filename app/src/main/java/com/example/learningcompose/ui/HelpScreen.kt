package com.example.learningcompose.ui

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.telephony.SmsManager
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.safecircle.ui.theme.CyanSecondary
import com.example.safecircle.ui.theme.YellowPrimary
import java.lang.Exception

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpScreen() {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Have a hyperlink to how to keep your children safe
        // Have a green call button to parents
        // Do we need more?
        val context = LocalContext.current
        messageButton(
            "1234567",
            "yukash",
            context
        )
    }


}

@Composable
fun messageButton(
    emergencyContactNumber: String,
    textMessageToSend: String,
    context: Context,
){
    ElevatedButton(
        onClick = {
            val activity = context as Activity

            val result = requestSmsPermission(activity, 123)

            if (result) {
                Log.i("SMS", "permissions granted")
            }else{
                Log.i("SMS", "no permissions ")
                requestSmsPermission(activity, 123)
            }

//            startSMSRetrieverClient(context)

            val newResult = requestSmsPermission(activity, 123)
            if (newResult) {
                Log.i("SMS", "permissions are working")
                sendTextMessage1(context, emergencyContactNumber, textMessageToSend, activity)
            }

        },
    ) {
        Text(
            text = "click to send text",
            color = Color.Black
        )
    }

}

fun sendTextMessage1(context: Context, phoneNumber: String, message: String, activity: Activity) {


    try{
        // on below line initializing sms manager.
        Log.i("SMS","I am about to start the manager")
        val smsManager: SmsManager = SmsManager.getDefault()
        Log.i("SMS","I am about to send the message")
        smsManager.sendTextMessage(phoneNumber, null, message, null, null, 1)


    }catch(e: Exception){
        // on below line handling error and
        // displaying toast message.
        Toast.makeText(
            context,
            "Error : " + e.message,
            Toast.LENGTH_SHORT
        ).show()

        e.message?.let { Log.d("SMS", it) }
    }

}

fun requestSmsPermission(activity: Activity, requestCode: Int): Boolean {

    if (activity.checkSelfPermission(android.Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
        return true
    } else {
        activity.requestPermissions(arrayOf(android.Manifest.permission.SEND_SMS), requestCode)
        return false
    }
}