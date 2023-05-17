package com.kulfy.sample

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kulfy.sdk.interfaces.CommentCallbacks
import com.kulfy.sdk.interfaces.KulfyMediaCallbacks
import com.kulfy.sdk.sdk.CommentSDK
import com.kulfy.sdk.sdk.KulfySDK

class MainActivity : AppCompatActivity() {

    private lateinit var clipboardManager: ClipboardManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clipboardManager = this.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager

        val btnOpenSDK: Button = findViewById(R.id.btnToOpenSDK)
        btnOpenSDK.setOnClickListener {
            openKulfySDK()
        }

        val btnToOpenCommentSDK: Button = findViewById(R.id.btnToOpenCommentSDK)
        btnToOpenCommentSDK.setOnClickListener {
            openCommentSDK()
        }
    }

    private fun openCommentSDK() {
        val channel = "group_chat"
        val subscribeKey = "<subs - key>"
        val publishKey = "<pub - key>"
        val width = 100   //width of kulfy
        val height = 100  //height of kulfy

        CommentSDK(this)
            .setChannel(channel)
            .setPublisherKey(publishKey)
            .setSubscriberKey(subscribeKey)
            .setUserInfo("<userId>","<userName>")
            .setContentType("<content type Video/gif")
            .setKeyboardInfo(apiKey = "<API_KEY>")
            .setKulfyInfo("<url>","<name>",width,height)
            .setFirebaseAnalytics(true)
            .setCallback(object : CommentCallbacks {
                override fun onExit() {
                }

                override fun onLoad() {
                }

            }).build()
    }

    private fun openKulfySDK() {
        val kulfySDK = KulfySDK(this)
            .setBottomMenuVisibility(true)
            .setApiKey("SampleAPIKey")
            .setFirebaseAnalyticsStatus(true)
            .setCallback(object : KulfyMediaCallbacks {
                override fun onExit() {
                    Toast.makeText(baseContext, "Thanks for using Kulfy SDK", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onLoad() {
                    Toast.makeText(baseContext, "SDK is ready to use", Toast.LENGTH_SHORT).show()
                }


                override fun onMediaDownloaded(
                    uri: Uri?,
                    downloadURL: String,
                    shareURL: String
                ) {
                    Toast.makeText(baseContext, "Downloaded successfully", Toast.LENGTH_SHORT)
                        .show()
                    uri?.let {
                        openSharePopup(shareURL, uri)
                    }
                }

                override fun onEventChange(eventName: String, eventValue: String) {
                    Log.v("event trigger", "$eventName:$eventValue")
                }

                override fun onABCClickEvent() {

                }


                override fun searchClear() {
                }

                override fun searchWord(keyword: String) {
                }

                override fun showInputKeyboard() {
                }
            })
        kulfySDK.build()
    }

    private fun openSharePopup(url: String, pathUri: Uri) {
        val clipData = ClipData.newPlainText("Kulfy", url)
        this.clipboardManager.setPrimaryClip(clipData)

        val intent = Intent(Intent.ACTION_SEND)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.putExtra(Intent.EXTRA_STREAM, pathUri)
        intent.type = "image/gif"
        startActivity(intent)
    }
}