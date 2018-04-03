package utils;

import com.service.IRunParser;
import com.service.impl.RunParserService;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Класс преднозначен , для запуска и остановки парсера
 */
public class UtilsParser {
    private IRunParser runParser = new RunParserService();

    /**
     * Метод испльзуется, для запуска парсера
     *
     * @param rootPathToParser корневой путь к парсеру
     */
    @Parameters("rootPathToParser")
    @Test
    public void startupParser(String rootPathToParser) {
        runParser.startupParser(rootPathToParser);
    }

    /**
     * Метод отанавливает парсер
     */
    @Test
    public void stopParser() {
        runParser.closeParser();
    }
}
