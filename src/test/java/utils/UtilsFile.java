package utils;

import com.service.impl.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test_suite.PathsToDirectories;

/**
 * Утильный класс для работы с файлами
 */
public class UtilsFile {
    private static FileService fileService = new FileService();
    private static Logger log = LoggerFactory.getLogger(UtilsFile.class);

    /**
     * Метод копирует файл, в source директорию парсера
     * @param pathToYmlFile путь к копируемому файлу
     */
    public static void copyYmlFileToSourceDirectory(String pathToYmlFile) {
        fileService.copyFile(UtilsPath.getAbsolutePathToAutoTest() + "\\" + pathToYmlFile,
                PathsToDirectories.DIRECTORY_SOURCE);
    }

    /**
     * Метод каждую секуднду проверяет папку на наличие файлов
     *
     * @param pathDirectory путь к директории, которую необходимо проверить
     * @return и возвращает, true если файл в директории найден
     */
    public static boolean isExistsFileInDirectory(String pathDirectory) {
        int timeOut = 8000;
        while (timeOut > 0) {
            try {
                Thread.sleep(1000);
                if (fileService.isExistingFile(pathDirectory)) {
                    return true;
                } else {
                    timeOut -= 1000;
                }
            } catch (InterruptedException e) {
                log.error("Ошибка потока", e.getMessage());
            }
        }
        return false;
    }
}
