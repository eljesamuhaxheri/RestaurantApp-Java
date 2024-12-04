package org.makermainds.jcoaching.resturantapp.controller;

import org.makermainds.jcoaching.resturantapp.model.enums.Location;

public class LocationManager {
	
	public static Location getLocationFromId(int locationId) {
		/*for (Location location : Location.values()) {
			if(location.name().equals(locationAsString)) {
				
				return location;
			}
		}*/
		
		switch (locationId) {
		case 1: {
			return Location.KOSOVO;
		}
		case 2: {
			return Location.GERMANY;
		}
		default:
		}
		throw new IllegalArgumentException("Invalid location");
	}

}
