package tradenexus.com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tradenexus.com.example.Entity.Settlement;
import tradenexus.com.example.Repository.SettlementRepository;
import tradenexus.com.example.Services.SettlementService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class SettlementServiceTest {

    @InjectMocks
    private SettlementService settlementService;
    @Mock
    private SettlementRepository settlementRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveSettlement(){

        Settlement settlement=new Settlement(1L, LocalDate.of(2025, 07, 02),"Completed");
        when(settlementRepository.save(settlement)).thenReturn(settlement);

        Settlement savesettlement=settlementService.saveSettlement(settlement);

        assertNotNull(savesettlement);
        assertEquals("Completed",savesettlement.getSettlementStatus());
        verify(settlementRepository,times(1)).save(settlement);
    }

    @Test
    void testGetAllSettlements(){
        Settlement settlement1=new Settlement(1L,LocalDate.of(2025,07,02),"Completed");
        Settlement settlement2=new Settlement(2L,LocalDate.of(2025,07,03),"Pending");

        List<Settlement> settlements= Arrays.asList(settlement1,settlement2);

        when(settlementRepository.findAll()).thenReturn(settlements);

        List<Settlement> result=settlementService.getAllSettlements();

        assertEquals(2,result.size());
        verify(settlementRepository,times(1)).findAll();


    }

}
