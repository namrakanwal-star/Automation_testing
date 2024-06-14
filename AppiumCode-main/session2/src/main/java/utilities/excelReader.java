package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class excelReader {

    //number of sheets
    private static XSSFSheet mSheet;
    static configFileReader configReader;

    public excelReader() {
    }

    public static void readExcelFile() {
        configReader = new configFileReader();
        if (mSheet != null) {
            return;
        }
        //file path get
        File src = new File(configReader.getExcelPath());

        try {
            //read the file, streams of chracter decode
            FileInputStream file = new FileInputStream(src);

//read and write excelfiles, sheets, properties
            XSSFWorkbook wb = new XSSFWorkbook(file);

            mSheet = wb.getSheetAt(0);

        } catch (Exception ex) {
            System.out.println("You got: " + ex);
        }
    }

    public static String GetCellValue(int row, int column) {
        if (mSheet == null) {
            return "";
        }
        XSSFCell cell = mSheet.getRow(row).getCell(column);
        return cell.getStringCellValue();
    }

}

