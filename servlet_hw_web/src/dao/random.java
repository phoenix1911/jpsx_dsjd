package dao;

import java.util.Random;

/**
 * Created by Tjl on 2018/8/19 22:05.
 */
public class random {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(100);
        System.out.println(i);
    }
}
