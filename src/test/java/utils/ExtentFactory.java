package utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {

    // private constructor so no one else can create an object of this class.
    // provide global access to that instance by creating getInstance method
    private ExtentFactory(){

    }

    private static ExtentFactory instance = new ExtentFactory();

    public static ExtentFactory getInstance(){

        return instance;
    }

    // ThreadLocal
    // singleton pattern - only one instance exists
    ThreadLocal<ExtentTest> extent = new ThreadLocal<>();

    public void setExtent(ExtentTest extentTestObject){
        extent.set(extentTestObject);
    }

    public ExtentTest getExtent(){
        return extent.get();
    }

    public void removeExtentObject(){

        extent.remove();
    }
}
