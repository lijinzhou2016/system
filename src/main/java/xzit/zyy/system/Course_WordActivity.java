package xzit.zyy.system;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import xzit.zyy.connect.MyDatabaseHelper;

public class Course_WordActivity extends AppCompatActivity {
    MyDatabaseHelper dbHelper;
    private TextView word,detail;
    private Button word_previous,btn_word_to_edit,word_next,word_exit;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course__word);
        word=(TextView) findViewById(R.id.word);
        detail=(TextView)findViewById(R.id.detail);
        word_previous=(Button) findViewById(R.id.word_previous);
        btn_word_to_edit=(Button) findViewById(R.id.btn_word_to_edit);
        word_next=(Button) findViewById(R.id.word_next);
        word_exit=(Button) findViewById(R.id.word_exit);
        dbHelper=new MyDatabaseHelper(this);
        c=dbHelper.query();
        if (c.getCount() > 0) {
            c.moveToFirst();
            word.setText(c.getString(1));
            detail.setText(c.getString(2));
        } else {
            Toast.makeText(Course_WordActivity.this, "没有单词了！", Toast.LENGTH_LONG).show();
        }
        // 前一条
        word_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(c.getCount()==0){
                        Toast.makeText(Course_WordActivity.this, "没有单词了！", Toast.LENGTH_SHORT).show();
                    }else{
                        if (c.getPosition()!=0){
                            c.moveToPrevious();
                            word.setText(c.getString(1));
                            detail.setText(c.getString(2));
                        }else{
                            Toast.makeText(Course_WordActivity.this, "已经是第一个单词了！", Toast.LENGTH_SHORT).show();
                        }
                    }
                }catch (Exception error){

                }


            }
        });

        // 后一条
        word_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (c.getCount()==0){
                        Toast.makeText(Course_WordActivity.this, "没有单词了！", Toast.LENGTH_SHORT).show();
                    }else {
                        if(c.getCount()!=c.getPosition()+1){
                            c.moveToNext();
                            word.setText(c.getString(1));
                            detail.setText(c.getString(2));
                        }else {
                            Toast.makeText(Course_WordActivity.this, "已经是最后一个单词了！", Toast.LENGTH_SHORT).show();
                        }
                    }
                }catch (Exception error){

                }


            }
        });
        // 编辑单词
        btn_word_to_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Course_WordActivity.this,WordManageActivity.class );
                startActivity(intent);
                finish();

            }
        });
        // 退出记单词
        word_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Course_WordActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
