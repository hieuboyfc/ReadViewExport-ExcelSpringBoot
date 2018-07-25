package hieuboy.excel.controller.rest;

import hieuboy.excel.model.Customer;
import hieuboy.excel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiExcelController {

    @Autowired
    private CustomerService customerService;

    /**
     * Handle request to the default page
     */
    @GetMapping("/")
    public List<Customer> viewHome() {

        return customerService.getCustomerList();
    }

}
