package xzit.zyy.system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class InformationTimeActivity extends AppCompatActivity {
    ImageView information_time_back_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_time);
        init();
        //返回按钮的实现
        information_time_back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InformationTimeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
    private void init(){
        information_time_back_icon=(ImageView)findViewById(R.id.information_time_back_icon);
    }
}
