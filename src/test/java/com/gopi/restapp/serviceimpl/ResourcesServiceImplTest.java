package com.gopi.restapp.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gopi.restapp.model.Resources;
import com.gopi.restapp.repository.ResourcesRepository;
import static org.mockito.Mockito.*;

class ResourcesServiceImplTest {

	 @Mock
	    private ResourcesRepository resourcesRepository;

	    @InjectMocks
	    private ResourcesServiceImpl resourcesService;

	    private Resources resources;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	        resources = new Resources();
	        resources.setResourcesId(1);
	    }

	    @Test
	    void testSaveResources() {
	        when(resourcesRepository.save(resources)).thenReturn(resources);

	        Resources savedResources = resourcesService.saveResources(resources);

	        assertNotNull(savedResources);
	        assertEquals(1, savedResources.getResourcesId());
	        verify(resourcesRepository, times(1)).save(resources);
	    }

	    @Test
	    void testGetResourcesById() {
	        when(resourcesRepository.findById(1)).thenReturn(resources);

	        Resources foundResources = resourcesService.getResourcesById(1);

	        assertNotNull(foundResources);
	        assertEquals(1, foundResources.getResourcesId());
	        verify(resourcesRepository, times(1)).findById(1);
	    }

	    @Test
	    void testGetAllResourcess() {
	        when(resourcesRepository.findAll()).thenReturn(Arrays.asList(resources));

	        List<Resources> resourcesList = resourcesService.getAllResourcess();

	        assertNotNull(resourcesList);
	        assertEquals(1, resourcesList.size());
	        verify(resourcesRepository, times(1)).findAll();
	    }
	    
	    @Test
	    void testGetAllResourcesIds() {
	        List<Long> expectedIds = Arrays.asList(1L, 2L, 3L);
	        when(resourcesRepository.findAllIds()).thenReturn(expectedIds);

	        List<Long> resourceIds = resourcesService.getAllResourcesIds();

	        assertNotNull(resourceIds);
	        assertEquals(3, resourceIds.size());
	        assertEquals(expectedIds, resourceIds);
	        verify(resourcesRepository, times(1)).findAllIds();
	    }

	    @Test
	    void testDeleteResourcesById() {
	        doNothing().when(resourcesRepository).delete(1);

	        resourcesService.deleteResourcesById(1);

	        verify(resourcesRepository, times(1)).delete(1);
	    }

	    @Test
	    void testUpdateResources() {
	        when(resourcesRepository.findById(1)).thenReturn(resources);
	        when(resourcesRepository.update(resources)).thenReturn(resources);

	        Resources updatedResources = resourcesService.updateResources(1, resources);

	        assertNotNull(updatedResources);
	        assertEquals(1, updatedResources.getResourcesId());
	        verify(resourcesRepository, times(1)).findById(1);
	        verify(resourcesRepository, times(1)).update(resources);
	    }

	    @Test
	    void testUpdateResources_NotFound() {
	        when(resourcesRepository.findById(anyInt())).thenReturn(null);

	        Resources updatedResources = resourcesService.updateResources(1, resources);

	        assertNull(updatedResources);
	        verify(resourcesRepository, times(1)).findById(1);
	        verify(resourcesRepository, never()).update(any());
	    }

}
