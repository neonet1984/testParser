package test_suite.moving_the_file_between_directories;

import org.testng.annotations.*;
import test_suite.ClearDirectory;
import test_suite.PathsToDirectories;
import utils.UtilsFile;

import static org.testng.Assert.assertTrue;

/**
 * Класс проверяет верность перемещения валидного ямл файла
 */
public class TestValidFile extends ClearDirectory {
    private String pathToValidYmlFile;

    @BeforeClass
    @Parameters({"pathToValidYmlFile"})
    private void init(String pathToYmlFile) {
        this.pathToValidYmlFile = pathToYmlFile;
    }

    @DataProvider(name = "namesValidFiles")
    private Object[][] getNameValidYmlFiles() {
        return new Object[][]{
                //   {"gus.yml"},
                {"people.yml"}
        };
    }

    /**
     * Тест проверяет верность перемещения валидного ямл файла, в директорию
     * предназначенную, для размещения валидных ямл файлов, а так же проверяет существования
     * сконвертированного .properties файла
     *
     * @param nameValidFiles
     */
    @Test(timeOut = 15000, dataProvider = "namesValidFiles")
    public void testMoveDirectory(String nameValidFiles) {
        UtilsFile.copyYmlFileToSourceDirectory(pathToValidYmlFile + "\\" + nameValidFiles);
        boolean isYmlFileInDirectorySuccess = UtilsFile.isExistsFileInDirectory(PathsToDirectories.DIRECTORY_SUCCESS);
        assertTrue(isYmlFileInDirectorySuccess);
        boolean isPropertiesFileInDirectoryOutput = UtilsFile.isExistsFileInDirectory(PathsToDirectories.DIRECTORY_OUTPUT);
        assertTrue(isPropertiesFileInDirectoryOutput);
    }
}
