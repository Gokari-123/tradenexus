package tradenexus.com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tradenexus.com.example.Entity.Client;

import java.util.Optional;

@Repository
public interface ClientRepository  extends JpaRepository<Client, Long> {
    Optional<Client> findByClientName(String clientName);
    Optional<Client> findByEmail(String email);
}
