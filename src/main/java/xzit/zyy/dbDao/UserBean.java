package xzit.zyy.dbDao;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/3/19.
 */
public class UserBean extends BmobObject {
    private String username;
    private String password;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
