package test_suite.test_creating_directories_from_config;

import com.service.IFile;
import com.service.IReader;
import com.service.impl.FileService;
import com.service.impl.ReaderService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertTrue;

/**
 * Тест проверяет верность созданных директорый, исходя из app.properties парсера
 */
public class TestCreatingDirectories {
    private static String PATH_TO_ROOT_DIRECTORY_WITH_PARSER;
    private IFile fileService = new FileService();
    private IReader readerService = new ReaderService();
    private Map<String, String> keyValueConfig = new HashMap<>();
    private List<String> pats = new ArrayList<>();

    /**
     * Метод используеться для инитиализации
     *
     * @param pathToRootDirectoryWithParser путь к корню парсера
     */
    @BeforeClass
    @Parameters("pathToRootDirectoryWithParser")
    public void init(String pathToRootDirectoryWithParser) {
        PATH_TO_ROOT_DIRECTORY_WITH_PARSER = pathToRootDirectoryWithParser;
        initKeyValueConfig();
        readAppConfig();
        keyValueConfig.forEach((key, value) -> addPathFromAppConfigToGolbalListDirectory(value));
    }

    /**
     * Тест проверяет верность созданных директорый
     */
    @Test
    public void test() {
        assertTrue(pats.stream().allMatch(pathToDirectory -> fileService.isDirectory(pathToDirectory)));
    }

    private void deleteKeyValueConfig(String keyValue) {
        keyValue = keyValue.split("=")[0];
        keyValueConfig.remove(keyValue);
    }

    private void addPathToGlobalListPaths(String path) {
        String path2 = path.split("=")[1];
        pats.add(path2);
        deleteKeyValueConfig(path);
    }

    private void addPathFromAppConfigToGolbalListDirectory(String path) {
        pats.add(PATH_TO_ROOT_DIRECTORY_WITH_PARSER + "\\" + path);
    }

    private void initKeyValueConfig() {
        keyValueConfig.put("directory.source.files", "");
        keyValueConfig.put("directory.out.files", "directory_output");
        keyValueConfig.put("directory.error.files", "directory_error");
        keyValueConfig.put("directory.success.files", "directory_success");
    }

    private void readAppConfig() {
        List<String> appConfig = readerService.readToFileList(PATH_TO_ROOT_DIRECTORY_WITH_PARSER + "\\app.properties");
        appConfig.remove(appConfig.size() - 1);
        appConfig.forEach(this::addPathToGlobalListPaths);
    }
}
