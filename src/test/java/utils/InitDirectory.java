package utils;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test_suite.PathsToDirectories;

public class InitDirectory {
    @Parameters({"directory_source", "directory_output", "directory_error", "directory_success"})
    @Test
    public void initDirBeforeTest(String directory_source, String directory_output, String directory_error, String directory_success) {
        PathsToDirectories.DIRECTORY_SOURCE = directory_source;
        PathsToDirectories.DIRECTORY_OUTPUT = directory_output;
        PathsToDirectories.DIRECTORY_ERROR = directory_error;
        PathsToDirectories.DIRECTORY_SUCCESS = directory_success;
    }
}

