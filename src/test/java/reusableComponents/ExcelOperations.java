package reusableComponents;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelOperations {

    public List<Map<String, String>> readExcelData(String filePath, String sheetName) {
        List<Map<String, String>> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet != null) {
                int rowCount = sheet.getPhysicalNumberOfRows();

                if (rowCount > 0) {
                    Row headerRow = sheet.getRow(0);

                    for (int i = 1; i < rowCount; i++) {
                        Row currentRow = sheet.getRow(i);

                        // Check if currentRow is null before processing
                        if (currentRow == null) {
                            System.out.println("Row " + i + " is null in the sheet.");
                            continue;
                        }

                        Map<String, String> dataMap = new HashMap<>();

                        for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
                            Cell headerCell = headerRow.getCell(j);
                            Cell currentCell = currentRow.getCell(j);

                            if (headerCell != null && currentCell != null &&
                                    headerCell.getCellType() == CellType.STRING &&
                                    currentCell.getCellType() == CellType.STRING) {
                                dataMap.put(headerCell.getStringCellValue(), currentCell.getStringCellValue());
                            }
                        }

                        dataList.add(dataMap);
                    }
                } else {
                    System.out.println("No data found in the sheet.");
                }
            } else {
                System.out.println("Sheet not found in the workbook.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return dataList;
    }
}
