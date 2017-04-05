package xzit.zyy.system;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startMainAvtivity();
    }
    private void startMainAvtivity() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                intent=new Intent(SplashActivity.this,Login_RegisterActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();//结束本Activity
            }
        }, 3000);//设置执行时间
    }
}
