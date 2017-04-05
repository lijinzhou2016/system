package xzit.zyy.system;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import xzit.zyy.dbDao.ApplicationUser;

/**
 * Created by Administrator on 2016/10/26.
 */
public class MyFragment extends Fragment {
    Button exit_system;
    TextView activity_txt_my_account;
    ImageView img;
    TextView activity_txt_my_clock;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View MyLayout=inflater.inflate(R.layout.activity_txt_my,container,false);
        //获得应用程序实例
        ApplicationUser user=(ApplicationUser)getActivity().getApplicationContext();
        String name=user.getUsername();//取值
        return MyLayout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
        activity_txt_my_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MyAccount.class);
                startActivity(intent);
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MyAccount.class);
                startActivity(intent);
            }
        });
        activity_txt_my_clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ClockActivity.class);
                startActivity(intent);
            }
        });

        exit_system.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });



    }
    private void init(){
        //获得应用程序实例
        ApplicationUser user=(ApplicationUser)getActivity().getApplicationContext();
        String name=user.getUsername();//取值
        img=(ImageView)getActivity().findViewById(R.id.img);
        activity_txt_my_account=(TextView)getActivity().findViewById(R.id.activity_txt_my_account);
        activity_txt_my_account.setText(name);
        activity_txt_my_clock=(TextView)getActivity().findViewById(R.id.activity_txt_my_clock);
        exit_system=(Button)getActivity().findViewById(R.id.exit_system);
    }
}
