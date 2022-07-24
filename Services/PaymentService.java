package com.example.demo.Services;


import com.example.demo.Entitys.Bill;
import com.example.demo.Entitys.Payment;
import com.example.demo.Repositorys.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final BillService billService;

    private final UserService userService;

    public PaymentService(PaymentRepository paymentRepository, BillService billService, UserService userService) {       //fatura
        this.paymentRepository = paymentRepository;
        this.billService = billService;
        this.userService = userService;
    }

    public Payment makePayment(Long userId) {
        List<Bill> billList = billService.findAllFalse(userId);
        double totalAmount = billList.stream().mapToDouble(bill -> bill.getBillAmount()).sum();
        Payment payment = new Payment();
        payment.setTotalAmount(totalAmount);
        if (userService.findUser(userId).isPresent())
        {
            payment.setUser(userService.findUser(userId).get());
        }else
        {
             return null;
        }
        billService.isPaid(userId);
        return paymentRepository.save(payment);
    }

}