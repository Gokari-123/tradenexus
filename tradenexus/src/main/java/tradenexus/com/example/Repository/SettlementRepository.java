package tradenexus.com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tradenexus.com.example.Entity.Settlement;

import java.util.List;
import java.util.Optional;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Long> {
    List<Settlement> findBySettlementStatus(String settlementStatus);
    Optional<Settlement> findByTrade_Id(Long tradeId);

}
