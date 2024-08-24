package com.gopi.restapp.repositoryimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopi.restapp.model.Track;
import com.gopi.restapp.repository.TrackRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TrackRepositoryImpl implements TrackRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Track findById(int id) {
		return entityManager.find(Track.class, id);
	}

	public List<Track> findAll() {
		return entityManager.createQuery("SELECT s FROM Track s", Track.class).getResultList();
	}

	public Track save(Track track) {
		entityManager.persist(track);
		return track;
	}

	public Track update(Track track) {
		return entityManager.merge(track);
	}

	public void delete(int id) {
		Track track = findById(id);
		if (track != null) {
			entityManager.remove(track);
		}
	}

}
