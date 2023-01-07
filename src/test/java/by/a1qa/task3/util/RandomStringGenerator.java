package by.a1qa.task3.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomStringGenerator {

    private static final int MAX_STRING_LENGTH = 20;

    public static String getRandomString(){
        String result = RandomStringUtils.random(new Random().nextInt(MAX_STRING_LENGTH) + 1,
                true, true);
        return result;
    }
}
