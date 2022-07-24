package com.example.demo.Controller;

import com.example.demo.Entitys.Payment;
import com.example.demo.Services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("pay")
    public Payment makeAllPayment(@RequestParam("userId") Long userId){
        return paymentService.makePayment(userId);
    }



}
