package org.makermainds.jcoaching.resturantapp.controller.copy;

import org.makermainds.jcoaching.resturantapp.model.enums.Location;

public class LocationManager {
	
	public static Location getLocationFromString(String locationAsString) {
		for (Location location : Location.values()) {
			if(location.name().equals(locationAsString)) {
				
				return location;
			}
		}
		throw new IllegalArgumentException("Invalid location");
	}

}
