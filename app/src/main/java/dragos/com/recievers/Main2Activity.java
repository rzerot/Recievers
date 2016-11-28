package dragos.com.recievers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dragos.com.recievers.alarming.MyBroadCastAlarm;

public class Main2Activity extends AppCompatActivity {
    int REQUEST_CODE = 223;
    EditText time;
    Button button;
    Button alarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        time = (EditText) findViewById(R.id.time);
        button = (Button) findViewById(R.id.start);
        alarm = (Button) findViewById(R.id.alarm);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starting();
            }
        });
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                i.putExtra(AlarmClock.EXTRA_MESSAGE, "Alarm");
                i.putExtra(AlarmClock.EXTRA_HOUR, 10);
                i.putExtra(AlarmClock.EXTRA_MINUTES, 30);
                startActivity(i);
            }
        });

    }

    void starting() {
        Intent intent = new Intent(this, MyBroadCastAlarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), REQUEST_CODE, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (Integer.parseInt(time.getText().toString()) * 1000), pendingIntent);
        int i = Integer.parseInt(time.getText().toString());
        Toast.makeText(this, "Alarm set in " + i + "seconds", Toast.LENGTH_LONG).show();
    }
}
