/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.externaltax.impl;

import static org.mockito.BDDMockito.given;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commerceservices.externaltax.RecalculateExternalTaxesStrategy;
import de.hybris.platform.commerceservices.order.CommerceCartHashCalculationStrategy;
import de.hybris.platform.commerceservices.service.data.CommerceOrderParameter;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultRecalculateExternaTaxesStrategyTest
{
	private DefaultRecalculateExternalTaxesStrategy recalculateExternalTaxesStrategy;

	private CartModel cart;
	@Mock(lenient = true)
	private ModelService modelService;

	@Mock
	private SessionService sessionService;

	@Mock(lenient = true)
	private CommerceCartHashCalculationStrategy commerceCartHashCalculationStrategy;

	@Before
	public void setUp() throws Exception
	{
		cart = new CartModel();
		given(modelService.getModelType(cart)).willReturn("Cart");
		given(
				commerceCartHashCalculationStrategy.buildHashForAbstractOrder(Mockito.any(AbstractOrderModel.class),
						Mockito.any(List.class))).willReturn("hash");
		recalculateExternalTaxesStrategy = new DefaultRecalculateExternalTaxesStrategy();
		recalculateExternalTaxesStrategy.setModelService(modelService);
		recalculateExternalTaxesStrategy.setCommerceCartHashCalculationStrategy(commerceCartHashCalculationStrategy);
		recalculateExternalTaxesStrategy.setSessionService(sessionService);
	}

	@Test
	public void testShouldNotRecalculate()
	{
		given(commerceCartHashCalculationStrategy.buildHashForAbstractOrder(Mockito.any(CommerceOrderParameter.class))).willReturn(
				"aHash");
		given(sessionService.getAttribute(RecalculateExternalTaxesStrategy.SESSION_ATTIR_ORDER_RECALCULATION_HASH)).willReturn(
				"aHash");
		recalculateExternalTaxesStrategy.recalculate(cart);
		Assert.assertEquals(Boolean.FALSE, Boolean.valueOf(recalculateExternalTaxesStrategy.recalculate(cart)));
	}

	@Test
	public void testShouldRecalculateEmptyHash()
	{
		Assert.assertEquals(Boolean.TRUE, Boolean.valueOf(recalculateExternalTaxesStrategy.recalculate(cart)));
	}

	@Test
	public void testShouldRecalculateAttributeChanged()
	{
		recalculateExternalTaxesStrategy.recalculate(cart);
		given(
				commerceCartHashCalculationStrategy.buildHashForAbstractOrder(Mockito.any(AbstractOrderModel.class),
						Mockito.any(List.class))).willReturn("changedhash");
		Assert.assertEquals(Boolean.TRUE, Boolean.valueOf(recalculateExternalTaxesStrategy.recalculate(cart)));
	}
}
