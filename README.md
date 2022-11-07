# kulfy-keyboard
This is a sample GIF Keyboard which has base UI projects for web, iOS &amp; Android 

To use Kulfy SDK in Android App, Please procees step by step.

1. Add dependency in build.gradle

    implementation 'io.github.agrawalashish1990:android:1.0.3'
    
2. Add network_config.xml in res/xml folder with below code:

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

3. Open Kulfy GIF popup -
 val kulfySDK = KulfySDK(this)
                .setAccessKey(<ACCESS_KEY_PROVIDE_BY_KULFY>)
                .setCallback(object :KulfyMediaCallbacks{
                    override fun onExit() {
                        TODO("Not yet implemented")
                    }

                    override fun onLoad() {
                        TODO("Not yet implemented")
                    }

                    override fun onMediaDownloaded(
                        uri: Uri,
                        downloadURL: String,
                        shareURL: String
                    ) {
                        TODO("Not yet implemented")
                    }
                })
            kulfySDK.build()

