package test_suite;

import com.service.IFile;
import com.service.impl.FileService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import java.util.stream.Stream;

/**
 * Класс испльзуеться для очистки директорий
 */
public class TestUtils {
    private IFile fileService = new FileService();

    /**
     * Данный метод будет использоваться в конце прохождения тестов, что бы ощистить директории
     *
     * @param outputDirectory  путь к директории, в которой храняться конвертированные ямл файлы
     * @param successDirectory путь к директории, в которой храняться удачно конвертированные ямл файлы
     * @param errorDirectory   путь к директории, в которой храняться не валидные ямл файлы
     * @param sourceDirectory  путь к директории, которая используеться парсером для конвертации ямл файла
     */
    @Parameters({"directoryOutput", "directorySuccess", "directoryError", "directorySource"})
    @AfterMethod(alwaysRun = true)
    public void clearDirectory(String outputDirectory, String successDirectory, String errorDirectory, String sourceDirectory) {
        Stream.of(outputDirectory, successDirectory, errorDirectory)
                .forEach(directory -> fileService.clearDirectory(directory));
    }
}
