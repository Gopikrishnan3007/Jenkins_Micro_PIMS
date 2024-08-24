package com.gopi.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopi.restapp.model.Track;
import com.gopi.restapp.repository.TrackRepository;
import com.gopi.restapp.service.TrackService;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackRepository trackRepository;
 
    @Override
    public Track saveTrack(Track Track) {
        return trackRepository.save(Track);
    }
 
    @Override
    public Track getTrackById(int TrackId) {
        return trackRepository.findById(TrackId);
    }
 
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
 
    @Override
    public void deleteTrackById(int TrackId) {
    	trackRepository.delete(TrackId);
    }
 
    @Override
    public Track updateTrack(int trackId, Track track) {
        if (trackRepository.findById(trackId) != null) {
            track.setTrackId(trackId);
            return trackRepository.update(track);
        }
        return null;
    }

}
