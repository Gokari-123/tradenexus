package tradenexus.com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tradenexus.com.example.Entity.Trade;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByStatus(String status);
    List<Trade> findByClient_Id(Long clientId);
    List<Trade> findByBank_Id(Long bankId);
}
