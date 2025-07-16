package tradenexus.com.example.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradenexus.com.example.Entity.Settlement;
import tradenexus.com.example.Repository.SettlementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SettlementService {

    @Autowired
    SettlementRepository settlementRepository;

    public Settlement saveSettlement(Settlement settlement) {
        return settlementRepository.save(settlement);
    }

    public List<Settlement> getAllSettlements() {
        return settlementRepository.findAll();
    }

    public Optional<Settlement> getSettlementById(Long id) {
        return settlementRepository.findById(id);
    }

    public void deleteSettlement(Long id) {
        settlementRepository.deleteById(id);
    }

}
