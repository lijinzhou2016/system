package xzit.zyy.system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MyAccount extends AppCompatActivity {
    ImageView activity_account_img_four;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        init();
        activity_account_img_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MyAccount.this,MyAlertPwd.class);
                startActivity(intent);
            }
        });
    }
    private void init(){
        activity_account_img_four=(ImageView)findViewById(R.id.activity_account_img_four);
    }
}
