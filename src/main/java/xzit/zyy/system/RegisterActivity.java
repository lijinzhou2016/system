package xzit.zyy.system;

import android.content.Intent;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetListener;
import cn.bmob.v3.listener.SaveListener;
import xzit.zyy.connect.MyDatabaseHelper;
import xzit.zyy.dbDao.ApplicationUser;
import xzit.zyy.dbDao.UserBean;


public class RegisterActivity extends AppCompatActivity {
    private EditText register_tel;
    private TextView register_tel_reminder;
    private EditText register_pwd;
    private  TextView register_pwd_reminder ;
    private Button register_btn;
    BmobQuery<UserBean> bmobQuerytel;
    boolean flagTel=false;
    boolean flagPwd=false;
    Intent intent;
    UserBean userBean=new UserBean();
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //初始化 Bmob SDK，第一个参数为上下文，第二个参数为Application ID
        Bmob.initialize(this,"fc1d911f55d1dc30a8c9de2b84e6b1a8");
        init();
        //用于监听焦点改变（得到焦点和失去焦点）事件，而所有的组件上又存在都存在这监听焦点变化的方法：
        register_btn.setOnClickListener(new RegisterBtnListener());

    }
    private void init(){
        register_tel=(EditText)findViewById(R.id.register_tel);
        register_tel_reminder=(TextView)findViewById(R.id.register_tel_reminder);
        register_pwd=(EditText)findViewById(R.id.register_pwd);
        register_pwd_reminder=(TextView) findViewById(R.id.register_pwd_reminder);
        register_btn=(Button)findViewById(R.id.register_btn);
    }
    //定义一个注册手机号码的编辑框的监听事件
    private class RegisterBtnListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String reg_Tel = register_tel.getText().toString();
            String reg_Pwd = register_pwd.getText().toString();
            //判断手机格式是否为空，为空则提示请输入手机号，不为空则判断手机格式是否正确
            if(reg_Tel.equals("")){
                register_tel_reminder.setText("请输入手机号");
            }else if(!(reg_Tel.isEmpty())){
                Pattern pattern = Pattern.compile("^(13[0-9]|15[1|0|3|6|7|8|9]|18[8|9|7])\\d{8}$");
                Matcher matcher = pattern.matcher(reg_Tel);
                if(matcher.matches()){
                    register_tel_reminder.setText("");
                    flagTel = true;
                }else{
                    register_tel_reminder.setText("手机号码格式不正确");
                }
                // 判断手机格式是否正确
            }//判断手机格式是否为空，为空则提示请输入手机号，不为空则判断手机格式是否正确 end

            //判断密码是否符合
            if (reg_Pwd.isEmpty()){
                register_pwd_reminder.setText("请输入密码");
            }else if(!(reg_Pwd.isEmpty())){
                Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]{6,20}+$");
                Matcher matcher = pattern.matcher(reg_Pwd);
                if (matcher.matches()) {
                    register_pwd_reminder.setText("");
                    flagPwd = true;
                }else{
                    register_pwd_reminder.setText("只能输入6-10个字母、数字、下滑线");
                }
            }
            //判断密码是否符合 end

            //手机号和密码正确
            if (flagPwd == true && flagTel == true){
                //查询用户表里是否已注册过该手机号
                bmobQuerytel= new BmobQuery<UserBean>();
                //查询Bmob中是否存在该用户名单条数据
                bmobQuerytel.addWhereEqualTo("username",reg_Tel);//查找数据库中已有tel
                bmobQuerytel.findObjects(RegisterActivity.this, new FindListener<UserBean>() {
                    @Override
                    public void onSuccess(List<UserBean> list) {
                        aboutAlert("该用户已经存在，请重新输入！");
                        register_tel.setText("");
                        register_pwd.setText("");
                        }

                    @Override
                    public void onError(int i, String s) {
                        userBean.setUsername(register_tel.getText().toString());
                        userBean.setPassword(register_pwd.getText().toString());
                        userBean.save(RegisterActivity.this, new SaveListener() {
                            @Override
                            public void onSuccess() {
                                Toast.makeText(RegisterActivity.this, "用户信息注册成功 ", Toast.LENGTH_LONG).show();
                                intent = new Intent();
                                intent.setClass(RegisterActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            @Override
                            public void onFailure(int i, String s) {


                            }
                        });


                    }
                });



                //查询单条数据的结束 end


            }

        }
    }


    //定义提示对话框
    private void aboutAlert(String msg1){
        AlertDialog.Builder builder=new AlertDialog.Builder(RegisterActivity.this);
        builder.setMessage(msg1);
        builder.setPositiveButton("确定", new android.content.DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO Auto-generated method stub


            }
        });
        AlertDialog alert=builder.create();
        builder.show();
    }
    //定义取消对话框
    private void exitAlert(String msg){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage(msg);
        builder.setTitle("退出");
        builder.setPositiveButton("确定", new android.content.DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO Auto-generated method stub
                finish();

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO Auto-generated method stub
            }
        });
        AlertDialog alert=builder.create();
        builder.show();
    }


}
