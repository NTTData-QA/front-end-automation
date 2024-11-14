package scripts;

import static helpers.Runners.runAccessibilityCopy;
import static helpers.Runners.runAllureReport;

import java.lang.reflect.ParameterizedType;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import utilities.*;

@ExtendWith(TestErrorHandler.class)
public abstract class GenericTest<T> {

  protected T controller;

  @BeforeAll
  public static void cleanReportsAndLogs() {
    JSExecutor.runCommand(
        LocalEnviroment.isWindows()
            ? Constants.ALLURE_CLEAN_COMMAND_WIN
            : Constants.ALLURE_CLEAN_COMMAND_MAC);
    AllureReport.fillReportInfo();
  }

  @AfterAll
  public static void runReports() {
    runAllureReport();
    runAccessibilityCopy();
  }

  @BeforeEach
  public void setUp() {
    controller = createControllerInstance();
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
    AllureReport.fillReportInfo();
  }
}
