package com.dot.dot_chat_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button buttonOnOff, buttonDiscover, buttonSend;
    ListView listView;
    TextView readMessage, connectionStatus;
    EditText writeMessage;

    IntentFilter intentFilter;
    WifiP2pManager wifiP2pManager;
    WifiManager wifiManager;
    BroadcastReceiver receiver;
    WifiP2pManager.Channel wifiP2PChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialWork();
    }

    private void initialWork() {
        buttonOnOff = findViewById(R.id.onOff);
        buttonDiscover = findViewById(R.id.discover);
        buttonSend = findViewById(R.id.sendButton);
        listView = findViewById(R.id.peerListView);
        readMessage = findViewById(R.id.readMsg);
        writeMessage = findViewById(R.id.writeMsg);
        connectionStatus = findViewById(R.id.connectionStatus);

        wifiP2pManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        wifiP2PChannel = wifiP2pManager.initialize(this, getMainLooper(), null);
        receiver = new WifiDirectBroadcastReceiver(wifiP2pManager, wifiP2PChannel, this);

        intentFilter = new IntentFilter();
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

    }
    ArrayList<WifiP2pDevice> peers = new ArrayList<>();
    String[] deviceNameArray;
    WifiP2pDevice[] wifiP2pDeviceArray;
    WifiP2pManager.PeerListListener peerListListener  = new WifiP2pManager.PeerListListener() {
        @Override
        public void onPeersAvailable(WifiP2pDeviceList peerList)
        {
            Toast.makeText(getApplicationContext(),"In it",Toast.LENGTH_LONG).show();
            if(!peerList.getDeviceList().equals(peers))
            {
                Toast.makeText(getApplicationContext(),"updated",Toast.LENGTH_LONG).show();

                peers.clear();
                peers.addAll(peerList.getDeviceList());
                deviceNameArray = new String[peerList.getDeviceList().size()];
                wifiP2pDeviceArray = new WifiP2pDevice[peerList.getDeviceList().size()];
                int index = 0;
                for (WifiP2pDevice device: peerList.getDeviceList())
                {
                    deviceNameArray[index] = device.deviceName;
                    wifiP2pDeviceArray[index] = device;
                    index++;
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
                listView.setAdapter(arrayAdapter);
            }


        }
    };

    public void discover(View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            wifiP2pManager.discoverPeers(wifiP2PChannel, new WifiP2pManager.ActionListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onSuccess() {
                    connectionStatus.setText("Discovery Started");
                }

                @SuppressLint("SetTextI18n")
                @Override
                public void onFailure(int i) {
                    connectionStatus.setText("Discovery Failed");

                }
            });
            return;
        }

    }

    @SuppressLint("SetTextI18n")
    public void WifiSwitch(View view)
    {
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        boolean wifiEnabled = wifiManager.isWifiEnabled();
        if(wifiEnabled)
        {
            wifiManager.setWifiEnabled(false);
            buttonOnOff.setText("On Wifi");
        }
        else
        {
            buttonOnOff.setText("Off Wifi");

            wifiManager.setWifiEnabled(true);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver( receiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}