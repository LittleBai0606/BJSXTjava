package cn.bjsxt.Thread.pro;

/**
 * Created by BenWhite on 2017/6/29.
 */
public class MovieApp {

    public static void main(String[] args) {
        //共同资源
        Movie movie = new Movie();

        Player player = new Player(movie);
        Watcher watcher = new Watcher(movie);

        new Thread(player).start();
        new Thread(watcher).start();

    }
}
