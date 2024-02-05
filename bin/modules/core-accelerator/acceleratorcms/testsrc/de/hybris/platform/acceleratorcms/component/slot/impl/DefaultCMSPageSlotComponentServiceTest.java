/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorcms.component.slot.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cms2.servicelayer.services.CMSContentSlotService;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


@UnitTest
public class DefaultCMSPageSlotComponentServiceTest
{
	@Test(expected = IllegalArgumentException.class)
	public void getContentSlotForIdWithNullIdTest()
	{
		final DefaultCMSPageSlotComponentService service = new DefaultCMSPageSlotComponentService();
		service.getContentSlotForId(null);
	}

	@Test
	public void getContentSlotForIdWithEmptyIdTest()
	{
		final DefaultCMSPageSlotComponentService service = new DefaultCMSPageSlotComponentService();
		final CMSContentSlotService contentSlot = Mockito.mock(CMSContentSlotService.class);
		service.setCmsContentSlotService(contentSlot);
		final String id = StringUtils.EMPTY;
		Assert.assertNull(service.getContentSlotForId(id));
	}
}
