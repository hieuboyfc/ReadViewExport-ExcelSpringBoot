package hieuboy.excel.controller;

import hieuboy.excel.model.Customer;
import hieuboy.excel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ExcelController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/excel")
    public String home(ModelMap model) {
        model.addAttribute("lstCustomer", customerService.getCustomerList());
        return "excel";
    }

    /**
     * Handle request to download an Excel document
     */
    @GetMapping("/excel/download")
    public String download(Model model) {
        model.addAttribute("lstCustomer", customerService.getCustomerList());
        return "";
    }

    /*@GetMapping("/excel/download")
    public ModelAndView download(Model model) {
        List<Customer> customerList = customerService.getCustomerList();
        return new ModelAndView("excelView", "lstCustomer", customerList);
    }*/


}
