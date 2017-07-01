package cn.bjsxt.Thread.pro;

import cn.bjsxt.Thread.pro.Movie;

/**
 * Created by BenWhite on 2017/6/29.
 */
public class Watcher implements Runnable{

    private Movie movie;

    public Watcher(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            movie.watch();
        }
    }
}
