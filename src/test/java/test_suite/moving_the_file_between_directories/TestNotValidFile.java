package test_suite.moving_the_file_between_directories;

import org.testng.annotations.*;
import test_suite.ClearDirectory;
import test_suite.PathsToDirectories;
import utils.UtilsFile;

import static org.testng.Assert.assertTrue;

/**
 * Класс содержит тест проверяющий верность перемещения, парсером, не валидного файла
 * в директорию, предназначенную для не валидных файлов
 */
public class TestNotValidFile extends ClearDirectory {
    private String pathToValidYmlFile;

    @BeforeClass
    @Parameters({"pathToNotValidYmlFile"})
    private void init(String pathToYmlFile) {
        this.pathToValidYmlFile = pathToYmlFile;
    }


    @DataProvider(name = "namesNotValidFiles")
    private Object[][] getNameValidYmlFiles() {
        return new Object[][]{
                // {"not_valid_gus.yml"},
                {"not_valid_people.yml"}
        };
    }

    /**
     * Тест проверяет верность перемещения, парсером, не валидного файла
     * в директорию, предназначенную для не валидных файлов
     *
     * @param namesNotValidFiles имя не валидного файла
     */
    @Test(timeOut = 10000, dataProvider = "namesNotValidFiles")
    public void testMoveDirectory(String namesNotValidFiles) {
        UtilsFile.copyYmlFileToSourceDirectory(pathToValidYmlFile + "\\" + namesNotValidFiles);
        boolean isExistingNotValidFile = UtilsFile.isExistsFileInDirectory(PathsToDirectories.DIRECTORY_ERROR);
        assertTrue(isExistingNotValidFile);
    }
}
