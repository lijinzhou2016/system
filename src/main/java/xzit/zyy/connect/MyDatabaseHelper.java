package xzit.zyy.connect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/11/25.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
        private SQLiteDatabase db;
    private static final String CREATE_SQL="create table wordtable" +
            "(_id integer primary key autoincrement,word text,detail text)";
    private static final String CREATE_SQLuser="create table usertable" +
            "(_id integer primary key autoincrement , username text ,password text)";
    public MyDatabaseHelper(Context context){
        super(context,"teachersystem.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //第一次使用数据库时自动建表
        this.db=db;
        db.execSQL(CREATE_SQL);
        db.execSQL(CREATE_SQLuser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    // 添加用户
    public int insertUser(String username,String password){
        int i = 0;
        db=getWritableDatabase();//以写的方式打开数据库对应的SQLiteDatebase对象

        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("password",password);
        i=(int)db.insert("usertable",null,cv);//P408页
        db.close();
        return i;
    }

    // 根据用户名和密码查询用户
    public Cursor queryUserBynamePwd(String username, String password) {
        db = getWritableDatabase();
        Cursor c = db.query("usertable", new String[]{"username,password"}, "username=? and password=?",
                new String[] { username, password }, null, null, null);
        return c;
    }

    // 根据用户名和密码查询用户
    public Cursor queryUserByname(String username) {
        db = getWritableDatabase();
        Cursor c = db.query("usertable", null, "username=?",
                new String[] { username }, null, null, null);
        return c;
    }

    // 添加单词
    public int insertDB(String word, String detail) {
        int i = 0;
        db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("detail", detail);
        cv.put("word", word);
        i = (int) db.insert("wordtable", null, cv);
        db.close();
        return i;
    }

    // 删除单词
    public int deleteDB(String word) {
        db = getWritableDatabase();
        int i = 0;
        String[] args = { word };
        if (db == null)
            db = getReadableDatabase();
        i = db.delete("wordtable", "word=?", args);
        return i;
    }
    // 查询单词-降序
    public Cursor query() {
        db = getWritableDatabase();
        Cursor c = db.query("wordtable", null, null, null, null, null,
                "word asc", "");
        return c;
    }
    // 根据单词id查询单词
    public Cursor queryWordById(int id) {
        db = getWritableDatabase();
        Cursor c = db.query("wordtable", null, "_id=?",
                new String[] { String.valueOf(id) }, null, null, null);
        return c;

    }
    // 修改单词数据
    public int updateDB(String word, String detail) {
        db = getWritableDatabase();
        int i = 0;
        ContentValues cv = new ContentValues();
        cv.put("word", word);
        cv.put("detail", detail);
        String[] args = new String[1];
        args[0] = word;
        i = db.update("wordtable", cv, "word=?", args);
        return i;
    }



    // 关闭数据库
    public void close() {
        if (db != null)
            db.close();
    }

}
