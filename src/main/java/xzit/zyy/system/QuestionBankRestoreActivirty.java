package xzit.zyy.system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class QuestionBankRestoreActivirty extends AppCompatActivity {
    ImageView questionbank_restore_back_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bank_restore);
        init();
        questionbank_restore_back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(QuestionBankRestoreActivirty.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void init(){
        questionbank_restore_back_icon=(ImageView)findViewById(R.id.questionbank_restore_back_icon);
    }
}
