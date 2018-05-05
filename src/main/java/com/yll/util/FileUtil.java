package main.java.com.yll.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author：linlin.yang
 * @date：2018/3/23 17:22
 */
public class FileUtil {
    private static final String filePath = "D:/yll/project/my/git/algorithm/test-case.xlsx";
    public static void main(String[] args) {
        List<List<Object>> lists = readTestCases("DeleteDuplicateTest");
        for (List<Object> list : lists) {
            System.out.println("id：" + list.get(0));
            System.out.println("input：" + list.get(1));
            System.out.println("output：" + list.get(2));
        }
    }

    public static List<List<Object>> readTestCases(String testClassName) {
        return readExcel2007(filePath, testClassName);
    }
    public static List<List<Object>> readExcel2007(String filePath,String sheetName) {
        File file = new File(filePath);
        if (file == null || !file.exists()) {
            System.out.println("文件不存在，filePath：" + filePath);
            return null;
        }

        List<List<Object>> rowList = new ArrayList<List<Object>>();
        try {

            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
            System.out.println(Thread.currentThread().getStackTrace()[1].getClassName());
            XSSFSheet sheet = workbook.getSheet(sheetName);//TODO 改成动态获取测试类名
            XSSFRow row;
            XSSFCell cell;
            Object value;

            //第一行是标题，从第二行开始读取数据
            for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                row = sheet.getRow(i);
                List<Object> colList = new ArrayList<Object>();
                for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++) {
                    cell = row.getCell(j);
                    switch (cell.getCellTypeEnum()) {
                        case STRING:
                            value = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            value = String.valueOf((int) cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            value = cell.getBooleanCellValue();
                            break;
                        default:
                            value = "";
                            break;
                    }

                    colList.add(value);
                }
                rowList.add(colList);
            }


        } catch (Exception e) {
            System.out.println("读取文件异常，error：" + e.getMessage());
            return null;
        }

        return rowList;
    }

}
