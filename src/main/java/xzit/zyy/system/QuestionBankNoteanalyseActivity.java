package xzit.zyy.system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class QuestionBankNoteanalyseActivity extends AppCompatActivity {
    ImageView questionbank_noteanalyse_back_icon;//返回


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bank_noteanalyse);
        init();
        //返回
        questionbank_noteanalyse_back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(QuestionBankNoteanalyseActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
                //返回end
    }
    private void init(){
        questionbank_noteanalyse_back_icon=(ImageView)findViewById(R.id.questionbank_noteanalyse_back_icon);//返回
    }
}
