package com.service.impl;

import com.service.IFile;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Класс преднозначен для работы с файлами
 */
public class FileService implements IFile {
    @Override
    public void copyFile(String pathFile, String pathDirectory) {
        try {
            FileUtils.copyFileToDirectory(new File(pathFile), new File(pathDirectory));
        } catch (IOException e) {
            e.printStackTrace();
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
