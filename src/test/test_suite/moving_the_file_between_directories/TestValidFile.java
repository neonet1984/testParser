package test_suite.moving_the_file_between_directories;

import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

/**
 * Класс проверяет верность перемещения валидного ямл файла
 */
public class TestValidFile extends MoveInDirectory {
    /**
     * Метод проверяет верность перемещения валидного ямл файла
     * @param directorySuccess путь к директории, в которой храняться удачно конвертированные ямл файлы
     */
    @Parameters({"directorySuccess"})
    @Test
    public void testFileExistenceInSuccessDirectory(String directorySuccess) {
        boolean isYmlFileInDirectorySuccess = isExistsFileInDirectory(directorySuccess);
        assertTrue(isYmlFileInDirectorySuccess);
    }

    /**
     * Метод проверяет верность перемещения валидного ямл файла
     * @param  directoryOutput путь к директории, в которой храняться конвертированные ямл файлы
     */
    @Parameters({"directoryOutput"})
    @Test
    public void testFileExistenceInOutDirectory(String directoryOutput) {
        boolean isPropertiesFileInDirectoryOutput = isExistsFileInDirectory(directoryOutput);
        assertTrue(isPropertiesFileInDirectoryOutput);
    }
}
