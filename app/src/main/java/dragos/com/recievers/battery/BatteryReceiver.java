package dragos.com.recievers.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by java2 on 11/28/2016.
 */

public class BatteryReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPct = level / (float) scale;

        Log.d("TAG", "status " + status + "\nlevel " + level + "\nscale " + scale + "\nBattery " + batteryPct);
        Toast.makeText(context, "" + status + " " + level + " " + scale + " " + batteryPct, Toast.LENGTH_LONG).show();

    }
}
