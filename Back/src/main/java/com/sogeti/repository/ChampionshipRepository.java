package com.sogeti.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sogeti.model.Championships;


@Repository
@Transactional
public interface ChampionshipRepository extends JpaRepository<Championships, Long>{


}
