package sg.edu.rp.c346.practical;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg1;
    BroadcastReceiver br = new Wallpaper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg1 = findViewById(R.id.Radio1);

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("android.intent.action.WALLPAPER_CHANGED");
        this.registerReceiver(br, filter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int id = prefs.getInt("id", R.id.radioButtonGood);
        rg1.check(id);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putInt("id", rg1.getCheckedRadioButtonId());
        prefEdit.commit();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        this.unregisterReceiver(br);
    }
}
