package tradenexus.com.example.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Client(Long id, String clientName, String email) {
        this.id = id;
        this.clientName = clientName;
        this.email = email;
    }

    private String clientName;
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Trade> trades;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getClientName() {
//        return clientName;
//    }
//
//    public void setClientName(String clientName) {
//        this.clientName = clientName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public List<Trade> getTrades() {
//        return trades;
//    }
//
//    public void setTrades(List<Trade> trades) {
//        this.trades = trades;
//    }
}
