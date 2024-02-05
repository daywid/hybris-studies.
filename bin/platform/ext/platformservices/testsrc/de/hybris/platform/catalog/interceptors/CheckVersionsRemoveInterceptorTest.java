/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.catalog.interceptors;

import static de.hybris.platform.jalo.Item.DISABLE_ITEMCHECK_BEFORE_REMOVABLE;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.catalog.daos.CatalogVersionDao;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.servicelayer.i18n.L10NService;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.session.SessionService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class CheckVersionsRemoveInterceptorTest
{
	@Mock
	private CatalogVersionDao catalogVersionDao;

	@Mock
	private L10NService l10nService;

	@Mock
	private SessionService sessionService;

	private CheckVersionsRemoveInterceptor defaultRemoveCatalogCheckVersions;

	@Before
	public void setUp()
	{
		defaultRemoveCatalogCheckVersions = new CheckVersionsRemoveInterceptor();
		defaultRemoveCatalogCheckVersions.setCatalogVersionDao(catalogVersionDao);
		defaultRemoveCatalogCheckVersions.setL10nService(l10nService);
		defaultRemoveCatalogCheckVersions.setSessionService(sessionService);

		when(sessionService.getAttribute(DISABLE_ITEMCHECK_BEFORE_REMOVABLE)).thenReturn(Boolean.FALSE);
	}

	//catalog

	@Test
	public void checkCanRemoveTest() throws InterceptorException
	{
		final CatalogModel model = new CatalogModel();
		final Set<CatalogVersionModel> catalogVersions = new HashSet<CatalogVersionModel>();

		final CatalogVersionModel catalogVersionModel1 = new CatalogVersionModel();
		catalogVersionModel1.setActive(Boolean.FALSE);
		final CatalogVersionModel catalogVersionModel2 = new CatalogVersionModel();
		catalogVersionModel2.setActive(Boolean.FALSE);
		catalogVersions.addAll(Arrays.asList(catalogVersionModel1, catalogVersionModel2));

		model.setCatalogVersions(catalogVersions);
		defaultRemoveCatalogCheckVersions.onRemove(model, null);
	}

	@Test
	public void checkCannotDefaultRemoveTest()
	{
		final CatalogModel model = new CatalogModel();
		final Set<CatalogVersionModel> catalogVersions = new HashSet<CatalogVersionModel>();

		final CatalogVersionModel catalogVersionModel1 = new CatalogVersionModel();
		catalogVersionModel1.setActive(Boolean.TRUE);
		final CatalogVersionModel catalogVersionModel2 = new CatalogVersionModel();
		catalogVersionModel2.setActive(Boolean.FALSE);
		final CatalogVersionModel catalogVersionModel3 = new CatalogVersionModel();
		catalogVersionModel3.setActive(Boolean.FALSE);
		final CatalogVersionModel catalogVersionModel4 = new CatalogVersionModel();
		catalogVersionModel4.setActive(Boolean.FALSE);
		final CatalogVersionModel catalogVersionModel5 = new CatalogVersionModel();
		catalogVersionModel5.setActive(Boolean.FALSE);


		catalogVersions.addAll(Arrays.asList(catalogVersionModel1, catalogVersionModel2, catalogVersionModel3,
				catalogVersionModel4, catalogVersionModel5));

		model.setCatalogVersions(catalogVersions);

		when(catalogVersionDao.findAllCategoriesCount(catalogVersionModel2)).thenReturn(Integer.valueOf(1));
		when(catalogVersionDao.findAllKeywordsCount(catalogVersionModel3)).thenReturn(Integer.valueOf(1));
		when(catalogVersionDao.findAllMediasCount(catalogVersionModel4)).thenReturn(Integer.valueOf(1));
		when(catalogVersionDao.findAllProductsCount(catalogVersionModel5)).thenReturn(Integer.valueOf(1));

		final ArgumentMatcher<Object[]> match = new ArgumentMatcher()
		{

			@Override
			public boolean matches(final Object argument)
			{
				if (argument instanceof Object[])
				{

					final Set<CatalogVersionModel> res = (Set<CatalogVersionModel>) ((Object[]) argument)[0];
					if (!res.contains(catalogVersionModel1))
					{
						return false;
					}
					if (!res.contains(catalogVersionModel2))
					{
						return false;
					}
					if (!res.contains(catalogVersionModel3))
					{
						return false;
					}
					if (!res.contains(catalogVersionModel4))
					{
						return false;
					}
					if (!res.contains(catalogVersionModel5))
					{
						return false;
					}
					return true;
				}
				return false;
			}
		};


		when(
				l10nService.getLocalizedString(Mockito.eq("error.catalog.contains_non_removable_versions"),
						ArgumentMatchers.argThat(match)))
				.thenReturn("error msg");

		assertThatThrownBy(() -> defaultRemoveCatalogCheckVersions.onRemove(model, null))
				.isInstanceOf(InterceptorException.class)
				.hasMessage("[null]:error msg");
	}


	///catalog version
	@Test
	public void checkCanRemoveCatalogVersionTest() throws InterceptorException
	{

		final Set<CatalogVersionModel> catalogVersions = new HashSet<CatalogVersionModel>();

		final CatalogVersionModel catalogVersionModel1 = new CatalogVersionModel();
		catalogVersionModel1.setActive(Boolean.FALSE);
		final CatalogVersionModel catalogVersionModel2 = new CatalogVersionModel();
		catalogVersionModel2.setActive(Boolean.FALSE);
		catalogVersions.addAll(Arrays.asList(catalogVersionModel1, catalogVersionModel2));


		defaultRemoveCatalogCheckVersions.onRemove(catalogVersionModel1, null);
		defaultRemoveCatalogCheckVersions.onRemove(catalogVersionModel2, null);
	}

	@Test
	public void checkCannotDefaultRemoveCatalogVersionTest()
	{
		final CatalogVersionModel catalogVersionModel1 = new CatalogVersionModel();
		catalogVersionModel1.setActive(Boolean.TRUE);
		final CatalogVersionModel catalogVersionModel2 = new CatalogVersionModel();
		catalogVersionModel2.setActive(Boolean.FALSE);
		final CatalogVersionModel catalogVersionModel3 = new CatalogVersionModel();
		catalogVersionModel3.setActive(Boolean.FALSE);
		final CatalogVersionModel catalogVersionModel4 = new CatalogVersionModel();
		catalogVersionModel4.setActive(Boolean.FALSE);
		final CatalogVersionModel catalogVersionModel5 = new CatalogVersionModel();
		catalogVersionModel5.setActive(Boolean.FALSE);

		when(catalogVersionDao.findAllCategoriesCount(catalogVersionModel2)).thenReturn(Integer.valueOf(1));
		when(catalogVersionDao.findAllKeywordsCount(catalogVersionModel3)).thenReturn(Integer.valueOf(1));
		when(catalogVersionDao.findAllMediasCount(catalogVersionModel4)).thenReturn(Integer.valueOf(1));
		when(catalogVersionDao.findAllProductsCount(catalogVersionModel5)).thenReturn(Integer.valueOf(1));

		final ArgumentMatcher<Object[]> match = new ArgumentMatcher()
		{

			@Override
			public boolean matches(final Object argument)
			{
				if (argument instanceof Object[])
				{
					final Set<CatalogVersionModel> res = (Set<CatalogVersionModel>) ((Object[]) argument)[0];
					if (res.size() != 1)
					{
						return false;
					}

					if (res.contains(catalogVersionModel1))
					{
						return true;
					}
					if (res.contains(catalogVersionModel2))
					{
						return true;
					}
					if (res.contains(catalogVersionModel3))
					{
						return true;
					}
					if (res.contains(catalogVersionModel4))
					{
						return true;
					}
					if (res.contains(catalogVersionModel5))
					{
						return true;
					}
					return false;
				}
				return false;
			}
		};


		when(
				l10nService.getLocalizedString(Mockito.eq("error.catalog.contains_non_removable_versions"),
						ArgumentMatchers.argThat(match)))
				.thenReturn("error msg");


		assertThatThrownBy(() -> defaultRemoveCatalogCheckVersions.onRemove(catalogVersionModel1, null))
				.isInstanceOf(InterceptorException.class)
				.hasMessage("[null]:error msg");

		assertThatThrownBy(() -> defaultRemoveCatalogCheckVersions.onRemove(catalogVersionModel2, null))
				.isInstanceOf(InterceptorException.class)
				.hasMessage("[null]:error msg");

		assertThatThrownBy(() -> defaultRemoveCatalogCheckVersions.onRemove(catalogVersionModel3, null))
				.isInstanceOf(InterceptorException.class)
				.hasMessage("[null]:error msg");

		assertThatThrownBy(() -> defaultRemoveCatalogCheckVersions.onRemove(catalogVersionModel4, null))
				.isInstanceOf(InterceptorException.class)
				.hasMessage("[null]:error msg");

		assertThatThrownBy(() -> defaultRemoveCatalogCheckVersions.onRemove(catalogVersionModel5, null))
				.isInstanceOf(InterceptorException.class)
				.hasMessage("[null]:error msg");

	}

}
