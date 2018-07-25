package hieuboy.excel.utils;

import hieuboy.excel.model.Customer;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcelDemo {
    public static void main(String[] args) throws IOException {
        // Đọc file có đuôi xls
        FileInputStream inputStream = new FileInputStream(new File("ExcelDemo.xls"));

        // Đối tượng workbook cho file XSL.
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

        // Lấy re sheet đầu tiên từ workbook
        HSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> iterator = sheet.iterator();
        Row firstRow = iterator.next();

        List<Customer> lstCustomer = new ArrayList<Customer>();
        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            Customer customer = new Customer();
            customer.setId((int) currentRow.getCell(0).getNumericCellValue());
            customer.setName(currentRow.getCell(1).getStringCellValue());
            customer.setAddress(currentRow.getCell(2).getStringCellValue());
            customer.setEmail(currentRow.getCell(3).getStringCellValue());
            customer.setNumberPhone((int) currentRow.getCell(4).getNumericCellValue());
            lstCustomer.add(customer);
        }
        for (Customer customer : lstCustomer) {
            System.out.println(customer);
        }
        workbook.close();
    }
}
