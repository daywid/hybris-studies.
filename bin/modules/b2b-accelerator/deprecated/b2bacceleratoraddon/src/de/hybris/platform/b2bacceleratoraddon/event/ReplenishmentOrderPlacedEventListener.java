/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratoraddon.event;

import de.hybris.platform.b2bacceleratorservices.event.ReplenishmentOrderPlacedEvent;
import de.hybris.platform.b2bacceleratorservices.model.process.ReplenishmentProcessModel;
import de.hybris.platform.orderscheduling.model.CartToOrderCronJobModel;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.beans.factory.annotation.Required;


public class ReplenishmentOrderPlacedEventListener extends AbstractEventListener<ReplenishmentOrderPlacedEvent>
{

	private ModelService modelService;
	private BusinessProcessService businessProcessService;

	protected BusinessProcessService getBusinessProcessService()
	{
		return businessProcessService;
	}

	@Required
	public void setBusinessProcessService(final BusinessProcessService businessProcessService)
	{
		this.businessProcessService = businessProcessService;
	}

	protected ModelService getModelService()
	{
		return modelService;
	}

	@Required
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	@Override
	protected void onEvent(final ReplenishmentOrderPlacedEvent event)
	{
		final CartToOrderCronJobModel cartToOrderCronJob = event.getCartToOrderCronJob();
		final ReplenishmentProcessModel replenishmentProcess = (ReplenishmentProcessModel) getBusinessProcessService()
				.createProcess(
						"replenishmentOrderPlacedEmailProcess" + "-" + cartToOrderCronJob.getCode() + "-" + System.currentTimeMillis(),
						"replenishmentOrderPlacedEmailProcess");
		replenishmentProcess.setCartToOrderCronJob(cartToOrderCronJob);
		replenishmentProcess.setCustomer(event.getCustomer());
		replenishmentProcess.setCurrency(event.getCurrency());
		replenishmentProcess.setLanguage(event.getLanguage());
		replenishmentProcess.setStore(event.getBaseStore());
		getModelService().save(replenishmentProcess);
		getBusinessProcessService().startProcess(replenishmentProcess);
	}
}
