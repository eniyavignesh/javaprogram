package com.chan.frstsprgboot.service;

import com.chan.frstprgboot.entity.ForeignTour;
import com.chan.frstprgboot.entity.LocalTour;
import com.chan.frstprgboot.entity.Traveller;

public interface TravellerService {
	public Traveller addTraveller(Traveller traveller);
	public LocalTour saveLocalTourRequest(LocalTour localTour);
	public ForeignTour saveForeignTourRequest(ForeignTour foreignTour);

}
