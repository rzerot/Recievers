package dragos.com.recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by java2 on 11/28/2016.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {
    Context context;
    Boolean isNetworkConnected;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Network alive", Toast.LENGTH_LONG).show();
        this.context = context;
        isNetworkConnected = isNetworkConnected();
    }

    private Boolean isNetworkConnected() {
        return true;
    }
}
