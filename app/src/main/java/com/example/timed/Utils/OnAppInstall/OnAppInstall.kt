package com.example.timed.Utils.OnAppInstall

import android.app.Application
import com.example.timed.Utils.Database.DatabaseHelper
import java.io.File

class OnAppInstall : Application() {
    override fun onCreate() {
        super.onCreate()

//        Initialize database.
        DatabaseHelper.getInstance(this)

//        Initialize folders
        initializeAppFolders()
    }

    private fun initializeAppFolders() {
        val appDir = File(filesDir, "qr_code_images")
        if (!appDir.exists()) {
            appDir.mkdirs()
        }
    }
}