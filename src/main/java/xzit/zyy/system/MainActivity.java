package xzit.zyy.system;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import xzit.zyy.dbDao.ApplicationUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    SharedPreferences preferences;
    private TextView txt_topbar;
    private  TextView txt_information;
    private  TextView txt_course;
    private  TextView txt_question_bank;
    private  TextView txt_my;
    private FrameLayout ly_content;
    private View activity_txt_my;//我的界面布局
    private  InformationFragment fg1;
    private CourseFragment fg2;
    private QuestionBankFragment fg3;
    private MyFragment fg4;
    private FragmentManager fManger;//用于对Fragment进行管理

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences=getSharedPreferences("count",MODE_PRIVATE);
        int logincount=preferences.getInt("logincount",0);
        if (logincount==0){
            Intent intent=new Intent();
            intent.setClass(getApplicationContext(),Login_RegisterActivity.class);
            startActivity(intent);
            finish();
        }
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt("logincount",++logincount);
        editor.commit();
        fManger=getFragmentManager();
        bindViews();
        txt_information.performClick();//模拟一次点击，既进去后选择第一项
    }
    //UI组件初始化与事件绑定
    private void bindViews() {
        txt_topbar=(TextView)findViewById(R.id.txt_topbar);
        txt_information=(TextView)findViewById(R.id.txt_information);
        txt_course=(TextView)findViewById(R.id.txt_course);
        txt_question_bank=(TextView)findViewById(R.id.txt_question_bank);
        txt_my=(TextView)findViewById(R.id.txt_my);
        ly_content=(FrameLayout)findViewById(R.id.ly_content);



        txt_information.setOnClickListener(this);
        txt_course.setOnClickListener(this);
        txt_question_bank.setOnClickListener(this);
        txt_my.setOnClickListener(this);
    }
    //重置所有文本的选中状态
    private void setSelected(){
    txt_information.setSelected(false);
    txt_course.setSelected(false);
    txt_question_bank.setSelected(false);
    txt_my.setSelected(false);
}
    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg4 != null)fragmentTransaction.hide(fg4);
}

    public void onClick(View v) {
        FragmentTransaction fTransaction = fManger.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()){
            case R.id.txt_information:
            setSelected();
            txt_information.setSelected(true);
                if(fg1 == null){
                    fg1=new InformationFragment();
                fTransaction.add(R.id.ly_content,fg1);
            }else{
                fTransaction.show(fg1);
            } break; case R.id.txt_course:
            setSelected();
            txt_course.setSelected(true);
                if(fg2 == null){
                fg2 = new CourseFragment();
                fTransaction.add(R.id.ly_content,fg2);
            }else{
                fTransaction.show(fg2);
            } break; case R.id.txt_question_bank:
            setSelected();
            txt_question_bank.setSelected(true);
                if(fg3 == null){
                fg3 = new QuestionBankFragment();
                fTransaction.add(R.id.ly_content,fg3);
            }else{
                fTransaction.show(fg3);
            } break;
            case R.id.txt_my:
            setSelected();
            txt_my.setSelected(true);
                if(fg4 == null){
                fg4 = new MyFragment();
                fTransaction.add(R.id.ly_content,fg4);
            }else{
                fTransaction.show(fg4);
            } break;
        }
        fTransaction.commit();
    }

}
