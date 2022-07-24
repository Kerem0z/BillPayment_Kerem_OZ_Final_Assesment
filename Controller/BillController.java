package com.example.demo.Controller;


import com.example.demo.Entitys.Bill;
import com.example.demo.Entitys.TotalAmount;
import com.example.demo.Services.BillService;
import com.example.demo.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("bill")
public class BillController {
    private final BillService billService;
    private final UserService userService;

    public BillController(BillService billService, UserService userService) {
        this.billService = billService;
        this.userService = userService;
    }

    @PostMapping("add")
    public Bill addBill(@RequestBody Bill bill) {
        return billService.addBill(bill);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Bill>> getAllBills() {
        return ResponseEntity.ok(billService.getAllBill());
    }

    @DeleteMapping("/delete/{billId}")
    public ResponseEntity deleteBill(@PathVariable Long billId){
        billService.deleteBill(billId);
        return ResponseEntity.ok("Silindi : " + billId);
    }

    @GetMapping("getAllFalse")
    public ResponseEntity<List<Bill>> getAllBillsPaymentFalse(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(billService.findAllFalse(userId));
    }

}




