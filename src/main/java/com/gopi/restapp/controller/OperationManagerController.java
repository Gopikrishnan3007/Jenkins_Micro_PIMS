package com.gopi.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopi.restapp.model.Track;
import com.gopi.restapp.service.TrackService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/operationmanager")
public class OperationManagerController {
	@Autowired
	private TrackService trackService;
 
    @GetMapping("/track/all")
    public List<Track> getAllTracks() {
        return trackService.getAllTracks();
    }
 
    @GetMapping("/track/{id}")
    public Track getTrackById(@PathVariable int id) {
        return trackService.getTrackById(id);
    }
 
    @PostMapping("/track")
    public Track createTrack(@RequestBody Track Track) {
        trackService.saveTrack(Track);
        return Track;
    }
 
    @PutMapping("/track/{id}")
    public Track updateTrack(@PathVariable int id, @RequestBody Track Track) {
        Track.setTrackId(id);
        trackService.updateTrack(id, Track);
        return Track;
    }
 
    @DeleteMapping("/track/{id}")
    public void deleteTrack(@PathVariable int id) {
        trackService.deleteTrackById(id);
    }
}
