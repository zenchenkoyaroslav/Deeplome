package com.uni.gitya.deeplome;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * Created by gitya on 09.05.2017.
 */

public class ConnectThread extends Thread {
    BluetoothAdapter bluetooth1;
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    BluetoothSocket clientSocket;

    private BluetoothSocket mmSocket;
    private OutputStream mmOutStream;
    private InputStream mmInStream;
    InputStream tmpIn = null;
    OutputStream tmpOut = null;

    private static final String TAG = "bluetooth1";

    public ConnectThread() {
        bluetooth1 = BluetoothAdapter.getDefaultAdapter();
        bluetooth1.enable();
        BluetoothDevice device = bluetooth1.getRemoteDevice(MainActivity.project.getMacAddress());
        try {
            mmSocket = device.createRfcommSocketToServiceRecord(MY_UUID);

            bluetooth1.cancelDiscovery();


            mmSocket.connect();


            tmpOut = mmSocket.getOutputStream();
            tmpIn = mmSocket.getInputStream();

            MainActivity.project.setOutStream(tmpOut);
            MainActivity.project.setInStream(tmpIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
