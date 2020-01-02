package tests;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GasMilageCalculatorPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class BasicDataDrivenTest {

    private static WebDriver driver;
    Workbook workbook;
    Sheet worksheet;
    GasMilageCalculatorPage gasPage;
    FileInputStream inStream;
    FileOutputStream outStream;
    public static final int CORRUNT_OD_COLUMN = 1;
    public static final int PREVIUOS_OD_COLUMN = 2;
    public static final int GAS_COLUMN = 3;
    public static final int EXPECTED = 4;
    public static final int ACTUAL = 5;
    public static final int STATUS = 6;
    public static final int TIME = 7;
    @BeforeClass()
    public void setUp() throws Exception {
        inStream = new FileInputStream(ConfigurationReader.getProperty("gasmilage.testdata.path"));

        workbook = WorkbookFactory.create(inStream);
        driver = Driver.getDriver();
        worksheet = workbook.getSheetAt(0);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.calculator.net/gas-mileage-calculator.html");

    }

    @Test
    public void dataDriverMilagetest() throws IOException {

        for (int rowNum = 1; rowNum < worksheet.getPhysicalNumberOfRows(); rowNum++) {
            System.out.println("TEST" + rowNum + "##############################################");

            Row currentRow = worksheet.getRow(rowNum);
            if(!currentRow.getCell(0).toString().equalsIgnoreCase("Y")){
                if(currentRow.getCell(6)==null){currentRow.createCell(6);
                }
                currentRow.getCell(6).setCellValue("skip requested");
                continue;
            }
            double currentOr = currentRow.getCell(CORRUNT_OD_COLUMN).getNumericCellValue();
            double previosOr = currentRow.getCell(PREVIUOS_OD_COLUMN).getNumericCellValue();
            double gas = currentRow.getCell(GAS_COLUMN).getNumericCellValue();

            gasPage = new GasMilageCalculatorPage();
            gasPage.clear.click();
            gasPage.curruntOdemeterReading.sendKeys(String.valueOf(currentOr));
            gasPage.previousOdometerReading.sendKeys(String.valueOf(previosOr));
            gasPage.gasAdded.sendKeys(String.valueOf(gas));
            gasPage.calculate.click();
            String[] result = gasPage.result.getText().split(" ");

            System.out.println(result[0]);
            //write result to ACTUAL  result column
            if(currentRow.getCell(ACTUAL)==null){currentRow.createCell(ACTUAL);}
            currentRow.getCell(ACTUAL).setCellValue(result[0]);

            double calcuationResult = (currentOr - previosOr) / gas;
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            //write EXPECED to ACTUAL  result column

            if(currentRow.getCell(EXPECTED)==null){currentRow.createCell(EXPECTED);}
                currentRow.getCell(EXPECTED).setCellValue(decimalFormat.format(calcuationResult));

            System.out.println(decimalFormat.format(calcuationResult));
            //Assert.assertEquals(result[0], (decimalFormat.format(calcuationResult)));

            if(currentRow.getCell(TIME)==null){currentRow.createCell(TIME);}
                currentRow.getCell(TIME).setCellValue(LocalDateTime.now().toString());

            if(currentRow.getCell(STATUS)==null){currentRow.createCell(STATUS);}

            if (result[0].equals(decimalFormat.format(calcuationResult))) {
                System.out.println("pass");
                currentRow.getCell(STATUS).setCellValue("pass");

            } else {
                System.out.println("fail");
                currentRow.getCell(STATUS).setCellValue("fail");
            }




        }
    }

    @AfterClass()
    public void tearDown() throws IOException {
        outStream = new FileOutputStream(ConfigurationReader.getProperty("gasmilage.testdata.path"));
        workbook.write(outStream);
        inStream.close();
        workbook.close();
        outStream.close();
        Driver.close();
    }

}
