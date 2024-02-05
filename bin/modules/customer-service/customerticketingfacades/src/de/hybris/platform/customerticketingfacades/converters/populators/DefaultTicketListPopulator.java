/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.customerticketingfacades.converters.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.customerticketingfacades.data.StatusData;
import de.hybris.platform.customerticketingfacades.data.TicketCategory;
import de.hybris.platform.customerticketingfacades.data.TicketData;
import de.hybris.platform.ticket.enums.CsTicketState;
import de.hybris.platform.ticket.model.CsTicketModel;

import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;


/**
 * Converter implementation for {@link de.hybris.platform.ticket.model.CsTicketModel} as source and
 * {@link de.hybris.platform.customerticketingfacades.data.TicketData} as target type.
 */
public class DefaultTicketListPopulator<SOURCE extends CsTicketModel, TARGET extends TicketData>
		implements Populator<SOURCE, TARGET>
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultTicketListPopulator.class);
	private Map<String, StatusData> statusMapping;

	@Override
	public void populate(final CsTicketModel source, final TicketData target)
	{
		target.setId(source.getTicketID());
		target.setSubject(source.getHeadline());
		target.setCreationDate(source.getCreationtime());
		target.setLastModificationDate(source.getModifiedtime());
		if (null != source.getCategory())
		{
			final String categoryCode = source.getCategory().getCode().toUpperCase(Locale.ENGLISH);
			try
			{
				target.setTicketCategory(TicketCategory.valueOf(categoryCode));
			}
			catch (final IllegalArgumentException ex)
			{
				LOG.info("{} ticket category is not enabled to display for the customer ticketing", categoryCode);
			}
		}

		final CsTicketState csTicketState = source.getState();
		target.setStatus(getStatusMapping().get(csTicketState.getCode()));
	}


	/**
	 * @return the statusMapping
	 */
	public Map<String, StatusData> getStatusMapping()
	{
		return statusMapping;
	}

	/**
	 * @param statusMapping
	 *           the statusMapping to set
	 */
	@Required
	public void setStatusMapping(final Map<String, StatusData> statusMapping)
	{
		this.statusMapping = statusMapping;
	}
}
