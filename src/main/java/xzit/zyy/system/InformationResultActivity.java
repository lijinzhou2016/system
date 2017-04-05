package xzit.zyy.system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class InformationResultActivity extends AppCompatActivity {
    ImageView information_result_back_icon;//返回键

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_result);
        init();
        information_result_back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InformationResultActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void init(){
        information_result_back_icon=(ImageView)findViewById(R.id.information_result_back_icon);
    }
}
