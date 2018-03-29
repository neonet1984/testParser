package test_suite.moving_the_file_between_directories;

import com.service.impl.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс выносить в себя общую фунциональность для проверки существования файлов в директории
 */
public class Moving extends DirectoryCleaner {
    private FileService fileService = new FileService();
    private static final Logger log = LoggerFactory.getLogger(Moving.class);

    boolean isExistsFileInDirectory(String pathDirectory) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            log.error("Ошибка потока", e.getMessage());
        }
        return fileService.isExistingFile(pathDirectory);
    }
}
