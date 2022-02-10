package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import utils.browsers.BrowserManager;
import utils.logger.TAFLogger;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Waiters {
    public static final int period = 500;
    public static final int timeout = 30;
    protected static final Logger logger = TAFLogger.logger;

    public static boolean waitUntilCondition(Callable<Boolean> condition,
                                             int timeout,
                                             int period,
                                             String message) {
        String msg = message.isEmpty() ? "Condition is not true" : String.format("Condition '%s' is not true", message);
        long timeStart = System.currentTimeMillis();
        long timeExit = timeStart + timeout * 1000L;
        logger.debug(String.format("Executing condition '%s'", message));
        do {
            try {
                boolean result = condition.call();
                if (!result) {
                    throw new Exception(msg);
                }
                return result;
            } catch (Exception e) {
                logger.debug(msg);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(period);
            } catch (InterruptedException e) {
                logger.warn(e.getMessage());
            }
        }
        while (System.currentTimeMillis() < timeExit);

        return false;
    }

    public static boolean pollUntilCondition(Callable<Boolean> condition,
                                             String message) {
        String msg = message.isEmpty() ? "Condition is not true" : String.format("Condition '%s' is not true", message);
        try {
            while (!condition.call()) {
                BrowserManager.getBrowser().getDriver().navigate().refresh();
            }
            return true;
        } catch (Exception e) {
            logger.debug(msg);
        }
        return false;
    }

    public static boolean waitUntilCondition(Callable<Boolean> condition, int timeout, int period) {
        return waitUntilCondition(condition, timeout, period, "");
    }

    public static boolean waitUntilCondition(Callable<Boolean> condition, int timeout) {
        return waitUntilCondition(condition, timeout, period, "");
    }

    public static boolean waitUntilCondition(Callable<Boolean> condition) {
        return waitUntilCondition(condition, timeout, period, "");
    }

    public static boolean waitUntilCondition(Callable<Boolean> condition, String message) {
        return waitUntilCondition(condition, timeout, period, message);
    }

    public static boolean waitUntilCondition(Callable<Boolean> condition, int timeout, String message) {
        return waitUntilCondition(condition, timeout, period, message);
    }

    public static WebElement findElement(By by,
                                         SearchContext context,
                                         int timeout,
                                         int period) {
        WebElement webElement = null;
        long timeStart = System.currentTimeMillis();
        long timeExit = timeStart + timeout * 1000L;
        do {
            try {
                webElement = context.findElement(by);
                return webElement;
            } catch (NotFoundException e) {
                logger.info("Cannot find element using strategy " + by.toString() + ".\nBecause of " + e.getMessage());
            }
            try {
                TimeUnit.MILLISECONDS.sleep(period);
            } catch (InterruptedException e) {
                logger.warn(e.getMessage());
            }
        }
        while (System.currentTimeMillis() < timeExit);

        return webElement;
    }

    public static List<WebElement> findElements(By by,
                                                SearchContext context,
                                                int timeout,
                                                int period) {
        List<WebElement> webElements = null;
        long timeStart = System.currentTimeMillis();
        long timeExit = timeStart + timeout * 1000L;
        do {
            try {
                webElements = context.findElements(by);
                if (!webElements.isEmpty()) return webElements;
                else logger.debug("Cannot find element using strategy " + by.toString());
            } catch (NotFoundException e) {
                logger.debug("Cannot find element using strategy " + by.toString());
            }
            try {
                TimeUnit.MILLISECONDS.sleep(period);
            } catch (InterruptedException e) {
                logger.warn(e.getMessage());
            }
        }
        while (System.currentTimeMillis() < timeExit);

        return webElements;
    }

    public static List<WebElement> findElements(By by, SearchContext context, int timeout) {
        return findElements(by, context, timeout, period);
    }
}
