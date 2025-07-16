package tradenexus.com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tradenexus.com.example.Entity.Bank;

import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Optional<Bank> findBySwiftCode(String swiftCode);
    Optional<Bank> findByBankName(String bankName);
}
