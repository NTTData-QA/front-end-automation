package scripts;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.HerokuApp;
import utilities.*;

import static helpers.Runners.runAccessibilityCopy;
import static helpers.Runners.runAllureReport;

public class HerokuAppTest {
    protected HerokuApp homePage;

    @BeforeAll
    public static void clean_reports_logs() {
        JSExecutor.runCommand(
                LocalEnviroment.isWindows()
                        ? Constants.ALLURE_CLEAN_COMMAND_WIN
                        : Constants.ALLURE_CLEAN_COMMAND_MAC);
        AllureReport.fillReportInfo();
    }

    @BeforeEach
    public void setUp(){
        homePage = new HerokuApp();
    }

    @AfterEach
    public void closeDriver() {
        Accessibility.checkAccessibility();
        NetworkLogs.getNetworkLogs();
        AllureReport.fillReportInfo();
    }

    @AfterAll
    public static void runReports() {
        runAllureReport();
        runAccessibilityCopy();
    }
}
