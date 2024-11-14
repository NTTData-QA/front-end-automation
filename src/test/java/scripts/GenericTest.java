package scripts;

import com.aventstack.extentreports.ExtentReports;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import utilities.*;

import java.lang.reflect.ParameterizedType;

import static helpers.Runners.runAccessibilityCopy;
import static helpers.Runners.runAllureReport;

@ExtendWith(TestErrorHandler.class)
public abstract class GenericTest<T> {

    protected T controller;
    protected static ExtentReports extent;

    @BeforeAll
    public static void cleanReportsAndLogs() {
        JSExecutor.runCommand(
                LocalEnviroment.isWindows()
                        ? Constants.EXTENT_CLEAN_COMMAND_WIN
                        : Constants.EXTENT_CLEAN_COMMAND_MAC);
        extent = ExtentReport.setUpReport();
    }

    @AfterAll
    public static void runReports() {
        extent.flush();
        runAllureReport();
        runAccessibilityCopy();
    }

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        controller = createControllerInstance();
        ExtentReport.test = ExtentReport.getExtent().createTest(this.getClass().getSimpleName().concat("_").concat(testInfo.getDisplayName()));
    }

    @SuppressWarnings("unchecked")
    private T createControllerInstance() {
        try {
            return ((Class<T>)
                    ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0])
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create controller instance", e);
        }
    }

    @AfterEach
    public void tearDown() {
        Accessibility.checkAccessibility();
        NetworkLogs.getNetworkLogs();
    }
}
