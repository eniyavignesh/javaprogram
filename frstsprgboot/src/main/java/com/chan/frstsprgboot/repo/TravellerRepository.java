package com.chan.frstsprgboot.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chan.frstprgboot.entity.Traveller;


@Repository
public interface TravellerRepository extends CrudRepository<Traveller,Long>{
	
}
