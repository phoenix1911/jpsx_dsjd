package test;

import org.junit.Test;

import java.io.File;

/**
 * Created by Tjl on 2018/8/24 15:06.
 */
public class TestFile {
    @Test
    public static void main(String[] args) {
        File file = new File("maybatis_part1/src/test/student.xml");
        System.out.println(file.getAbsolutePath());

    }
}
