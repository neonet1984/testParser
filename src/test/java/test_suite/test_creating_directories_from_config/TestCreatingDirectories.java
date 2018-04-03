package test_suite.test_creating_directories_from_config;

import com.service.IFile;
import com.service.impl.FileService;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_suite.PathsToDirectories;

import static org.testng.Assert.assertTrue;

/**
 * Тест проверяет верность созданных директорый, исходя из app.properties парсера
 */
public class TestCreatingDirectories {
    private IFile fileService = new FileService();

    @DataProvider(name = "paths")
    private Object[] getPaths() {
        return new Object[][]{
                {PathsToDirectories.DIRECTORY_SOURCE},
                {PathsToDirectories.DIRECTORY_OUTPUT},
                {PathsToDirectories.DIRECTORY_ERROR},
                {PathsToDirectories.DIRECTORY_SUCCESS}
        };
    }

    /**
     * Данный тест проверяет верно ли создались, директории, исходя из конфигураций парсера
     *
     * @param pathToDirectory
     */
    @Test(dataProvider = "paths")
    public void test(String pathToDirectory) {
        assertTrue(fileService.isDirectory(pathToDirectory));
    }
}
