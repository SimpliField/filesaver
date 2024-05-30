package com.simplifield;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import com.getcapacitor.JSObject;
import com.getcapacitor.Logger;
import com.getcapacitor.PermissionState;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;

@CapacitorPlugin(
    name = "FileSaver",
    permissions = {
        @Permission(
            strings = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_MEDIA_IMAGES,
                Manifest.permission.READ_MEDIA_VIDEO,
                Manifest.permission.READ_MEDIA_AUDIO
            },
            alias = "publicStorage"
        )
    }
)
public class FileSaverPlugin extends Plugin {

    private static final String PERMISSION_DENIED_ERROR = "Unable to do file operation, user denied permission request";
    private FileSaver implementation = new FileSaver();

    @PluginMethod
    public void saveToDownloads(PluginCall call) {
        if (!isStoragePermissionGranted()) {
            Logger.debug(getLogTag(), "NOT ALLOWED");
            requestAllPermissions(call, "permissionCallback");
        } else {
            Context context = getContext();

            String url = call.getString("url");
            String fileName = call.getString("fileName");

            JSObject resp = new JSObject();
            long id = implementation.saveToDownloads(context, url, fileName);
            resp.put("downloadId", id);
            call.resolve(resp);
        }
    }

    @PluginMethod
    public void stopDownload(PluginCall call) {
        Context context = getContext();
        try {
            long id = call.getInt("id");
            implementation.clearCurrentTask(context, id);
            call.resolve();
        } catch (NullPointerException exception) {
            call.resolve();
        }
    }

    @PermissionCallback
    private void permissionCallback(PluginCall call) {
        if (!isStoragePermissionGranted()) {
            Logger.debug(getLogTag(), "User denied storage permission");
            call.reject(PERMISSION_DENIED_ERROR);
            return;
        }

        saveToDownloads(call);
    }

    private boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            return true;
        }

        return getPermissionState("publicStorage") == PermissionState.GRANTED;
    }
}
