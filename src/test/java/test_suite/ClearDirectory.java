package test_suite;

import com.service.impl.FileService;

import org.testng.annotations.*;
import java.util.stream.Stream;

/**
 * Класс содержит общую фунциональность используемую в тестах
 */
public class ClearDirectory {
    private FileService fileService = new FileService();

    /**
     * Метод будет отрабатывать перед каждым методом теста,
     * используеться для очистки директорий до начала теста и после
     */
    @BeforeMethod
    @AfterMethod(alwaysRun = true)
    public void clearDirectory() {
        Stream.of(
                PathsToDirectories.DIRECTORY_SOURCE,
                PathsToDirectories.DIRECTORY_SUCCESS,
                PathsToDirectories.DIRECTORY_OUTPUT,
                PathsToDirectories.DIRECTORY_ERROR
        )
                .forEach(directory -> fileService.clearDirectory(directory));

    }
}