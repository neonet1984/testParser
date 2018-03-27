package com.service;

import java.io.File;

/**
 * Класс реализующий данный интерфейс позволяет манипулировать файлами
 */
public interface IFile {
    /**
     * Метод позволяет копировать файлы
     *
     * @param pathFile      путь к файлу
     * @param pathDirectory путь к директори, в которую будет скопирован файл
     */
    void copyFile(String pathFile, String pathDirectory);

    /**
     * Метод удаляет файл
     *
     * @param pathFile путь к файлу,который нужно удалить
     */
    void deleteFile(File pathFile);

    /**
     * Метод предозначен для очистки директории
     *
     * @param pathDirectory путь к директории которую необходимо очистить
     */
    void clearDirectory(String pathDirectory);

    /**
     * Метод преднозначен для проверки, существования файла в директории
     *
     * @param pathDirectory путь к директории
     * @return возвращает true, в случае если в директории присутствуют файлы
     */
    boolean isExistingFile(String pathDirectory);

    /**
     * Метод возвращает имя файла находящегося в директории
     *
     * @param pathDirectory путь к директории
     * @return возвращает имя файла
     */
    String getFileName(String pathDirectory);

    /**
     * Этот метод проверяет, существует ли указанная директория
     *
     * @param pathDirectory путь к директории
     * @return возвращает true, если директория существует
     */
    boolean isDirectory(String pathDirectory);
}
