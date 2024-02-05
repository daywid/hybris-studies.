/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.odata2services.odata.persistence.hook

import de.hybris.bootstrap.annotations.UnitTest
import de.hybris.platform.testframework.JUnitPlatformSpecification
import org.junit.Test

@UnitTest
class PostPersistHookExceptionUnitTest extends JUnitPlatformSpecification {

	private static final String TEST_HOOK = "testHook"
	private static final String TEST_EXCEPTION_MESSAGE = "test exception message"
	private static final String TEST_INTEGRATION_KEY = "123|abc"

	@Test
	def "message contains hook name and cause when building a pre persist hook exception " () {
		when:
		def hookException = new PostPersistHookException(TEST_HOOK, new IllegalArgumentException(TEST_EXCEPTION_MESSAGE), TEST_INTEGRATION_KEY)
		then:
		hookException.getMessage().contains("Post-Persist-Hook")
		hookException.getMessage().contains(TEST_HOOK)
		hookException.getMessage().contains(TEST_EXCEPTION_MESSAGE)
		hookException.getMessage().contains("IllegalArgumentException")
	}
}
