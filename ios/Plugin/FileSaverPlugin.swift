import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(FileSaverPlugin)
public class FileSaverPlugin: CAPPlugin {

    @objc func saveToDownloads(_ call: CAPPluginCall) {
        call.unimplemented()
    }

    @objc func stopDownload(_ call: CAPPluginCall) {
        call.unimplemented()
    }
}
