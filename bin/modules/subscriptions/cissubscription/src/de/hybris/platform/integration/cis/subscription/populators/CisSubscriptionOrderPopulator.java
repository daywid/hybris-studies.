/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.integration.cis.subscription.populators;

import de.hybris.platform.commercefacades.order.data.AbstractOrderData;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Required;

import com.hybris.cis.api.subscription.model.CisSubscriptionItem;
import com.hybris.cis.api.subscription.model.CisSubscriptionOrder;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNullStandardMessage;


/**
 * Populate the CisSubscriptionOrder with the OrderData information
 */
public class CisSubscriptionOrderPopulator implements Populator<AbstractOrderData, CisSubscriptionOrder>
{
	private Converter<OrderEntryData, CisSubscriptionItem> cisSubscriptionItemConverter;

	@Override
	public void populate(final AbstractOrderData source, final CisSubscriptionOrder target) throws ConversionException
	{
		validateParameterNotNullStandardMessage("target", target);

		if (source == null)
		{
			return;
		}

		target.setId(source.getCode());

		if (source instanceof OrderData)
		{
			target.setDate(((OrderData) source).getCreated());
		}
		else
		{
			target.setDate(new Date());
		}
		target.setCurrency(source.getTotalPrice().getCurrencyIso());
		target.setMerchantAccountId(source.getMerchantCustomerId());
		target.setItems(populateSubscriptionItems(source));
	}

	protected List<CisSubscriptionItem> populateSubscriptionItems(final AbstractOrderData source)
	{
		final List<CisSubscriptionItem> cisSubscriptionItems = new ArrayList<CisSubscriptionItem>();

		for (final OrderEntryData orderEntry : source.getEntries())
		{
			// ignore non-subscription products or upgraded subscriptions
			if (orderEntry.getProduct().getSubscriptionTerm() == null
					|| StringUtils.isNotEmpty(orderEntry.getOriginalSubscriptionId()))
			{
				continue;
			}

			cisSubscriptionItems.add(getCisSubscriptionItemConverter().convert(orderEntry));
		}

		return cisSubscriptionItems;
	}

	protected Converter<OrderEntryData, CisSubscriptionItem> getCisSubscriptionItemConverter()
	{
		return cisSubscriptionItemConverter;
	}

	@Required
	public void setCisSubscriptionItemConverter(final Converter<OrderEntryData, CisSubscriptionItem> cisSubscriptionItemConverter)
	{
		this.cisSubscriptionItemConverter = cisSubscriptionItemConverter;
	}

}
