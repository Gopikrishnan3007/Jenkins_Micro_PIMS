package com.gopi.restapp.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gopi.restapp.model.VesselOperator;
import com.gopi.restapp.repository.VesselOperatorRepository;

class VesselOperatorServiceImplTest {

    @InjectMocks
    private VesselOperatorServiceImpl vesselOperatorService;

    @Mock
    private VesselOperatorRepository vesselOperatorRepository;

    private VesselOperator vesselOperator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        vesselOperator = new VesselOperator(1, "John Doe", "jdoe", "password123", "jdoe@example.com", "vesselOperator");
    }

    @Test
    void testSaveVesselOperator() {
        when(vesselOperatorRepository.save(any(VesselOperator.class))).thenReturn(vesselOperator);

        VesselOperator savedVesselOperator = vesselOperatorService.saveVesselOperator(vesselOperator);

        assertNotNull(savedVesselOperator);
        assertEquals(vesselOperator.getVesselOperatorId(), savedVesselOperator.getVesselOperatorId());
        verify(vesselOperatorRepository, times(1)).save(any(VesselOperator.class));
    }



    @Test
    void testGetAllVesselOperators() {
        List<VesselOperator> vesselOperators = Arrays.asList(vesselOperator);
        when(vesselOperatorRepository.findAll()).thenReturn(vesselOperators);

        List<VesselOperator> foundVesselOperators = vesselOperatorService.getAllVesselOperators();

        assertNotNull(foundVesselOperators);
        assertEquals(1, foundVesselOperators.size());
        verify(vesselOperatorRepository, times(1)).findAll();
    }

    @Test
    void testDeleteVesselOperatorById() {
        doNothing().when(vesselOperatorRepository).delete(anyInt());

        vesselOperatorService.deleteVesselOperatorById(1);

        verify(vesselOperatorRepository, times(1)).delete(anyInt());
    }



    @Test
    void testGetVesselOperatorByUserName() {
        when(vesselOperatorRepository.findByUserName(anyString())).thenReturn(vesselOperator);

        VesselOperator foundVesselOperator = vesselOperatorService.getVesselOperatorByUserName("jdoe");

        assertNotNull(foundVesselOperator);
        assertEquals(vesselOperator.getUserName(), foundVesselOperator.getUserName());
        verify(vesselOperatorRepository, times(1)).findByUserName(anyString());
    }

}
