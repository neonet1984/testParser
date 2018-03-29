package com.service;

import java.io.IOException;
import java.util.List;

/**
 * Реализация данного интерфейся, дает возможность читатать файлы
 */
public interface IReader {
    /**
     * Метод читает файлы
     *
     * @param pathFile путь к файлу
     * @return
     */
    String readFileToString(String pathFile) throws IOException;

    /**
     * Метотд читает файл
     * @param pathFile
     * @return возвращает лист строк
     */
    List<String> readToFileList(String pathFile);
}
