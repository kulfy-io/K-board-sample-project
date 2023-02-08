package com.kulfy.sample

import android.content.Intent
import com.kulfy.sdk.service.FleskyKeyboardService

class MyKBoardService : FleskyKeyboardService() {

    override fun openSDK() {
        val intent = Intent(applicationContext, KActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent)
    }
}