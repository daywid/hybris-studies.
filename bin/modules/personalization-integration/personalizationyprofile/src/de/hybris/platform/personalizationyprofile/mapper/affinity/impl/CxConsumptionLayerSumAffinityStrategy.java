/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationyprofile.mapper.affinity.impl;

import de.hybris.platform.personalizationyprofile.mapper.affinity.CxConsumptionLayerAffinityStrategy;
import de.hybris.platform.personalizationyprofile.yaas.Affinity;

import java.math.BigDecimal;


/**
 * Sums current score with recent score to produce affinity
 *
 * @deprecated since 2011, Profile structure has changed and code is no longer valid. Mappers which have used that
 *             strategy are deprecated
 */
@Deprecated(since = "2011", forRemoval = true)

public class CxConsumptionLayerSumAffinityStrategy implements CxConsumptionLayerAffinityStrategy
{

	@Override
	public BigDecimal extract(final Affinity affinity)
	{
		if (affinity == null)
		{
			return BigDecimal.ZERO;
		}

		BigDecimal current = affinity.getRecentScore();
		BigDecimal previous = affinity.getScore();

		current = current != null ? current : BigDecimal.ZERO;
		previous = previous != null ? previous : BigDecimal.ZERO;

		return current.add(previous);
	}

}
