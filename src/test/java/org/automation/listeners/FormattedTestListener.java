package org.automation.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattedTestListener implements ITestListener {

    private FileWriter writer;

    public FormattedTestListener() {
        try {
            writer = new FileWriter("custom_testListeners-output/formatted-listener-log.txt", false); // false to overwrite, true to append
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void log(String status, ITestResult result) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String message = String.format(
                    "[%s] %s - Test: %s | Parameters: %s | Duration: %dms",
                    timestamp,
                    status,
                    result.getName(),
                    result.getParameters() != null ? result.getParameters() : "None",
                    result.getEndMillis() - result.getStartMillis()
            );
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        log("PASSED", result);
    } // ITestResult - test info, name, parameters, duration

    @Override
    public void onTestFailure(ITestResult result) {
        log("FAILED", result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log("SKIPPED", result);
    }

    @Override
    public void onStart(ITestContext context) { // ITestContext - info about the test suite, test methods run, name, suite, start time
        try {
            writer.write("Test suite started: " + context.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            writer.write("Test suite finished: " + context.getName() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
