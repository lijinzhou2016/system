package xzit.zyy.dbDao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import xzit.zyy.connect.MyDatabaseHelper;

/**
 * Created by Administrator on 2016/11/26.
 */
public class WordListDao {
    private MyDatabaseHelper helper;
    private SQLiteDatabase db = null;
    public WordListDao(Context mContext){
        helper =new MyDatabaseHelper(mContext);
           }
    /**
     * 从本地数据库获取单词列表
     * @return
     */
    public List<WorldListBean> getWordList(){
        List<WorldListBean> wordList=new ArrayList<WorldListBean>();
        try {
            db=helper.getReadableDatabase();
            Cursor cursor=db.rawQuery("select * from word_list",null);
            if (null!=cursor){
                while (cursor.moveToNext()){
                    int word_id=cursor.getInt(cursor.getColumnIndex("word_id"));
                    String word=cursor.getString(cursor.getColumnIndex("word"));
                    String word_list=cursor.getString(cursor.getColumnIndex("word_list"));
                    WorldListBean bean=new WorldListBean();
                    bean.setWord_id(word_id);
                    bean.setWord(word);
                    bean.setWord_list(word_list);
                    wordList.add(bean);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    return wordList;
    }




}
