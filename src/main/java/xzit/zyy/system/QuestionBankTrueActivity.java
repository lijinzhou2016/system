package xzit.zyy.system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class QuestionBankTrueActivity extends AppCompatActivity {
    ImageView questionbank_true_back_icon;//返回键
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bank_true);
        init();
        questionbank_true_back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(QuestionBankTrueActivity.this,MainActivity.class);
                startActivity(intent);
                finish();


            }
        });

    }
    private void init(){
        questionbank_true_back_icon=(ImageView)questionbank_true_back_icon.findViewById(R.id.questionbank_true_back_icon);
    }
}
