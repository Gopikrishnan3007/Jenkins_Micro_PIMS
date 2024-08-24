package com.gopi.restapp.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gopi.restapp.model.Ship;
import com.gopi.restapp.repository.ShipRepository;

class ShipServiceImplTest {

	   @Mock
	    private ShipRepository shipRepository;

	    @InjectMocks
	    private ShipServiceImpl shipService;

	    private Ship ship1;
	    private Ship ship2;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	        ship1 = new Ship(1L, "Titanic", 123456789L, "987654321", "Cargo", "New York", "2024-08-15T12:00:00", "Request 1", "Berth 1", "Service Type 1", null, null);
	        ship2 = new Ship(2L, "Queen Mary", 987654321L, "123456789", "Passenger", "Southampton", "2024-08-16T14:00:00", "Request 2", "Berth 2", "Service Type 2", null, null);
	    }

	    @Test
	    void testSaveShip() {
	        when(shipRepository.save(ship1)).thenReturn(ship1);

	        Ship savedShip = shipService.saveShip(ship1);

	        assertNotNull(savedShip);
	        assertEquals(ship1.getShipName(), savedShip.getShipName());
	        verify(shipRepository, times(1)).save(ship1);
	    }




	    @Test
	    void testGetAllShips() {
	        when(shipRepository.findAll()).thenReturn(Arrays.asList(ship1, ship2));

	        List<Ship> ships = shipService.getAllShips();

	        assertEquals(2, ships.size());
	        verify(shipRepository, times(1)).findAll();
	    }

	    @Test
	    void testDeleteShipById() {
	        doNothing().when(shipRepository).delete(1L);

	        shipService.deleteShipById(1L);

	        verify(shipRepository, times(1)).delete(1L);
	    }

	   
	    @Test
	    void testGetAllShipsIds() {
	        when(shipRepository.findAllIds()).thenReturn(Arrays.asList(1L, 2L));

	        List<Long> shipIds = shipService.getAllShipsIds();

	        assertEquals(2, shipIds.size());
	        verify(shipRepository, times(1)).findAllIds();
	    }

	    @Test
	    void testGetShipsByVesselOperatorId() {
	        when(shipRepository.findByVesselOperator_VesselOperatorId(1)).thenReturn(Arrays.asList(ship1));

	        List<Ship> ships = shipService.getShipsByVesselOperatorId(1);

	        assertEquals(1, ships.size());
	        verify(shipRepository, times(1)).findByVesselOperator_VesselOperatorId(1);
	    }

	    @Test
	    void testGetAllShipsNames() {
	        when(shipRepository.findAllNames()).thenReturn(Arrays.asList("Titanic", "Queen Mary"));

	        List<String> shipNames = shipService.getAllShipsNames();

	        assertEquals(2, shipNames.size());
	        verify(shipRepository, times(1)).findAllNames();
	    }
}
