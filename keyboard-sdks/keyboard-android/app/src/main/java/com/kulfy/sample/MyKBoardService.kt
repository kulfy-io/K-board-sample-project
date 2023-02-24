package com.kulfy.sample

import android.content.Intent
import com.kulfy.sdk.service.KulfyKeyboardService

class MyKBoardService : KulfyKeyboardService() {

    override fun onCreate() {
        API_KEY = "1e513b7f-8b61-4794-bf53-0b493bf1fddb"
        KBOARD_ID = "KBOARD_ID"
        firebaseEnabled = true
        super.onCreate()
    }
}