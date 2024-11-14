package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    ExcelUtilityFile ExcelUtility;

    @DataProvider(name = "LoginData")
    public Object[][] getData() throws IOException {
        String path = "./testData/data1.xlsx";
        ExcelUtility = new ExcelUtilityFile(path);
        
        // Get row and column count
        int rowCount = ExcelUtility.getRowCount("Sheet1");
        int colCount = ExcelUtility.getCellCount("Sheet1", 0);

        // Initialize 2D array to store data
        String[][] data = new String[rowCount - 1][colCount];

        // Read data from Excel and populate 2D array
        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = ExcelUtility.getCellData("Sheet1", i, j);
            }
        }
        return data; // Returning 2D array
    }
}
