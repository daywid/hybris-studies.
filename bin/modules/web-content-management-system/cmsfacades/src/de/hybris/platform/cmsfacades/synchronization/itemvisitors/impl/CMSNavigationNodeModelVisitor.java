/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.synchronization.itemvisitors.impl;

import static com.google.common.collect.Lists.newLinkedList;

import de.hybris.platform.cms2.model.navigation.CMSNavigationNodeModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.visitor.ItemVisitor;

import java.util.List;
import java.util.Map;

/**
 * Concrete implementation of {@link ItemVisitor} to visit items of the {@link CMSNavigationNodeModel} types.
 *
 * Returns the items from {@link CMSNavigationNodeModel#getChildren()}, {@link CMSNavigationNodeModel#getEntries()} and {@link CMSNavigationNodeModel#getLinks()}   
 *
 */
public class CMSNavigationNodeModelVisitor implements ItemVisitor<CMSNavigationNodeModel>
{

	@Override
	public List<ItemModel> visit(CMSNavigationNodeModel source, List<ItemModel> path, Map<String, Object> ctx)
	{
		final List<ItemModel> collectedItems = newLinkedList();
		
		collectedItems.addAll(source.getChildren());
		collectedItems.addAll(source.getEntries());
		collectedItems.addAll(source.getLinks());
		
		return collectedItems;
	}

}
