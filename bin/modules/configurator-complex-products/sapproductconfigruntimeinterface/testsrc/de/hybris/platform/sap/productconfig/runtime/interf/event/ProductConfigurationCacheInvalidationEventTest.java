/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.runtime.interf.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.servicelayer.event.PublishEventContext;

import org.junit.Test;


@UnitTest
public class ProductConfigurationCacheInvalidationEventTest
{
	private static final String CONFIG_ID = "c123";
	private ProductConfigurationCacheInvalidationEvent classUnderTest;

	@Test
	public void testCreation()
	{
		classUnderTest = new ProductConfigurationCacheInvalidationEvent(CONFIG_ID);
		assertEquals(CONFIG_ID, classUnderTest.getConfigId());
	}

	@Test(expected = NullPointerException.class)
	public void testCanPublishNullCtxt()
	{
		classUnderTest = new ProductConfigurationCacheInvalidationEvent(CONFIG_ID);
		classUnderTest.canPublish(null);
	}

	@Test
	public void testCanPublishSameNode()
	{
		final PublishEventContext ctxt = PublishEventContext.newBuilder().withSourceNodeId(5).withTargetNodeId(5).build();
		classUnderTest = new ProductConfigurationCacheInvalidationEvent(CONFIG_ID);
		assertFalse(CONFIG_ID, classUnderTest.canPublish(ctxt));
	}

	@Test
	public void testCanPublishOtherNode()
	{
		final PublishEventContext ctxt = PublishEventContext.newBuilder().withSourceNodeId(5).withTargetNodeId(1).build();
		classUnderTest = new ProductConfigurationCacheInvalidationEvent(CONFIG_ID);
		assertTrue(CONFIG_ID, classUnderTest.canPublish(ctxt));
	}
}
