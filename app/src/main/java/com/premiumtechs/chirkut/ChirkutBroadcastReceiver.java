package com.premiumtechs.chirkut;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pManager;

public class ChirkutBroadcastReceiver extends BroadcastReceiver {
    private WifiP2pManager wifiP2pManager = null;
    private WifiP2pManager.Channel channel = null;
    private WifiActivity wifiActivity = null;

    public ChirkutBroadcastReceiver(WifiP2pManager wifiP2pManager, WifiP2pManager.Channel channel, WifiActivity wifiActivity) {
        this.wifiP2pManager = wifiP2pManager;
        this.channel = channel;
        this.wifiActivity = wifiActivity;
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
            //Check to see if wifi is enabled and notify appropriate activity

        } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {
            //call requestPeers() to get a list of peers
            if (wifiP2pManager != null) {
                //wifiP2pManager.requestPeers(channel, mainActivity.peerListListener);
            }

        } else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {
            //respond to connection of disconnections
            if (wifiP2pManager != null) {
                NetworkInfo networkInfo = intent.getParcelableExtra(WifiP2pManager.EXTRA_NETWORK_INFO);
                if (networkInfo.isConnected()) {
                    //wifiP2pManager.requestConnectionInfo(channel, mainActivity.connectionInfoListener);
                } else {
                    //mainActivity.connectionStatus.setText("Not connected");
                }
            }
        } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {

        }
    }
}
