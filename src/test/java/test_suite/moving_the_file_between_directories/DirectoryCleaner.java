package test_suite.moving_the_file_between_directories;

import com.service.impl.FileService;
import com.utils.UtilsPath;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test_suite.KeyUsedInPropertiesParser;

import java.util.stream.Stream;

/**
 * Класс содержит общую фунциональность используемую в тестах
 */
public class DirectoryCleaner {
    private FileService fileService = new FileService();

    /**
     * Метод будет отрабатывать перед каждым методом теста,
     * используеться для очистки директорий до начала теста и после
     */
    @BeforeMethod
    @AfterMethod(alwaysRun = true)
    public void clearDirectory() {

        Stream.of(
                System.getProperty("directory.source.files"),
                System.getProperty("directory.out.files"),
                System.getProperty("directory.error.files"),
                System.getProperty("directory.success.files"))
                .forEach(directory -> fileService.clearDirectory(directory));
    }

    protected void copyYmlFileToSourceDirectory(String pathToYmlFile) {
        fileService.copyFile(UtilsPath.getAbsolutePathToAutoTest() + pathToYmlFile,
                System.getProperty(KeyUsedInPropertiesParser.DIRECTORY_SOURCE));
    }
}

