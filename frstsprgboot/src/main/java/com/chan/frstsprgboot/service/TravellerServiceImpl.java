package com.chan.frstsprgboot.service;

import org.springframework.stereotype.Service;

import com.chan.frstprgboot.entity.ForeignTour;
import com.chan.frstprgboot.entity.LocalTour;
import com.chan.frstprgboot.entity.Traveller;

@Service
public class TravellerServiceImpl implements TravellerService {

	@Override
	public Traveller addTraveller(Traveller traveller) {
		
		return null;
	}
	
	@Override
	public LocalTour saveLocalTourRequest(LocalTour localTour) {

		Traveller traveller = localTour.getTrtourist();
		localTour.setTrtourist(traveller);
		return localTourRepository.save(localTour);
	}

	@Override
	public ForeignTour saveForeignTourRequest(ForeignTour foreignTour) {
		System.out.println("-----------foreign Tour -------" +foreignTour);
		Traveller traveller = foreignTour.getTrtourist();
		foreignTour.setTrtourist(traveller);
		return foreignTourRepository.save(foreignTour);
	}


}
