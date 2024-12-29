package com.otbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otbs.exception.InvalidEntityException;
import com.otbs.model.Bill;
import com.otbs.service.BillServiceImpl;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    BillServiceImpl billService=new BillServiceImpl();


    @GetMapping("/customer/{customerId}")
    public List<Bill> getAllBillsByCustomerId(@PathVariable int customerId) throws InvalidEntityException {
        
        List<Bill> bills= billService.getAllBillsByCustomerId(customerId);
        if (bills.isEmpty()) {
            throw new InvalidEntityException("customer has no bill");
        }
        else return bills;
    }

    @GetMapping("/customer/{customerId}/unpaid")
    public List<Bill> getUnpaidBillsByCustomerId(@PathVariable int customerId) throws InvalidEntityException {
        List<Bill> bills = billService.getUnpaidBillsByCustomerId(customerId);
        if (bills.isEmpty()) {
            throw new InvalidEntityException("customer has No Bending bill");
        }
        else return bills;
    }

    @GetMapping("/customer/{customerId}/lastSixMonth")
    public List<Bill> getSixMonthBillsByCustomerId(@PathVariable int customerId) throws InvalidEntityException {
        List<Bill> bills = billService.getBillsForLastSixMonth(customerId);
        if (bills.isEmpty()) {
            throw new InvalidEntityException("customer has No Bending bill");
        }
        else return bills; 
    }
    
    @GetMapping("/customer/{billId}/bill")
    public Bill getbill(@PathVariable int billId) throws  InvalidEntityException{
    	return billService.getBill(billId);
    }

    @GetMapping("/customer/{billId}/pay")
    public String payBill(@PathVariable int billId) throws  InvalidEntityException{
        Boolean paid = billService.payBill(billId);
        if(!paid) throw new InvalidEntityException("Bill Not Paid");
        else return "Bill paid Successflly";
    }

    //Admine purpose 
    
    @GetMapping("/customer/unpaidbills")
    public List<Bill> getAllUnpaidBills() throws InvalidEntityException{
    	List<Bill> bills= billService.allunpaidbill();
    	if(bills.isEmpty()) throw new InvalidEntityException("No Unpaid Bills Found");
    	else return bills;
    }
    
    @GetMapping("/customer/billcrossduedate")
    public List<Bill> getAllUnpaidBillCrossDue() throws InvalidEntityException{
    	List<Bill> bills= billService.billCrossDueDate();
    	if(bills.isEmpty()) throw new InvalidEntityException("No Unpaid Bills Crosses The DueDate");
    	else return bills;
    }
    
    
    

}



