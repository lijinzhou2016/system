package xzit.zyy.system;

import android.content.DialogInterface;
import android.content.Intent;
import android.app.AlertDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import xzit.zyy.connect.MyDatabaseHelper;

public class WordManageActivity extends AppCompatActivity {
    EditText word;
    TextView detail;
    Button btninsert,btndelete,btnmain;
    MyDatabaseHelper dbhelper;
    String results = null;
    Handler handler=new Handler() {
        public void handleMessage(Message msg){
            if(msg.what==0x123){
                detail.setText(results);
                String strWorld = word.getText().toString();
                int i = dbhelper.insertDB(strWorld, results);
                if (i > 0) {
                    Toast.makeText(WordManageActivity.this, "添加成功！",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(WordManageActivity.this, "添加失败！",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_manage);
        word=(EditText)findViewById(R.id.word);
        detail=(TextView)findViewById(R.id.detail);
        btninsert=(Button)findViewById(R.id.btninsert);
        btndelete=(Button)findViewById(R.id.btndelete);
        btnmain=(Button)findViewById(R.id.btnmain);
        dbhelper=new MyDatabaseHelper(this);

        // 插入数据
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strWorld = word.getText().toString();
                if(strWorld.isEmpty()){
                    Toast.makeText(WordManageActivity.this, "没有查询到意思！",
                            Toast.LENGTH_SHORT).show();
                }else {
                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                String strWorld = word.getText().toString();
                                strWorld = URLEncoder.encode(strWorld, "utf-8");
                                String result = SendGet("http://fanyi.youdao.com/openapi.do", "keyfrom=Hello-Word&key=399823717&type=data&doctype=json&version=1.1&q=" + strWorld);
                                System.out.println(result);
                                JSONObject jsonObject = new JSONObject(result);
                                results = jsonObject.getString("translation");
                                results = "翻译：" + results.substring(results.indexOf("\"") + 1, results.lastIndexOf("\"")) + "\n";
                                JSONObject jsonbasic = jsonObject.getJSONObject("basic");
                                results += "其他词性：\n";
                                JSONArray jsonexplains = jsonbasic.getJSONArray("explains");
                                for (int i = 0; i < jsonexplains.length(); i++) {
                                    results += jsonexplains.getString(i) + "\n";
                                }
                                if (result != null && !result.isEmpty()) {
                                    handler.sendEmptyMessage(0x123);
                                } else {
                                    Toast.makeText(WordManageActivity.this, "没有查询到意思！",
                                            Toast.LENGTH_SHORT).show();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                }
            }
        });

      // 删除数据
        btndelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                delAlert("确认要删除吗");
            }
        });
        //返回主界面
        btnmain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent=new Intent();
                intent.setClass(WordManageActivity.this, Course_WordActivity.class);
                startActivity(intent);
                finish();

            }
        });



    }

    private void delAlert(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg)
                .setTitle("删除")
                .setCancelable(false)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        String sid = word.getText().toString();
                        int i = dbhelper.deleteDB(sid);
                        if (i > 0) {
                            Toast.makeText(WordManageActivity.this, "删除成功！",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(WordManageActivity.this, "删除失败！",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        finish();
                    }
                }).create().show();

    }
    public String SendGet(String url,String params){
        String result="";
        BufferedReader in=null;
        try {
            URL url1=new URL(url+"?"+params);
            HttpURLConnection conn=(HttpURLConnection)url1.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(6000);
            conn.setReadTimeout(6000);
            conn.addRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","Keep_Alive");
            conn.addRequestProperty("user_agent","");
            conn.connect();
            in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line=in.readLine())!=null) result+="\n"+line;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            try{
                if(in!=null) in.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

}
