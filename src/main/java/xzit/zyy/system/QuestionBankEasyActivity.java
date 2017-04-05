package xzit.zyy.system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class QuestionBankEasyActivity extends AppCompatActivity {
    ImageView questionbank_easy_back_icon;//返回键、
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bank_easy);
        init();
        //返回键的使用
        questionbank_easy_back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(QuestionBankEasyActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //返回键end
    }
    private void init(){
        questionbank_easy_back_icon=(ImageView)findViewById(R.id.questionbank_easy_back_icon);//返回键
    }
}
