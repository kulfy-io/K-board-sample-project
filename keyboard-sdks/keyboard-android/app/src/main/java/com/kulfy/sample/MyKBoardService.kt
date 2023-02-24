package com.kulfy.sample

import android.content.Intent
import com.kulfy.sdk.service.KulfyKeyboardService

class MyKBoardService : KulfyKeyboardService() {

    override fun onCreate() {
        API_KEY = "<YOUR_API_KEY"
        KBOARD_ID = "KBOARD_ID"
        firebaseEnabled = true
        super.onCreate()
    }
}