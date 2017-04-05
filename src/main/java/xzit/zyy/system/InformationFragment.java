package xzit.zyy.system;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */
public class InformationFragment extends Fragment {

private AdapterViewFlipper information_cycle_viewpager;
    private TextView information_news;//实时资讯
    private TextView information_time;//考试日历
    private TextView information_question;//常见问题
    private TextView information_leader;//新手指南
    private TextView information_key;//核心考点
    private TextView information_result;//成绩查询
   private int [] imageIds=new int[]
            {
                    R.drawable.banner_one,R.drawable.banner_two,R.drawable.banner_three
            };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inforamtionLayout=inflater.inflate(R.layout.activity_txt_information,container,false);
        information_cycle_viewpager=(AdapterViewFlipper)inforamtionLayout.findViewById(R.id.information_cycle_viewpager);
        BaseAdapter baseAdapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView=new ImageView(getActivity());
                imageView.setImageResource(imageIds[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewPager.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        information_cycle_viewpager.setAdapter(baseAdapter);
        information_cycle_viewpager.startFlipping();
        return inforamtionLayout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        //实时资讯跳转功能
        information_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),InformationNewsActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        //考试日历
        information_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),InformationTimeActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        //常见问题
        information_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),InformationQuestionActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        //新手指南
        information_leader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),InformationLeaderActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        //核心考点
        information_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),InformationKeyActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        //成绩查询
        information_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),InformationResultActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


    }


    private void init(){
        information_news=(TextView)getActivity().findViewById(R.id.information_news);
        information_time=(TextView)getActivity().findViewById(R.id.information_time);
        information_question =(TextView)getActivity().findViewById(R.id.information_question);
        information_leader=(TextView)getActivity().findViewById(R.id.information_leader);
        information_key=(TextView)getActivity().findViewById(R.id.information_key);
        information_result=(TextView)getActivity().findViewById(R.id.information_result);
    }
}
