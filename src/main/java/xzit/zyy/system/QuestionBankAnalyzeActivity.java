package xzit.zyy.system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class QuestionBankAnalyzeActivity extends AppCompatActivity {
    ImageView questionback_analyze_back_icon;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bank_analyze);
        init();
        questionback_analyze_back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(QuestionBankAnalyzeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void init(){
        questionback_analyze_back_icon=(ImageView)findViewById(R.id.questionback_analyze_back_icon);

    }
}
