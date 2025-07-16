package tradenexus.com.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate settlementDate;
    private String settlementStatus;

    public Settlement(Long id, LocalDate settlementDate, String settlementStatus) {
        this.id = id;
        this.settlementDate = settlementDate;
        this.settlementStatus = settlementStatus;
    }

    @OneToOne
    @JoinColumn(name = "trade_id")
    private Trade trade;
}
