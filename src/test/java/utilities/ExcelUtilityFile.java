package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityFile {
    
    private FileInputStream inputStream;
    private XSSFWorkbook workbook;
    private XSSFSheet excelsheet;
    private XSSFRow row;
    private XSSFCell cell;
    private String path;
    
    public ExcelUtilityFile(String path) {
        this.path = path;
    }
    
    public int getRowCount(String sheetName) throws IOException {
        inputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(inputStream);
        excelsheet = workbook.getSheet(sheetName);
        int rowCount = excelsheet.getLastRowNum() + 1;
        inputStream.close();
        return rowCount;
    }
    
    public int getCellCount(String sheetName, int rownum) throws IOException {
        inputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(inputStream);
        excelsheet = workbook.getSheet(sheetName);
        row = excelsheet.getRow(rownum);
        int cellCount = row.getLastCellNum();
        workbook.close();
        inputStream.close();
        return cellCount;
    }
    
    public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
        inputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(inputStream);
        excelsheet = workbook.getSheet(sheetName);
        row = excelsheet.getRow(rownum);
        cell = row.getCell(colnum);
        
        String cellData = "";
        
        // Using CellType enum instead of deprecated constants
        if (cell.getCellType() == CellType.STRING) {
            cellData = cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            cellData = String.valueOf(cell.getNumericCellValue());
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            cellData = String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == CellType.BLANK) {
            cellData = "";
        } else {
            cellData = "Invalid Cell Type";
        }
        
        workbook.close();
        inputStream.close();
        
        return cellData;
    }
}
