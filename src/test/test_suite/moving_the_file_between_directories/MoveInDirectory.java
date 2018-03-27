package test_suite.moving_the_file_between_directories;

import com.service.IFile;
import com.service.impl.FileService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import test_suite.TestUtils;

/**
 * Класс используеться для перемещения ямл файла, в директорию парсера
 */
public class MoveInDirectory extends TestUtils {
    private IFile fileService = new FileService();

    /**
     * Метод копирует ямл файл в директорию парсера
     *
     * @param directorySource директория, используемая парсером, для считывания файлов
     * @param pathToYmlFIle   путь к ямл файлу
     */
    @Parameters({"pathToYmlFile", "directorySource"})
    @BeforeMethod
    public void init(String pathToYmlFIle, String directorySource) {
        fileService.copyFile(pathToYmlFIle, directorySource);
    }

    boolean isExistsFileInDirectory(String pathDirectory) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return fileService.isExistingFile(pathDirectory);
    }
}
