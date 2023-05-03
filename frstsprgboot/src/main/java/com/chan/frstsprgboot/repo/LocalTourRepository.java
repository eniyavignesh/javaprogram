package com.chan.frstsprgboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chan.frstprgboot.entity.LocalTour;


@Repository
public interface LocalTourRepository extends JpaRepository<LocalTour, Long>{

}