package tradenexus.com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tradenexus.com.example.Entity.Bank;
import tradenexus.com.example.Services.BankService;

import java.util.List;

@RestController
@RequestMapping ("/api/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping
    public ResponseEntity<Bank> createBank(@RequestBody Bank bank) {
        return new ResponseEntity<>(bankService.saveBank(bank), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable Long id) {
        return bankService.getBankById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable Long id) {
        bankService.deleteBank(id);
        return ResponseEntity.noContent().build();
    }
}
