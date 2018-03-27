package test_suite.test_parsing_functionality;

import com.service.IFile;
import com.service.IReader;
import com.service.impl.FileService;
import com.service.impl.ReaderService;
import org.testng.annotations.*;
import test_suite.TestUtils;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * Тест проверяет валидность содержание конвертированного ямл файла
 */
public class TestParsingFile extends TestUtils {
    private static String PATH_TO_SOURCE_DIRECTORY;
    private static String PATH_TO_DIRECTORY_WITH_VALID_FILE;
    private static String PATH_TO_OUTPUT_DIRECTORY;
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
     * Класс проверяет кооректность конвертированного ямл файла
     *
     * @param directorySourceFiles         директория, используемая парсером, для считывания файлов
     * @param pathToDirectoryWithValidFile путь к валидному ямл файлу, который необходимо конвертировать
     * @param directoryOutputFiles         путь к директории, в которой храняться конвертированные ямл файлы
     * @param pathToDirectoryExpectFile    путь к файлу, с которомым необходимо сравнить, полученных конвертированный файл
     */
    @BeforeClass
    @Parameters({"directorySourceFiles", "pathToDirectoryWithValidFile", "directoryOutputFiles", "pathToDirectoryExpectFile"})
    public void initialization(String directorySourceFiles, String pathToDirectoryWithValidFile,
                               String directoryOutputFiles, String pathToDirectoryExpectFile) {
        PATH_TO_SOURCE_DIRECTORY = directorySourceFiles;
        PATH_TO_DIRECTORY_WITH_VALID_FILE = pathToDirectoryWithValidFile;
        PATH_TO_OUTPUT_DIRECTORY = directoryOutputFiles;
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
        fileService.copyFile(PATH_TO_DIRECTORY_WITH_VALID_FILE + "\\" + nameYmlFile, PATH_TO_SOURCE_DIRECTORY);
        Thread.sleep(6000);
        String pathFile = fileService.getFileName(PATH_TO_OUTPUT_DIRECTORY);
        String actualData = readerService.readFileToString(pathFile);
        String expectData = readerService.readFileToString(PATH_TO_DIRECTORY_EXPECT_FILE + "\\" + namePropertiesFile);
        assertEquals(actualData, expectData);
    }
}
