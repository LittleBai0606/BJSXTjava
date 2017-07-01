package cn.bjsxt.sort.reflype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by BenWhite on 2017/6/21.
 * 使用Collections
 * @author BenWhite
 */
public class NewsItemApp {

    public static void main(String[] args) {
        List<NewsItem> news = new ArrayList<NewsItem>();
        news.add(new NewsItem("中国登上钓鱼岛了，全国欢呼了", 100, new Date()));
        news.add(new NewsItem("美国后怕逃跑了，悲剧了",50, new Date(System.currentTimeMillis() - 1000 * 60 * 60)));
        news.add(new NewsItem("日本终于听话了，泪流满面", 200, new Date(System.currentTimeMillis() - 1000 * 60 * 60)));

    }
}
