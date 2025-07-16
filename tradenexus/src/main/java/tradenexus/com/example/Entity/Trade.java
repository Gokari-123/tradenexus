package tradenexus.com.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tradeId;
    private String currencyPair;
    private Double amount;
    private String status;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Bank bank;

    private LocalDate settlementDate;

}
