package tradenexus.com.example.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradenexus.com.example.Entity.Bank;
import tradenexus.com.example.Repository.BankRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    public Bank saveBank(Bank bank) {
        return bankRepository.save(bank);
    }

    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    public Optional<Bank> getBankById(Long id) {
        return bankRepository.findById(id);
    }

    public void deleteBank(Long id) {
        bankRepository.deleteById(id);
    }
}
