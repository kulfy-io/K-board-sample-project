# kulfy-keyboard - Android
## Use Kulfy SDK in your Android App (Current version - 1.0.6)

To use Kulfy SDK in Android App, Please proceed with below configuration-

1. Add dependency in build.gradle
    ```gradle
     implementation 'com.kulfyapp.sdk:android:<version>'
    ```
    
2. Add/Update network_config.xml:
```xml
<?xml version="1.0" encoding="utf-8"?>
<network-security-config>
    <debug-overrides>
        <trust-anchors>
            <certificates src="user" />
        </trust-anchors>
    </debug-overrides>
    <domain-config cleartextTrafficPermitted="true">
        <domain includeSubdomains="true">gateway.kulfyapp.com</domain>
    </domain-config>
    <domain-config cleartextTrafficPermitted="true">
        <domain includeSubdomains="true">api.kulfyapp.com</domain>
    </domain-config>
</network-security-config>
```

3. Open Kulfy GIF popup -
```kotlin
 val kulfySDK = KulfySDK(this)
                .setAccessKey(<ACCESS_KEY_PROVIDE_BY_KULFY>)
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
                })
            kulfySDK.build()
```
