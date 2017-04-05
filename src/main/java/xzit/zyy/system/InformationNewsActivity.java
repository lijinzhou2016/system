package xzit.zyy.system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.FindListener;
import xzit.zyy.dbDao.Information;

public class InformationNewsActivity extends AppCompatActivity {
    ImageView information_news_back_icon;
    private ListView informationlist;//ListView控件
    private SimpleAdapter information_News_Adapter;
    private Information information;
    private List<Map<String,Object>> information_News_list;//创建一个information_News_list集合，其集合元素是map

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_news);
        //初始化 Bmob SDK，第一个参数为上下文，第二个参数为Application ID
        Bmob.initialize(this,"fc1d911f55d1dc30a8c9de2b84e6b1a8");
        init();
        information_news_back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InformationNewsActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

     //创建一个SimpleAdapter
        information= new Information();//声明information实体类
         information_News_list=new ArrayList<Map<String, Object>>();
        BmobQuery<Information> query=new BmobQuery<Information>();
        query.findObjects(this, new FindListener<Information>() {
            @Override
            public void onSuccess(List<Information> list) {
                for (int i=0;i<list.size();i++){
                    System.out.println("di"+i+"tiao");
                    Map<String,Object> map=new HashMap<String, Object>();
                    map.put("Information_string",list.get(i).getInformation_string());
                    map.put("Information_pics",list.get(i).getInformation_pics().getUrl());
                    information_News_list.add(map);
                }
                information_News_Adapter=new SimpleAdapter(InformationNewsActivity.this,information_News_list,R.layout.information_news_simple_item,new String[]{"Information_pics","Information_string"},new int[]{R.id.information_news_simple_item_img,R.id.information_news_simple_item_txt});
                informationlist.setAdapter(information_News_Adapter);
            }

            @Override
            public void onError(int i, String s) {

            }
        });

      //为informationlist（ListView）控件的列表项的单击事件绑定事件监听器
        informationlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

    }
    private void init(){
        information_news_back_icon=(ImageView)findViewById(R.id.information_news_back_icon);
        informationlist=(ListView)findViewById(R.id.informationlist);


            }
}
