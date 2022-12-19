# kulfySDK-iOS

## Setup
Follow the instructions below to add the Kulfy SDK to an existing application.


Add the KulfySDK package as a dependency using its repository URL, as follows:

 1. Navigate to Project’s General Pane > Package Dependencies,
 2. Click on the + button and enter the repository URL and click Add Package button.
 3. import KulfyFramwork
```swift
import KulfyFramwork
```
 4. Open Kulfy GIF popup
```swift
let kulfySdkPopUp = KulfySDK()
self.present(kulfySdkPopUp, animated: true)
```
