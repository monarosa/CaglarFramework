package tests;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
public class ExcelRead {
    public static void main(String[] args) throws Exception {
        String filePath="C:/Users/rukal/Desktop/employees.xls";
        //open file and convert to a stream data
        FileInputStream inStream= new FileInputStream(filePath);
        //take the stream of data and use it as workbook
        Workbook workbook= WorkbookFactory.create(inStream);
        //get the first worksheet
        Sheet worksheet=workbook.getSheetAt(0);
        Row row=worksheet.getRow(0);
        Cell cell=row.getCell(0);

       // System.out.println(cell.toString());
        int rowsCount=worksheet.getLastRowNum();//getPhysicalNumberOfRows();
        //.getLastRowNum(); returns last raw that has value, counts null rows as well
        System.out.println("num of row :"+rowsCount);


for(int rowNum=0; rowNum<=rowsCount; rowNum++){

    if(worksheet.getRow(rowNum)!=null){System.out.println(rowNum+" - "+worksheet.getRow(rowNum).getCell(0));}
}


        for (int i = 0; i < worksheet.getPhysicalNumberOfRows(); i++) {
            Row myRow=worksheet.getRow(i);
            if(myRow.getCell(0).toString().equals("nancy")){
                System.out.println("Nancy works as "+ myRow.getCell(2));
                break;
            }

        }







        workbook.close();
        inStream.close();
    }





}
