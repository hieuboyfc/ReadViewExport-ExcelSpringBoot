package hieuboy.excel.utils;

import hieuboy.excel.model.Customer;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateExcelDemo {
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {

        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static void main(String[] args) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employee Sheet");
        List<Customer> lstCustomer = new ArrayList<Customer>();
        lstCustomer.add(new Customer(1, "Hiếu Boy","Hải Phòng", "hieuboyfc@gmail.com",113));
        lstCustomer.add(new Customer(2, "Đỗ Trung Hiếu","Hải Phòng", "vip.hieuboy@yahoo.com",114));
        int rowNum = 0;
        Row row;
        Cell cell;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rowNum);

        cell = row.createCell(0, CellType.NUMERIC);
        cell.setCellValue("Id");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Name");
        cell.setCellStyle(style);

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Address");
        cell.setCellStyle(style);

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Email");
        cell.setCellStyle(style);

        cell = row.createCell(4, CellType.NUMERIC);
        cell.setCellValue("Number Phone");
        cell.setCellStyle(style);

        // Data
        for (Customer customer : lstCustomer) {
            rowNum++;
            row = sheet.createRow(rowNum);

            cell = row.createCell(0,CellType.NUMERIC);
            cell.setCellValue(customer.getId());

            cell = row.createCell(1,CellType.STRING);
            cell.setCellValue(customer.getName());

            cell = row.createCell(2,CellType.STRING);
            cell.setCellValue(customer.getAddress());

            cell = row.createCell(3,CellType.STRING);
            cell.setCellValue(customer.getEmail());

            cell = row.createCell(4,CellType.NUMERIC);
            cell.setCellValue(customer.getNumberPhone());

        }


        FileOutputStream outputStream = new FileOutputStream("ExcelDemo.xls");
        workbook.write(outputStream);
        System.out.println("Created file success");
    }
}
