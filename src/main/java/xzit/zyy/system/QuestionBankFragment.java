package xzit.zyy.system;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/26.
 */
public class QuestionBankFragment extends Fragment {
    @Nullable
    TextView question_bank_practice;//章节练习
    TextView question_bank_true;//历年真题
    TextView question_bank_simulate;//模拟试题
    TextView question_bank_easy;//易错题
    TextView question_bank_analyze;//评估报告
    TextView question_bank_offline;//离线题库
    TextView question_bank_practiceremeber;//做题记录
    TextView question_bank_errortatal;//错题集
    TextView question_bank_restore;//收藏试题
    TextView question_bank_noteanalyse;//笔记解析
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View questionBankLayout=inflater.inflate(R.layout.activity_txt_question_bank,container,false);
        return questionBankLayout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        //章节练习跳转功能
        question_bank_practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),QuestionBankPracticeActivity.class);
                startActivity(intent);

            }
        });
        //历年真题
        question_bank_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),QuestionBankTrueActivity.class);
                startActivity(intent);
            }
        });
        //模拟试题
        question_bank_simulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),QuestionBankSimulateActivity.class);
                startActivity(intent);

            }
        });
        //易错题
        question_bank_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),QuestionBankEasyActivity.class);
                startActivity(intent);

            }
        });
        //评估报告
        question_bank_analyze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),QuestionBankAnalyzeActivity.class);
                startActivity(intent);

            }
        });
      //离线题库
        question_bank_offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),QuestionBankOfflineActivity.class);
                startActivity(intent);

            }
        });
        //做题记录
        question_bank_practiceremeber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),QuestionBankPracticeremeberActivirty.class);
                startActivity(intent);
            }
        });
        //错题集
        question_bank_errortatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),QuestionBankErrortatalActivity.class);
                startActivity(intent);
            }
        });
        question_bank_restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),QuestionBankRestoreActivirty.class);
                startActivity(intent);
            }
        });
        //笔记解析
        question_bank_noteanalyse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),QuestionBankNoteanalyseActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init(){
        question_bank_practice=(TextView)getActivity().findViewById(R.id.question_bank_practice);
        question_bank_true=(TextView)getActivity().findViewById(R.id.question_bank_true);
        question_bank_simulate=(TextView)getActivity().findViewById(R.id.question_bank_simulate);
        question_bank_easy=(TextView)getActivity().findViewById(R.id.question_bank_easy);
        question_bank_analyze=(TextView)getActivity().findViewById(R.id.question_bank_analyze);
        question_bank_offline=(TextView)getActivity().findViewById(R.id.question_bank_offline);
        question_bank_practiceremeber=(TextView)getActivity().findViewById(R.id.question_bank_practiceremeber);
        question_bank_errortatal=(TextView)getActivity().findViewById(R.id.question_bank_errortatal);
        question_bank_restore=(TextView)getActivity().findViewById(R.id.question_bank_restore);
        question_bank_noteanalyse=(TextView)getActivity().findViewById(R.id.question_bank_noteanalyse);
    }
}
