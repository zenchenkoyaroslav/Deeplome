package com.uni.gitya.deeplome;

import android.bluetooth.BluetoothAdapter;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by gitya on 09.05.2017.
 */

class Project {

    private String macAddress = null;
    private InputStream inStream;
    private OutputStream outStream;
    private BluetoothAdapter bluetoothAdapter;

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public void setInStream(InputStream inStream) {
        this.inStream = inStream;
    }

    public void setOutStream(OutputStream outStream) {
        this.outStream = outStream;
    }

    public BluetoothAdapter getBluetoothAdapter() {
        return bluetoothAdapter;
    }

    public void setBluetoothAdapter(BluetoothAdapter bluetoothAdapter) {
        this.bluetoothAdapter = bluetoothAdapter;
    }

    public InputStream getInStream() {
        return inStream;
    }

    public OutputStream getOutStream() {
        return outStream;
    }
}
