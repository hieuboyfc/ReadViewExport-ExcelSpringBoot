package hieuboy.excel.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hieuboy.excel.model.Customer;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

@Component("excelView")
public class CustomerExcelView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"Customer List.xls\"");

        // get data model which is passed by the Spring container
        List<Customer> lstCustomer = (List<Customer>) model.get("lstCustomer");

        // create a new Excel sheet
        Sheet sheet = workbook.createSheet("List Customer");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        // create header row
        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("Id");
        header.getCell(0).setCellStyle(style);

        header.createCell(1).setCellValue("Name");
        header.getCell(1).setCellStyle(style);

        header.createCell(2).setCellValue("Address");
        header.getCell(2).setCellStyle(style);

        header.createCell(3).setCellValue("Email");
        header.getCell(3).setCellStyle(style);

        header.createCell(4).setCellValue("Number Phone");
        header.getCell(4).setCellStyle(style);

        // create data rows
        int rowCount = 1;

        for (Customer customer : lstCustomer) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(customer.getId());
            row.createCell(1).setCellValue(customer.getName());
            row.createCell(2).setCellValue(customer.getAddress());
            row.createCell(3).setCellValue(customer.getEmail());
            row.createCell(4).setCellValue(customer.getNumberPhone());
        }
    }



}
