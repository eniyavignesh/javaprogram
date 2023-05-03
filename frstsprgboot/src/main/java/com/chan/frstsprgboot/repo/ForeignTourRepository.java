package com.chan.frstsprgboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chan.frstprgboot.entity.ForeignTour;

@Repository
public interface ForeignTourRepository extends JpaRepository<ForeignTour, Long>{

}