package com.sogeti.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sogeti.model.Correspondances;

@Repository
@Transactional
public interface CorrespondancesRepository extends JpaRepository<Correspondances, Long> {
	/**
	 * Finding a correspondance based on the id of the sport related to this
	 * correspondance
	 * 
	 * @param sportId
	 * @return
	 */
	Optional<Correspondances> findBysportId(String sportId);

	/**
	 * Finding a correspondance based on the name of the championship related to
	 * this correspondance
	 * 
	 * @param championshipName
	 * @return
	 */
	Optional<Correspondances> findBychampionshipName(String championshipName);

}
