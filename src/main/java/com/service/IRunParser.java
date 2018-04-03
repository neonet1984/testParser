package com.service;

/**
 * Реализация интерфейса дает возможность запускать и закрывать парсер
 */
public interface IRunParser {
    /**
     * Метод используеться для запуска парсера
     *
     * @param pathToParser корневой путь к парсеру
     */
    void startupParser(String pathToParser);

    /**
     * Метод используеться для закрытия парсера
     */
    void closeParser();
}
