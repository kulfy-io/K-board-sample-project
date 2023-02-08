package com.kulfy.sample;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kulfy.sdk.interfaces.KulfyMediaCallbacks;
import com.kulfy.sdk.sdk.KulfySDK;

/**
 * Ashish Agrawal
 * Created on 27/10/22
 */
public class KActivity extends AppCompatActivity implements KulfyMediaCallbacks {

    private ClipboardManager clipboardManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        this.clipboardManager = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
        KulfySDK kulfySDK = new KulfySDK(this)
                .setBottomMenuVisibility(true)
                .setApiKey("SampleAPIKey")
                .setKeyBoardId("SampleKeyboardId")
                .setFirebaseAnalyticsStatus(true)
                .setCallback(this);
        kulfySDK.build();
    }

    private void copyInClipBoard(String url, Uri uri) {
        ClipData clipData = ClipData.newPlainText("Kulfy", url);
        this.clipboardManager.setPrimaryClip(clipData);

        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.setType("image/gif");
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        overridePendingTransition(com.kulfy.sdk.R.anim.slide_stay, com.kulfy.sdk.R.anim.slide_out_up);
        finish();
    }

    @Override
    public void onExit() {
        finish();
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onMediaDownloaded(@NonNull Uri uri, @NonNull String downloadURL, @NonNull String shareURL) {
        copyInClipBoard(shareURL, uri);
    }

    @Override
    public void onEventChange(@NonNull String eventName, @NonNull String eventValue) {

    }

    @Override
    public void onABCClickEvent() {

    }

}
