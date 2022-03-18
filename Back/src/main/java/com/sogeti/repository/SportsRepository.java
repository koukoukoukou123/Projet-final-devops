package com.sogeti.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sogeti.model.Sports;

@Repository
@Transactional
public interface SportsRepository extends JpaRepository<Sports, Long> {
/**
 * Find a sport, by using its id
 * @param sportId
 * @return sport
 */
	Optional<Sports> findBysportId(String sportId);

}
