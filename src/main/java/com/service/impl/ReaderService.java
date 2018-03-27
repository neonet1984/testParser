package com.service.impl;

import com.service.IReader;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Класс преднозначен для чтения файлов
 */
public class ReaderService implements IReader {
    @Override
    public String readFileToString(String pathToFile) throws IOException {
        return FileUtils.readFileToString(new File(pathToFile));
    }

    @Override
    public List<String> readToFileList(String pathFile) {
        try (Stream<String> stream = Files.lines(Paths.get(pathFile))) {
            return stream
                    .collect(Collectors.toList());
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
