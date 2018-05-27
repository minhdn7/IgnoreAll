package com.mkit.ignoreall.app.utils;

public class NetworkStateChanged {
    private boolean mIsInternetConnected;

    public NetworkStateChanged(boolean isInternetConnected) {
        mIsInternetConnected = isInternetConnected;
    }

    public boolean isInternetConnected() {
        return mIsInternetConnected;
    }
}
