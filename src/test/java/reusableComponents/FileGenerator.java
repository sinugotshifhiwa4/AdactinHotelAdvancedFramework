package reusableComponents;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.apache.commons.exec.util.DebugUtils.handleException;

public class FileGenerator {

    private final String filePath = "src/test/resources/orderNumber.txt";

    public void writeToFile(String orderNumber) {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(orderNumber);
        } catch (IOException e) {
            handleException("writeToFile", e);
        }
    }

    public String readFromFile() {
        String orderNumFromFile = null;

        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);

            if (myReader.hasNextLine()) {
                orderNumFromFile = myReader.nextLine();
            }

        } catch (FileNotFoundException e) {
            handleException("readFromFile", e);
        }

        return orderNumFromFile;
    }
}
