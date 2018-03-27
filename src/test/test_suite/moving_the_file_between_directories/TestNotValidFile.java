package test_suite.moving_the_file_between_directories;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Класс проверяет верность перемещения не валидного ямл файла
 */
public class TestNotValidFile extends MoveInDirectory {
    /**
     * метод проверяет верность перемещения не валидного ямл файла
     */
    @Test
    @Parameters("directoryError")
    public void testIsExistsFileInErrorDirectory(String directoryError) {
        boolean isExistingNotValidFile = isExistsFileInDirectory(directoryError);
        assertTrue(isExistingNotValidFile);
    }
}
