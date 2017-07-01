package cn.bjsxt.sort.reflype;

import java.util.Date;

/**
 * Created by BenWhite on 2017/6/21.
 */
public class NewsItem implements java.lang.Comparable<NewsItem>{

    private String title;//标题
    private int hits;//点击量
    private Date pubTime;//出版时间

    public NewsItem() {
    }

    public NewsItem(String title, int hits, Date pubTime) {
        this.title = title;
        this.hits = hits;
        this.pubTime = pubTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    //时间降序+点击量升序+标题降序
    @Override
    public int compareTo(NewsItem o) {
        int result = 0;
        result = -this.pubTime.compareTo(o.getPubTime());
        if(0 == result) {
            //点击量
            result = this.hits - o.hits;//升序
            if (0 == result) {
                //标题
                result = -this.getTitle().compareTo(o.getTitle());
                return result;
            }
        }
        return result;
    }
}
