package com.service.impl;

import com.service.IRunParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Сервис для запуска парсера
 */
public class RunParserService implements IRunParser {
    private final static Logger log = LoggerFactory.getLogger(RunParserService.class);

    @Override
    public void startupParser(String pathToParser) {
        try {
            Runtime.getRuntime().exec("cmd /k startup.bat cd:" + pathToParser, null, new File(pathToParser));
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            log.error("Не возможно, запустить парсер", e.getMessage());
        }
    }

    @Override
    public void closeParser() {
        try {
            Runtime.getRuntime().exec("taskkill /t /f /im cmd.exe");
        } catch (IOException e) {
            log.error("Не возможно, закрыть парсер", e.getMessage());
        }
    }
}
