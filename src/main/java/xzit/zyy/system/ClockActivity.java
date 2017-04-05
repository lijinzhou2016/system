package xzit.zyy.system;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class ClockActivity extends AppCompatActivity {
    private AlarmManager alarmManager;
    private PendingIntent pi;
    private ImageView add_clock;
    private Calendar calendar;
    private TextView txt_clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        add_clock=(ImageView)findViewById(R.id.add_clock);
        txt_clock=(TextView)findViewById(R.id.txt_clock);

       // calendar=Calendar.getInstance();//Calendar 抽象类定义了足够的方法，让我们能够表述日历的规则。Java 本身提供了对 "Gregorian Calendar" 规则的实现。我们从 Calendar.getInstance() 中所获得的实例就是一个 "GreogrianCalendar" 对象(与您通过 new GregorianCalendar() 获得的结果一致)。
        //获取AlarmMar对象：

        //指定要启动的是Acti组件，通过PendingIntent调用getActivity来设置

        //PendingIntent对象设置动作，启动的是Activity还是Service，又或者是广播！

       add_clock.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Calendar currentTime=Calendar.getInstance();
               //   TimePickerDialog方法有五个参数，
               // 第一个参数（MenuView.this）为弹出的时间对话框所在的activity指针；
               // 第二个参数我们最后说；第三个参数（hour）和第四个参数（minute）为弹出的时间对话框的初始显示的小时和分钟，这两个变量在蓝色代码中进行初始化；
               // 第五个参数为设置24时显示参数，true代表时间以24时制显示时间。
               new TimePickerDialog(ClockActivity.this,
                       new TimePickerDialog.OnTimeSetListener() {
                           @Override
                           public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                               Intent intent=new Intent(ClockActivity.this,AlarmActivity.class);
                               PendingIntent pi=PendingIntent.getActivity(ClockActivity.this,0,intent,0);
                               //
                               Calendar c=Calendar.getInstance();
                               c.setTimeInMillis(System.currentTimeMillis());//设置为当前的系统时间
                               c.set(Calendar.HOUR,hourOfDay);
                               c.set(Calendar.MINUTE,minute);

              //调用AlarmManger的set（）方法设置单次闹钟的类型，启动时间以及PendingIntent对象
                               alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
                               alarmManager.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pi);
                               Toast.makeText(ClockActivity.this,"设置成功",Toast.LENGTH_LONG).show();
                               txt_clock.setText(String.valueOf(hourOfDay)+"："+String.valueOf(minute));
                           }
                       },currentTime.get(Calendar.HOUR_OF_DAY),currentTime.get(Calendar.MINUTE),true).show();

           }
       });
    }
}
