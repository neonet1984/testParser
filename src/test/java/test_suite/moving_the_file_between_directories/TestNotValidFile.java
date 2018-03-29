package test_suite.moving_the_file_between_directories;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test_suite.KeyUsedInPropertiesParser;

import static org.testng.Assert.assertTrue;

/**
 * Класс содержит тест проверяющий верность перемещения, парсером, не валидного файла
 * в директорию, предназначенную для не валидных файлов
 */
public class TestNotValidFile extends Moving {
    private String pathToValidYmlFile;

    @BeforeClass
    @Parameters({"pathToNotValidYmlFile"})
    private void init(String pathToYmlFile) {
        this.pathToValidYmlFile = pathToYmlFile;
    }


    @DataProvider(name = "namesNotValidFiles")
    private Object[][] getNameValidYmlFiles() {
        return new Object[][]{
                {"not_valid_gus.yml"},
                {"not_valid_people.yml"}
        };
    }

    /**
     * Тест проверяет верность перемещения, парсером, не валидного файла
     * в директорию, предназначенную для не валидных файлов
     *
     * @param namesNotValidFiles имя не валидного файла
     */
    @Test(dataProvider = "namesNotValidFiles")
    public void testMoveDirectory(String namesNotValidFiles) {
        copyYmlFileToSourceDirectory(pathToValidYmlFile + namesNotValidFiles);
        boolean isExistingNotValidFile = isExistsFileInDirectory(System.getProperty(KeyUsedInPropertiesParser.DIRECTORY_ERROR));
        assertTrue(isExistingNotValidFile);
    }
}
