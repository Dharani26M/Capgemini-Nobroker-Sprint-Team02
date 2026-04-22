package com.nobroker.sprint.utils;

import org.openqa.selenium.WebDriver;

public class BaseClass {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public WebDriver driver; 

    public void setDriver(WebDriver driver) {
        this.driver = driver;
        driverThreadLocal.set(driver);
    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void removeDriver() {
        driverThreadLocal.remove();
    }
}