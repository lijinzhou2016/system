package xzit.zyy.system;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlarmActivity extends AppCompatActivity {
    MediaPlayer alarmMusic;
    Button btn_alarm_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        btn_alarm_close=(Button)findViewById(R.id.btn_alarm_close);
        //加载指定音乐，并为之创建MediaPlayer对象
        alarmMusic=MediaPlayer.create(this,R.raw.alarm);
        alarmMusic.setLooping(true);
        alarmMusic.start();
        btn_alarm_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmMusic.stop();
                AlarmActivity.this.finish();;
            }
        });


    }
}
