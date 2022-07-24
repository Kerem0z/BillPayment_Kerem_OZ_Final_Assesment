package com.example.demo.Services;

import com.example.demo.Entitys.Bill;
import com.example.demo.Entitys.TotalAmount;
import com.example.demo.Entitys.User;
import com.example.demo.Repositorys.BillRepository;
import com.example.demo.Repositorys.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    private final BillRepository billRepository;
    private final UserRepository userRepository;


    public BillService(BillRepository billRepository, UserRepository userRepository) {
        this.billRepository = billRepository;
        this.userRepository = userRepository;
    }       //repo ile service bağlantısı

    public Bill addBill(Bill bill){//fatura ekleme methodu
        Bill record = new Bill();
        record.setBillAmount(bill.getBillAmount());
        record.setPayment(bill.getPayment());
        if (userRepository.findById(bill.getUser().getUserId()).isPresent())
        {
            record.setUser(userRepository.getById(bill.getUser().getUserId()));
        }
        billRepository.save(record);
        return record;
    }

    public Optional<Bill> findBill(Long billId){        // ıd 'ye göre fatura bulma metodu

        return billRepository.findById(billId);
    }
    public List<Bill> getAllBill(){             //tüm faturaları listeleme metodu

        return billRepository.findAll();
    }

    public List<TotalAmount> getTotalAmount(List<Bill> billdtos){       //toplam fatura bedeli gösterme metodu.
        List<TotalAmount> totalAmountList =new ArrayList<>();

        billdtos.forEach(bill -> {
            double result = 0;
            Bill bills = billRepository.getReferenceById(bill.getBillId());
            result = result +(bills.getBillAmount());
            totalAmountList.add(new TotalAmount(bill.getBillId(),bill.getBillAmount(),result));
        });
        return totalAmountList;
    }

    public void deleteBill(Long billId){
        billRepository.deleteById(billId);
    }

    public List<Bill> findAllFalse( Long userId) {
        return billRepository.findAllFalseByUserId( userId);
    }

    public void isPaid(Long userId)
    {
        List<Bill> bills = findAllFalse(userId);
        if (bills.isEmpty())
        {
            throw new RuntimeException("ödenmemiş fatura yok");
        }
        else {
            bills.forEach(bill -> {
                bill.setPayment(true);
                billRepository.save(bill);
            });
        }
    }

}

