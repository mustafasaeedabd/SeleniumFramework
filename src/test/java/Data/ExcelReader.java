package Data;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    static FileInputStream fis = null;

    public FileInputStream getFileInputStream() {
        String filePath = System.getProperty
                ("user.dir") + "\\src\\test\\java\\Data\\userdata.xlsx";
        System.out.println(filePath);
        File srcFile = new File(filePath);
        try {
            fis = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("Test Data file not found. terminating process!! : check file path of TestData");
            System.exit(0);
        }
        return fis;
    }
    public Object[][] getExcelData () throws IOException {
        fis  = getFileInputStream();
        XSSFWorkbook  wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int totalNumberOfRow = (sheet.getLastRowNum()+1);
        int totalNumberOfColumn  = 4 ;
        String[][] arrayExcelData = new String[totalNumberOfRow][totalNumberOfColumn] ;
         for (int i = 0 ; i < totalNumberOfRow ; i++ ) {
             for (int j =0 ; j<totalNumberOfColumn ; j++){
                 XSSFRow row = sheet.getRow(i);
                 arrayExcelData[i][j] = row.getCell(j).toString();
             }
         }
         wb.close();
         return arrayExcelData;
    }

}
