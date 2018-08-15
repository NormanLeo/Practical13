package sg.edu.rp.c346.practical;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class Wallpaper extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "You have changed the wallpaper", Toast.LENGTH_SHORT).show();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        int id = prefs.getInt("id", R.id.radioButtonGood);
        if (id == R.id.radioButtonGood){
            Toast.makeText(context, R.string.good, Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(context, R.string.twice, Toast.LENGTH_SHORT).show();
        }
    }

}
