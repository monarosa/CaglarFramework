package tests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {
    public static void main(String[] args) throws IOException {
        String testDataPath = "./src/test/resources/testdata/employees.xls";

        FileInputStream inStream =new FileInputStream(testDataPath);
        Workbook workbook= WorkbookFactory.create(inStream);
        Sheet worksheet=workbook.getSheet("Sheet1");
        Cell job=worksheet.getRow(6).getCell(2);

        job.setCellValue("auomation developer");

        FileOutputStream outStream=new FileOutputStream(testDataPath);
        workbook.write(outStream);
    outStream.close();
    inStream.close();
    workbook.close();

    }
}
