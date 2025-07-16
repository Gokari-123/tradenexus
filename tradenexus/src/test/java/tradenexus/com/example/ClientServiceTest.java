package tradenexus.com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tradenexus.com.example.Entity.Client;
import tradenexus.com.example.Repository.ClientRepository;
import tradenexus.com.example.Services.ClientService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClientServiceTest {

    @InjectMocks
  private  ClientService clientService;

    @Mock
  private  ClientRepository clientRepository;

    @BeforeEach
     void setup(){
        MockitoAnnotations .openMocks(this);
    }

    @Test
    void testSaveClient(){

        Client client=new Client(1L,"Wipro","wipro@gmail.com");
        when(clientRepository.save(client)).thenReturn(client);

        Client savedClient=clientService.saveClient(client);

        assertNotNull(savedClient);
        assertEquals("Wipro",savedClient.getClientName());
        verify(clientRepository,times(1)).save(client);

    }

    @Test
    void testGetAllClients(){
        Client client1=new Client(1L,"Wipro","wipro@gmail.com");
        Client client2=new Client(2L,"Genpact","genpact@gmail.com");

        List<Client> clients= Arrays.asList(client1,client2);

        when(clientRepository.findAll()).thenReturn(clients);

        List<Client> result=clientService.getAllClients();

        assertEquals(2,result.size());
        verify(clientRepository,times(1)).findAll();
    }

    @Test
    void testGetClientById_Found(){
        Client client=new Client(1L,"Wipro","wipro@gmail.com");
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        Optional<Client> result=clientService.getClientById(1L);

        assertTrue(result.isPresent());
        assertEquals("Wipro",result.get().getClientName());
        verify(clientRepository,times(1)).findById(1L);
    }

    @Test
    void testGetClientById_notFound(){
        when(clientRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Client> result=clientService.getClientById(99l);

        assertFalse(result.isPresent());
        verify(clientRepository,times(1)).findById(99L);
    }

    @Test
    void testDeleteClient(){
        doNothing().when(clientRepository).deleteById(1L);
        clientService.deleteClient(1L);

        verify(clientRepository,times(1)).deleteById(1L);
    }
}
