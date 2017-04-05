package xzit.zyy.system;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Int2;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/26.
 */
public class CourseFragment extends Fragment {
    private AdapterViewFlipper course_cycle_viewpager;
    TextView course_bookshop;//书城
    TextView course_listener;//听力
    TextView course_word;//生词本
    TextView course_read;//悦读
    TextView course_course;//精品课
    TextView course_member;//会员中心

    private int [] imageIds=new int[]
            {
                    R.drawable.course_pic_one,R.drawable.course_pic_two,R.drawable.course_pic_three,R.drawable.course_pic_four,R.drawable.course_pic_five
            };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View CourseLayout=inflater.inflate(R.layout.activity_txt_course,container,false);
        course_cycle_viewpager=(AdapterViewFlipper)CourseLayout.findViewById(R.id.course_cycle_viewpager);
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
        course_cycle_viewpager.setAdapter(baseAdapter);
        course_cycle_viewpager.startFlipping();
        return CourseLayout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        //生词本点击跳转
        course_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Course_WordActivity.class);
                startActivity(intent);

            }
        });
        course_bookshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Course_BookShopActivity.class);
                startActivity(intent);
            }
        });


    }
    private void init()
    { course_bookshop=(TextView)getActivity().findViewById(R.id.course_bookshop);
        course_listener=(TextView)getActivity().findViewById(R.id.course_listener);
        course_word=(TextView)getActivity().findViewById(R.id.course_word);
        course_read=(TextView)getActivity().findViewById(R.id.course_read);
        course_course=(TextView)getActivity().findViewById(R.id.course_course);
        course_member=(TextView)getActivity().findViewById(R.id.course_member);

    }
}
