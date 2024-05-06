package com.example.mobile_security_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mobile_security_project.ui.interfaces.LoginForm
import com.example.mobile_security_project.ui.theme.MobilesecurityprojectTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            MobilesecurityprojectTheme{
                LoginForm()
            }
        }
    }
}