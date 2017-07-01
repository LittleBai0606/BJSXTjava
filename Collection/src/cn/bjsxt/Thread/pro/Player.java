package cn.bjsxt.Thread.pro;

import cn.bjsxt.Thread.pro.Movie;

/**
 * Created by BenWhite on 2017/6/29.
 */
public class Player implements Runnable{
    private Movie movie;

    public Player(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i % 2 == 0) {
                movie.play("左青龙");
            }else {
                movie.play("右白虎");
            }
        }

    }
}
