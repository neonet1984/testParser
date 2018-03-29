package test_suite.test_parsing_functionality;

import com.service.IFile;
import com.service.IReader;
import com.service.impl.FileService;
import com.service.impl.ReaderService;
import org.testng.annotations.*;
import test_suite.KeyUsedInPropertiesParser;
import test_suite.moving_the_file_between_directories.DirectoryCleaner;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * Тест проверяет валидность содержание конвертированного ямл файла
 */
public class TestParsingFile extends DirectoryCleaner {
    private static String PATH_TO_VALID_YML_FILE;
    private static String PATH_TO_DIRECTORY_EXPECT_FILE;
    private IReader readerService = new ReaderService();
    private IFile fileService = new FileService();

    @DataProvider(name = "Data")
    private static Object[][] credentials() {
        return new Object[][]{
                {"people.yml", "people.properties"},
                {"not_valid_people.yml", "people.properties"}
        };
    }

    /**
     * Метод проверяет кооректность конвертированного ямл файла
     *
     * @param pathToValidYmlFile        относительный путь к директории , содержащей валидные ямл файлы
     * @param pathToDirectoryExpectFile относительный путь к директории, содержащей ожидаемые, от конвертатора файлы
     */
    @BeforeClass
    @Parameters({"pathToValidYmlFile", "pathToDirectoryExpectFile"})
    public void init(String pathToValidYmlFile, String pathToDirectoryExpectFile) {
        PATH_TO_VALID_YML_FILE = pathToValidYmlFile;
        PATH_TO_DIRECTORY_EXPECT_FILE = pathToDirectoryExpectFile;
    }

    /**
     * Тест проверяет кооректность конвертированного ямл файла
     *
     * @param nameYmlFile        имя ямл файла для теста
     * @param namePropertiesFile имя файла, с которым будет вестить сравнения верности парсинга
     */
    @Test(dataProvider = "Data")
    public void testForCorrectConversion(String nameYmlFile, String namePropertiesFile) throws InterruptedException, IOException {
        copyYmlFileToSourceDirectory(PATH_TO_VALID_YML_FILE + nameYmlFile);
        Thread.sleep(4000);
        String pathFile = fileService.getFileName(System.getProperty(KeyUsedInPropertiesParser.DIRECTORY_OUTPUT));
        String actualData = readerService.readFileToString(pathFile);
        String expectData = readerService.readFileToString(PATH_TO_DIRECTORY_EXPECT_FILE + "\\" + namePropertiesFile);
        assertEquals(actualData, expectData);
    }
}
