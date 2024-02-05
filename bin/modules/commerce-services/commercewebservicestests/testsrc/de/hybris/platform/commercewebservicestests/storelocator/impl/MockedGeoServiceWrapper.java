/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicestests.storelocator.impl;

import de.hybris.platform.storelocator.GPS;
import de.hybris.platform.storelocator.data.AddressData;
import de.hybris.platform.storelocator.exception.GeoServiceWrapperException;
import de.hybris.platform.storelocator.impl.CommerceMockGeoWebServiceWrapper;
import de.hybris.platform.storelocator.location.Location;

import java.util.Map;

import org.apache.commons.lang.StringUtils;


/**
 * Mock wrapper to avoid communication with google geo-location services.
 */
public class MockedGeoServiceWrapper extends CommerceMockGeoWebServiceWrapper
{
	private final Map<String, GPS> geoMap;

	public MockedGeoServiceWrapper(final Map<String, GPS> geoMap)
	{
		super();
		this.geoMap = geoMap;
	}

	@Override
	public GPS geocodeAddress(final Location address) throws GeoServiceWrapperException
	{
		final GPS gpsAddress = geoMap.get(StringUtils.lowerCase(address.getAddressData().getCity()));

		if (gpsAddress == null)
		{
			throw new GeoServiceWrapperException();
		}

		return gpsAddress;
	}

	@Override
	public GPS geocodeAddress(final AddressData address) throws GeoServiceWrapperException
	{
		final GPS gpsAddress = geoMap.get(StringUtils.lowerCase(address.getCity()));

		if (gpsAddress == null)
		{
			throw new GeoServiceWrapperException();
		}

		return gpsAddress;
	}

}
