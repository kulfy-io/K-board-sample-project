//
//  ViewController.swift
//  ExampleKulfySDK
//
//  Created by Naveen Kumar on 17/12/22.
//

import UIKit
import KulfySDK

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func sdkButtonPressed(_ sender: Any) {
        let kulfySdkPopUp = KulfySDK()
        self.present(kulfySdkPopUp, animated: true)
    }
    
}

