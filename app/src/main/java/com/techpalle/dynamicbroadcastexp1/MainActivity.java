package com.techpalle.dynamicbroadcastexp1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //a-create a dynamic broad cast receiver
    public  class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "dynamic power unplugged", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //b-link intent filter with above broadcast receiver
        IntentFilter intentfilter=new IntentFilter();
        intentfilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        
        MyReceiver myreceiver=new MyReceiver();
        registerReceiver(myreceiver,intentfilter);
    }

}
