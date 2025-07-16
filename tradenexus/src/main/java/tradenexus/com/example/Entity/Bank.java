package tradenexus.com.example.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;
    private String swiftCode;

    @OneToMany(mappedBy = "bank")
    private List<Trade> trades;

    public Bank(Long id, String bankName, String swiftCode) {
        this.id = id;
        this.bankName = bankName;
        this.swiftCode = swiftCode;
    }
}
