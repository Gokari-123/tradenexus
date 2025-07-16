package tradenexus.com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tradenexus.com.example.Entity.Bank;
import tradenexus.com.example.Repository.BankRepository;
import tradenexus.com.example.Services.BankService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BankServiceTest {

    @InjectMocks
    private BankService bankService;

    @Mock
    private BankRepository bankRepository;

    @BeforeEach
     void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveBank(){
        Bank bank=new Bank(1L,"HDFC","Mumbai");
        when(bankRepository.save(bank)).thenReturn(bank);

        Bank savedBank=bankService.saveBank(bank);

        assertNotNull(savedBank);
        assertEquals("HDFC",savedBank.getBankName());
        verify(bankRepository,times(1)).save(bank);
    }

    @Test
    void testGetAllBanks(){
        Bank bank1=new Bank(1L,"HDFC","Mumbai");
        Bank bank2=new Bank(2L,"HDFC","Hyderabad");
        Bank bank3=new Bank(3L,"ICICI","Delhi");
        List<Bank> banks= Arrays.asList(bank1,bank2,bank3);

        when(bankRepository.findAll()).thenReturn(banks);

        List<Bank> result=bankService.getAllBanks();

        assertEquals(3,result.size());
        verify(bankRepository,times(1)).findAll();
    }


    @Test
    void testGetBankById_Found(){
        Bank bank=new Bank(1L,"HDFC","Mumbai");
        when(bankRepository.findById(1L)).thenReturn(Optional.of(bank));

        Optional<Bank> result=bankService.getBankById(1L);

        assertTrue(result.isPresent());
        assertEquals("HDFC",result.get().getBankName());
        verify(bankRepository,times(1)).findById(1L);
    }

    @Test
    void testGetBankById_NotFound(){
        when(bankRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Bank> result=bankService.getBankById(99l);

        assertFalse(result.isPresent());
        verify(bankRepository,times(1)).findById(99l);

    }

    @Test
    void testDeleteBank(){

        doNothing().when(bankRepository).deleteById(1L);

        bankService.deleteBank(1L);

        verify(bankRepository,times(1)).deleteById(1L);

    }

}
