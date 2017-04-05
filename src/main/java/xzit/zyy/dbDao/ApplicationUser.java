package xzit.zyy.dbDao;

import android.app.Application;

/**
 * Created by Administrator on 2016/12/8.
 */
public class ApplicationUser extends Application {
    private String username;
    private int count;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
