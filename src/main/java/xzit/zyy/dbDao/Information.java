package xzit.zyy.dbDao;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Administrator on 2017/3/19.
 */
public class Information extends BmobObject{
    private String Information_string;//文字说明
    private BmobFile Information_pics;//图片

    public String getInformation_string() {
        return Information_string;
    }

    public void setInformation_string(String information_string) {
        Information_string = information_string;
    }

    public BmobFile getInformation_pics() {

        return Information_pics;
    }

    public void setInformation_pics(BmobFile information_pics) {
        Information_pics = information_pics;
    }
}
