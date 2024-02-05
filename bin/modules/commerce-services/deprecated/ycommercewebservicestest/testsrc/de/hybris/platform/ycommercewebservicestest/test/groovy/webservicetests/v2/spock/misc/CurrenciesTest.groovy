/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.misc

import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.ContentType.URLENC
import static groovyx.net.http.ContentType.XML
import static org.apache.http.HttpStatus.SC_OK

import de.hybris.bootstrap.annotations.ManualTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.AbstractSpockFlowTest

import spock.lang.Unroll
import groovyx.net.http.HttpResponseDecorator

@ManualTest
@Unroll
class CurrenciesTest extends AbstractSpockFlowTest {

	private currencyList = ['USD', 'JPY']

	def "Client retrieves supported currencies: #format"() {

		when:
		HttpResponseDecorator response = restClient.get(path: getBasePathWithSite() + '/currencies', contentType: format)

		then:
		with(response) {
			if (isNotEmpty(data) && isNotEmpty(data.errors)) println(data)
			status == SC_OK
			isNotEmpty(data.currencies)
			data.currencies.size() == currencyList.size()
			data.currencies.findAll { currency ->
				currency.isocode in currencyList
			}.size() == currencyList.size()
		}

		where:
		format << [JSON, XML]
	}
}
