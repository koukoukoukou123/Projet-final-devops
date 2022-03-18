package com.sogeti.repository;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sogeti.model.Teams;


@Repository
@Transactional
public interface TeamRepository extends JpaRepository<Teams, Long>{

/**
 * Find a team, by using its teamName
 * @param teamName
 * @return team
 */
	Optional<Teams> findByteamName(String teamName);


}
