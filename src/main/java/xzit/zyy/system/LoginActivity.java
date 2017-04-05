package xzit.zyy.system;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetListener;
import xzit.zyy.connect.MyDatabaseHelper;
import xzit.zyy.dbDao.ApplicationUser;
import xzit.zyy.dbDao.UserBean;

public class LoginActivity extends AppCompatActivity {
    MyDatabaseHelper dbhelper=new MyDatabaseHelper(this);
    private  TextView login_xml_register;
    Button login_btn;
    EditText login_account_name;
    EditText login_account_pwd;
    Intent intent;
    UserBean userBean=new UserBean();
    BmobQuery<UserBean> bmobQuerytel;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化 Bmob SDK，第一个参数为上下文，第二个参数为Application ID
        Bmob.initialize(this,"fc1d911f55d1dc30a8c9de2b84e6b1a8");
        initViews();
        login_xml_register.setOnClickListener(new RegisterClickListener());//点击立即注册进行跳转页面到注册界面
        login_btn.setOnClickListener(new Login_BtnClickListenr());
    }
    //UI组件初始化与事件绑定
    private void initViews(){
        login_xml_register=(TextView)findViewById(R.id.login_xml_register);
        login_account_name=(EditText)findViewById(R.id.login_account_name);
        login_account_pwd=(EditText)findViewById(R.id.login_account_pwd);
        login_btn=(Button)findViewById(R.id.login_btn);


    }
//点击注册按钮实现注册按钮界面的跳转
    private class RegisterClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent=new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);

        }
    }
    //点击注册按钮实现注册按钮界面的跳转 end
    private class Login_BtnClickListenr implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String name=login_account_name.getText().toString();
            String pwd=login_account_pwd.getText().toString();
                //如果查询到已有用户名，然后再查询密码是否一样 end
            if(name.isEmpty()||pwd.isEmpty()){
                Toast.makeText(LoginActivity.this,"密码或账号不为空！",Toast.LENGTH_LONG).show();
                return;
            }
            bmobQuerytel=new BmobQuery<UserBean>();
            bmobQuerytel.addWhereEqualTo("username",name);
            bmobQuerytel.addWhereEqualTo("password",pwd);
            bmobQuerytel.findObjects(LoginActivity.this, new FindListener<UserBean>() {
                @Override
                public void onSuccess(List<UserBean> list) {
                    if (list!=null&&list.size()>0){
                        Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onError(int i, String s) {
                    Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_LONG).show();

                }
            });
        }
    }
}
