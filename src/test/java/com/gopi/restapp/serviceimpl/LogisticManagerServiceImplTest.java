package com.gopi.restapp.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gopi.restapp.model.LogisticManager;
import com.gopi.restapp.repository.LogisticManagerRepository;

class LogisticManagerServiceImplTest {
	
	 @Mock
	    private LogisticManagerRepository logisticManagerRepository;

	    @InjectMocks
	    private LogisticManagerServiceImpl logisticManagerService;

	    private LogisticManager logisticManager;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	        logisticManager = new LogisticManager();
	        logisticManager.setLogisticManagerId(1);
	        logisticManager.setUserName("logistic_user");
	    }

	    @Test
	    void testSaveLogisticManager() {
	        when(logisticManagerRepository.save(logisticManager)).thenReturn(logisticManager);

	        LogisticManager savedManager = logisticManagerService.saveLogisticManager(logisticManager);

	        assertNotNull(savedManager);
	        assertEquals(1, savedManager.getLogisticManagerId());
	        verify(logisticManagerRepository, times(1)).save(logisticManager);
	    }

	    @Test
	    void testGetLogisticManagerById() {
	        when(logisticManagerRepository.findById(1)).thenReturn(logisticManager);

	        LogisticManager foundManager = logisticManagerService.getLogisticManagerById(1);

	        assertNotNull(foundManager);
	        assertEquals(1, foundManager.getLogisticManagerId());
	        verify(logisticManagerRepository, times(1)).findById(1);
	    }

	    @Test
	    void testGetAllLogisticManagers() {
	        when(logisticManagerRepository.findAll()).thenReturn(Arrays.asList(logisticManager));

	        List<LogisticManager> managers = logisticManagerService.getAllLogisticManagers();

	        assertNotNull(managers);
	        assertEquals(1, managers.size());
	        verify(logisticManagerRepository, times(1)).findAll();
	    }

	    @Test
	    void testDeleteLogisticManagerById() {
	        doNothing().when(logisticManagerRepository).delete(1);

	        logisticManagerService.deleteLogisticManagerById(1);

	        verify(logisticManagerRepository, times(1)).delete(1);
	    }

	    @Test
	    void testUpdateLogisticManager() {
	        when(logisticManagerRepository.findById(1)).thenReturn(logisticManager);
	        when(logisticManagerRepository.update(logisticManager)).thenReturn(logisticManager);

	        LogisticManager updatedManager = logisticManagerService.updateLogisticManager(1, logisticManager);

	        assertNotNull(updatedManager);
	        assertEquals(1, updatedManager.getLogisticManagerId());
	        verify(logisticManagerRepository, times(1)).findById(1);
	        verify(logisticManagerRepository, times(1)).update(logisticManager);
	    }

	    @Test
	    void testUpdateLogisticManager_NotFound() {
	        when(logisticManagerRepository.findById(anyInt())).thenReturn(null);

	        LogisticManager updatedManager = logisticManagerService.updateLogisticManager(1, logisticManager);

	        assertNull(updatedManager);
	        verify(logisticManagerRepository, times(1)).findById(1);
	        verify(logisticManagerRepository, never()).update(any());
	    }

	    @Test
	    void testGetLogisticManagerByUserName() {
	        when(logisticManagerRepository.findByUserName("logistic_user")).thenReturn(logisticManager);

	        LogisticManager foundManager = logisticManagerService.getLogisticManagerByUserName("logistic_user");

	        assertNotNull(foundManager);
	        assertEquals("logistic_user", foundManager.getUserName());
	        verify(logisticManagerRepository, times(1)).findByUserName("logistic_user");
	    }	

}
