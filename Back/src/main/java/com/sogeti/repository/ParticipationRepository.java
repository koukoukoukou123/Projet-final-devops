package com.sogeti.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sogeti.model.Participations;

@Repository
@Transactional
public interface ParticipationRepository extends JpaRepository<Participations, Long>{
/**
 * Finding the participation based on the name of the championship associated to this participation
 * @param ChampionshipName
 * @return participation
 */
	Optional<List<Participations>> findBychampionshipName(String ChampionshipName );


}
