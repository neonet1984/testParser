package com.utils;

import java.io.File;

/**
 * Утильный класс исспозуеться для получения абсолютного пути
 */
public class UtilsPath {
    /**
     * Метод используеться для получения аболютного пути
     * @return возвращает путь, автотеста
     */
    public static String getAbsolutePathToAutoTest(){
        return new File("").getAbsolutePath();
    }
}
