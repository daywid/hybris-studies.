/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorfacades.company.populators;


import de.hybris.platform.b2b.model.B2BPermissionModel;
import de.hybris.platform.b2b.model.B2BUserGroupModel;
import de.hybris.platform.b2bapprovalprocessfacades.company.data.B2BPermissionData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BUnitData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BUserGroupData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.converters.Converters;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.security.PrincipalModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.springframework.beans.factory.annotation.Required;


/**
 * Converter for {@link B2BUserGroupModel}.
 *
 * @deprecated Since 6.0 use
 *             {@link de.hybris.platform.b2bcommercefacades.company.converters.populators.B2BUserGroupPopulator}
 *             instead.
 */
@Deprecated(since = "6.0", forRemoval = true)
public class B2BUserGroupPopulator implements Populator<B2BUserGroupModel, B2BUserGroupData>
{
	private UserService userService;
	private Converter<CustomerModel, CustomerData> b2BCustomerConverter;
	private Converter<B2BPermissionModel, B2BPermissionData> b2BPermissionConverter;


	@Override
	public void populate(final B2BUserGroupModel source, final B2BUserGroupData target)
	{
		target.setUid(source.getUid());
		target.setName(source.getName());

		final B2BUnitData b2BUnitData = new B2BUnitData();
		b2BUnitData.setUid(source.getUnit().getUid());
		b2BUnitData.setName(source.getUnit().getLocName());
		b2BUnitData.setActive(Boolean.TRUE.equals(source.getUnit().getActive()));
		target.setUnit(b2BUnitData);

		final List<B2BPermissionModel> permissions = source.getPermissions();
		if (CollectionUtils.isNotEmpty(permissions))
		{
			target.setPermissions(Converters.convertAll(permissions, getB2BPermissionConverter()));
		}

		final Set<PrincipalModel> members = source.getMembers();
		if (CollectionUtils.isNotEmpty(members))
		{
			target.setMembers(
					Converters.convertAll(CollectionUtils.select(members, PredicateUtils.instanceofPredicate(CustomerModel.class)),
							getB2BCustomerConverter()));
		}
	}

	protected UserService getUserService()
	{
		return userService;
	}

	@Required
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

	protected Converter<CustomerModel, CustomerData> getB2BCustomerConverter()
	{
		return b2BCustomerConverter;
	}

	@Required
	public void setB2BCustomerConverter(final Converter<CustomerModel, CustomerData> b2BCustomerConverter)
	{
		this.b2BCustomerConverter = b2BCustomerConverter;
	}

	protected Converter<B2BPermissionModel, B2BPermissionData> getB2BPermissionConverter()
	{
		return b2BPermissionConverter;
	}

	@Required
	public void setB2BPermissionConverter(final Converter<B2BPermissionModel, B2BPermissionData> b2BPermissionConverter)
	{
		this.b2BPermissionConverter = b2BPermissionConverter;
	}
}
