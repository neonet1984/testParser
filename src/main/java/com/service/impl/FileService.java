package com.service.impl;

import com.service.IFile;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Класс преднозначен для работы с файлами
 */
public class FileService implements IFile {
    private Logger log = LoggerFactory.getLogger(FileService.class);

    @Override
    public void copyFile(String pathFile, String pathDirectory) {
        try {
            FileUtils.copyFileToDirectory(new File(pathFile), new File(pathDirectory));
        } catch (IOException e) {
            log.error(pathFile, e.getMessage());
        }
    }

    @Override
    public void deleteFile(File file) {
        file.delete();
    }

    @Override
    public void clearDirectory(String pathDirectory) {
        Arrays.stream(new File(pathDirectory).listFiles())
                .forEach(pathToFile -> deleteFile(pathToFile));
    }

    @Override
    public boolean isExistingFile(String pathDirectory) {
        return new File(pathDirectory).listFiles().length == 1;
    }

    @Override
    public String getFileName(String pathDirectory) {
        return new File(pathDirectory).listFiles()[0].toString();
    }

    @Override
    public boolean isDirectory(String pathDirectory) {
        return new File(pathDirectory).isDirectory();
    }

}
