package test_suite;

import com.service.IReader;
import com.service.impl.ReaderService;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс используеться для чтения app.properties парсера, получение из
 * прочитанной конфигурции путей к директориям и установки этих путей в System проперти
 */
public class PathSet {
    private static String ROOT_PATH_TO_PARSER;
    private static String NAME_PROPERTIES_FILE_PARSER;
    private IReader readerService = new ReaderService();
    private Map<String, String> template = new HashMap<>();

    /**
     * Метод используеться для установки корневого пути к парсеру,
     * и устанавливает название для .properties файла парсера
     *
     * @param rootPathToParser         конревой путь к парсеру, устанавливаеться в файле masterSuite.xml
     * @param namePropertiesFileParser найменование конфигурационного файла для парсера, устанавливаться в  masterSuite.xml
     */
    @BeforeSuite
    @Parameters({"rootPathToParser", "namePropertiesFileParser"})
    public void processing(String rootPathToParser, String namePropertiesFileParser) {
        ROOT_PATH_TO_PARSER = rootPathToParser;
        NAME_PROPERTIES_FILE_PARSER = namePropertiesFileParser;
        initUsedTemplatePropertiesParser();
        setPathsInSystemProperties();
    }

    private void initUsedTemplatePropertiesParser() {
        template.put(KeyUsedInPropertiesParser.DIRECTORY_SOURCE, "");
        template.put(KeyUsedInPropertiesParser.DIRECTORY_OUTPUT, "directory_output");
        template.put(KeyUsedInPropertiesParser.DIRECTORY_ERROR, "directory_error");
        template.put(KeyUsedInPropertiesParser.DIRECTORY_SUCCESS, "directory_success");
    }

    private void setPathsInSystemProperties() {
        List<String> propertiesParser = readerService.readToFileList(ROOT_PATH_TO_PARSER + "\\" + NAME_PROPERTIES_FILE_PARSER);
        propertiesParser.removeIf(line->line.matches("time.out"));
        propertiesParser.forEach(this::setPathsFromPropertiesParserInSystemProperties);
        template.forEach((key, value) -> setPathsFromTemplateInSystemProperties(key));
    }

    private void deleteValuesForTemplate(String key) {
        template.remove(key);
    }

    private void setPathsFromPropertiesParserInSystemProperties(String value) {
        String[] keyValue = value.split("=");
        System.setProperty(keyValue[0], keyValue[1]);
        deleteValuesForTemplate(keyValue[0]);
    }

    private void setPathsFromTemplateInSystemProperties(String key) {
        System.setProperty(key, ROOT_PATH_TO_PARSER + "\\" + template.get(key));
    }
}
