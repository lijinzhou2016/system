package xzit.zyy.system;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_RegisterActivity extends AppCompatActivity {
    Button register_login_btn_login;
    Button register_login_btn_register;
    Intent intent;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__register);
        preferences=getSharedPreferences("count",MODE_PRIVATE);
        int count=preferences.getInt("count",0);
        if(count==0){
            Intent intent=new Intent();
            intent.setClass(getApplicationContext(),SplashActivity.class);
            startActivity(intent);
            finish();
        }
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt("count",++count);
        editor.commit();
        init();


    }
    private void init(){
        register_login_btn_login=(Button)findViewById(R.id.register_login_btn_login);
        register_login_btn_register=(Button)findViewById(R.id.register_login_btn_register);
        register_login_btn_login.setOnClickListener(new Register_Login_btn_loginListenr());
        register_login_btn_register.setOnClickListener(new Register_Login_btn_registerListenr());

    }
    private class Register_Login_btn_loginListenr implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            intent=new Intent(Login_RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private class Register_Login_btn_registerListenr implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            intent=new Intent(Login_RegisterActivity.this,RegisterActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
