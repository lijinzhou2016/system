package xzit.zyy.system;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.bmob.v3.Bmob;

public class MyAlertPwd extends AppCompatActivity {
    EditText my_alertpwd_current_edit;//当前密码
    EditText my_alertpwd_new_edit;//新的密码
    EditText my_alertpwd_newrepeat_edit;//重复密码
    Button my_alertpwd_submit;//提交按钮


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_alert_pwd);
        //初始化 Bmob SDK，第一个参数为上下文，第二个参数为Application ID
        Bmob.initialize(this,"fc1d911f55d1dc30a8c9de2b84e6b1a8");
        init();

    }
    //参数初始化化
    private void init(){
        my_alertpwd_current_edit=(EditText)findViewById(R.id.my_alertpwd_current_edit);
        my_alertpwd_new_edit=(EditText)findViewById(R.id.my_alertpwd_new_edit);
        my_alertpwd_newrepeat_edit=(EditText)findViewById(R.id.my_alertpwd_newrepeat_edit);
        my_alertpwd_submit=(Button)findViewById(R.id.my_alertpwd_submit);
    }
   // 提交按钮的监听事件实现
    private class MyAlertPwdSubmitClickListener implements View.OnClickListener{

       @Override
       public void onClick(View v) {

       }
   }
}
