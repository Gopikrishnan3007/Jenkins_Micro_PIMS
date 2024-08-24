package com.gopi.restapp.repository;

import java.util.List;

import com.gopi.restapp.model.Track;

public interface TrackRepository {

	public Track findById(int id);

	public List<Track> findAll();

	public Track save(Track track);

	public Track update(Track track);

	public void delete(int id);
}
