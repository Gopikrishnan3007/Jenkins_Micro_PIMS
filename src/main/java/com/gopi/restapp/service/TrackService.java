package com.gopi.restapp.service;

import java.util.List;

import com.gopi.restapp.model.Track;


public interface TrackService {

	Track saveTrack(Track track);

	Track getTrackById(int trackId);

	List<Track> getAllTracks();

	void deleteTrackById(int trackId);

	Track updateTrack(int trackId, Track track);

}
