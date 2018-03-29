package test_suite.moving_the_file_between_directories;

import org.testng.annotations.*;
import test_suite.KeyUsedInPropertiesParser;

import static org.testng.Assert.assertTrue;

/**
 * Класс проверяет верность перемещения валидного ямл файла
 */
public class TestValidFile extends Moving {
    private String pathToValidYmlFile;

    @BeforeClass
    @Parameters({"pathToValidYmlFile"})
    private void init(String pathToYmlFile) {
        this.pathToValidYmlFile = pathToYmlFile;
    }

    @DataProvider(name = "namesValidFiles")
    private Object[][] getNameValidYmlFiles() {
        return new Object[][]{
                {"gus.yml"},
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
    @Test(dataProvider = "namesValidFiles")
    public void testMoveDirectory(String nameValidFiles) {
        copyYmlFileToSourceDirectory(pathToValidYmlFile + nameValidFiles);
        boolean isYmlFileInDirectorySuccess = isExistsFileInDirectory(System.getProperty(KeyUsedInPropertiesParser.DIRECTORY_SUCCESS));
        assertTrue(isYmlFileInDirectorySuccess);
        boolean isPropertiesFileInDirectoryOutput = isExistsFileInDirectory(System.getProperty(KeyUsedInPropertiesParser.DIRECTORY_OUTPUT));
        assertTrue(isPropertiesFileInDirectoryOutput);
    }
}
