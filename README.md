# kulfy-keyboard - Android
## Use Kulfy SDK in your Android App (Current version - 1.0.21)

![image](https://user-images.githubusercontent.com/16154307/222071474-e351fb26-2fa7-4ff4-b3cf-f69469ca64d0.png)

To use Kulfy SDK in Android App, Please proceed with below configuration-

1. Add dependency in build.gradle
    ```gradle
     implementation 'com.kulfyapp.sdk:android:<version>'
    ```
    
2. Open Kulfy GIF popup -
```kotlin
 val kulfySDK = KulfySDK(this)
                .setApiKey(<ACCESS_KEY_PROVIDE_BY_KULFY>)
                .setKeyBoardId(<KBOARD_ID_PROVIDE_BY_KULFY>)
                .setCallback(object :KulfyMediaCallbacks{
                    override fun onExit() {
                       //Event - when you are out of  sdk 
                    }

                    override fun onLoad() {
                       //Event - when SDK is initialized
                    }

                    override fun onMediaDownloaded(
                        uri: Uri,
                        downloadURL: String,
                        shareURL: String
                    ) {
                       //Event - when kulfy is downloaded and shared
                    }
                    
                     override fun onEventChange(eventName: String, eventValue: String) {
                         Log.v("event trigger", "$eventName:$eventValue")
                    }


                     override fun searchClear() {
                         // when sdk search box is cleared with clear button
                     }
                  
                     override fun searchWord(keyword: String) {
                        // when sdk starts searching with entered keyword
                     }
                  
                     override fun showInputKeyboard() {
                        // when keyboard is shown
                     }
                })
            kulfySDK.build()
```
3. Add Kulfy SDK as keyboard -
   Extend 'KulfyKeyboardService' class 
```kotlin
class MyKBoardService : KulfyKeyboardService() {

    override fun onCreate() {
        API_KEY = "<ENTER_API_KEY>"
        KBOARD_ID = "<ENTER_KBOARD_ID>"
        firebaseEnabled = true/false <If you want to enable firebase>
        super.onCreate()
    }
}
```
Add input_method.xml in res/xml folder
```xml
 <?xml version="1.0" encoding="utf-8"?>
<input-method xmlns:android="http://schemas.android.com/apk/res/android"
        android:icon="@mipmap/ic_launcher"
        android:isDefault="true">
   <subtype
           android:imeSubtypeExtraValue="EmojiCapable,AsciiCapable,TrySuppressingImeSwitcher"
           android:imeSubtypeMode="keyboard"
           android:label="%s"
           android:overridesImplicitlyEnabledSubtype="true" />
   <subtype
           android:imeSubtypeExtraValue="AsciiCapable"
           android:imeSubtypeLocale="en_US"
           android:imeSubtypeMode="keyboard"
           android:isAsciiCapable="true" />
</input-method>

```

  Declare service in AndroidManifest.xml
```xml

   <service
   android:name=".MyKBoardService"
   android:directBootAware="true"
   android:exported="true"
   android:permission="android.permission.BIND_INPUT_METHOD">
      <intent-filter>
         <action android:name="android.view.InputMethod" />
      </intent-filter>
      <meta-data
         android:name="android.view.im"
         android:resource="@xml/input_method" />
   </service>

```

Now run the app and add keyboard from phone settings and use Kulfy SDK


3. Use Kulfy SDK as a view

Add view in xml
```xml
 <com.kulfy.sdk.ui.KulfyView
        android:id="@+id/kulfyView"
        android:layout_width="match_parent"
        android:layout_height="300dp"
         />
```

``` Kotlin
val kulfyMediaView : KulfyView = <get instance of kulfy view from xml>
        kulfyMediaView.setApiKey(API_KEY)
        kulfyMediaView.setKeyBoardId(KBOARD_ID)
        kulfyMediaView.setFirebaseAnalyticsStatus(true/false)
        kulfyMediaView.setBottomMenuVisible(true/false)
        kulfyMediaView.setCallbacks(object : KulfyMediaCallbacks{
            override fun onMediaDownloaded(uri: Uri?, downloadURL: String, shareURL: String) {
               Log.v("kulfySDK","onMediaDownloaded")
            }

            override fun onExit() {
                Log.v("kulfySDK","onExit")
            }

            override fun onLoad() {
                Log.v("kulfySDK","onLoad")
            }

            override fun onEventChange(eventName: String, eventValue: String) {
                Log.v("kulfySDK","onEventChange")
            }

            override fun onABCClickEvent() {
                Log.v("kulfySDK","on ABC Click Event from Bottom menu")
            }

            override fun showInputKeyboard() {
              Log.v("kulfySDK","on Keyboard Start Event")
            }

            override fun searchWord(keyword: String) {
              Log.v("kulfySDK","on SearchBox Search Event")
            }

            override fun searchClear() {
               Log.v("kulfySDK","on SearchBox Clear Event")
            }
        })
        kulfyMediaView.createSDKFullView()
```
