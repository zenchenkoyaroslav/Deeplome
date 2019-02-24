package com.uni.gitya.deeplome;

import android.os.Bundle;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private Button batConnect;  // Подключиться
    private Button batSignal;   // Отправить

    public static Project project;

    private static final int REQUEST_ENABLE_BT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        project = new Project();

        batConnect = (Button) findViewById(R.id.connect);
        batSignal = (Button) findViewById(R.id.signal);

        project.setBluetoothAdapter(BluetoothAdapter.getDefaultAdapter());

        if (!project.getBluetoothAdapter().isEnabled()) {
            // Bluetooth выключен. Предложим пользователю включить его.
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }


    public void onClickConnect(View view) {
        Intent intent = new Intent(this, ConnectActivity.class);
        startActivity(intent);
    }

    public void onClickSend(View view) {
        byte[] msgBuffer = "E".getBytes();
        try{
            project.getOutStream().write(msgBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
