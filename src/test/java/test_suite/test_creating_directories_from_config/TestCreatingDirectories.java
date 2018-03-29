package test_suite.test_creating_directories_from_config;

import com.service.IFile;
import com.service.impl.FileService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_suite.KeyUsedInPropertiesParser;

import static org.testng.Assert.assertTrue;

/**
 * Тест проверяет верность созданных директорый, исходя из app.properties парсера
 */
public class TestCreatingDirectories {
    private IFile fileService = new FileService();
    private static final Logger log = LoggerFactory.getLogger(TestCreatingDirectories.class);

    @DataProvider(name = "paths")
    private Object[] getPaths() {
        return new Object[][]{
                {System.getProperty(KeyUsedInPropertiesParser.DIRECTORY_SOURCE)},
                {System.getProperty(KeyUsedInPropertiesParser.DIRECTORY_OUTPUT)},
                {System.getProperty(KeyUsedInPropertiesParser.DIRECTORY_ERROR)},
                {System.getProperty(KeyUsedInPropertiesParser.DIRECTORY_SUCCESS)}
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
