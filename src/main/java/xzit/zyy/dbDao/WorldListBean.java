package xzit.zyy.dbDao;

/**
 * Created by Administrator on 2016/11/26.
 */
public class WorldListBean {
    private int word_id;
    private String word;
    private String word_list;

    public void setWord_id(int word_id) {
        this.word_id = word_id;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public void setWord_list(String word_list) {
        this.word_list = word_list;
    }



    public int getWord_id() {
        return word_id;
    }

    public String getWord() {
        return word;
    }

    public String getWord_list() {
        return word_list;
    }
}
