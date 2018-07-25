package hieuboy.excel.service;

import hieuboy.excel.model.Customer;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CustomerService {

    public static List<Customer> lstCustomer = new ArrayList<Customer>();

    static {
        try {
            FileInputStream inputStream = new FileInputStream(new File("ExcelDemo.xls"));

            // Đối tượng workbook cho file XSL.
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

            // Lấy re sheet đầu tiên từ workbook
            HSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> iterator = sheet.iterator();
            Row firstRow = iterator.next();

            //List<Customer> customerList = new ArrayList<Customer>();

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
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi SML Rồi !");
        }
    }

    public List<Customer> getCustomerList() {
        return lstCustomer;
    }

}
