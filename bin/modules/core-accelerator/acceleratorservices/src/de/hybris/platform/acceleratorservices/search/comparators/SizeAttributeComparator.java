/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorservices.search.comparators;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Comparator for size attribute of product variants.
 */
public class SizeAttributeComparator implements Comparator<String>
{

	private static final int HUNDRED = 100;

	private String pattern;
	private Pattern regexPattern;
	private List<List<String>> sizeSystems;

	@Override
	public int compare(final String value1, final String value2)
	{
		if (checkNullValues(value1, value2))
		{
			return 0;
		}
		//try numeric compare - if doesn't work then try size system
		final boolean value1IsNumber = isNumber(value1);
		final boolean value2IsNumber = isNumber(value2);
		if (value1IsNumber && value2IsNumber)
		{
			return numericCompare(value1, value2);
		}

		final Integer simpleResult = processSimpleSizeSystems(value1, value2);
		if (simpleResult != null)
		{
			return simpleResult;
		}

		final Integer complexResult = processComplexSizeSystems(value1, value2, value1IsNumber, value2IsNumber);
		if (complexResult != null)
		{
			return complexResult;
		}

		//no luck - assume values are equal
		return 0;
	}

	protected boolean checkNullValues(final String value1, final String value2)
	{
		return value1 == null || value2 == null;
	}

	protected Integer processSimpleSizeSystems(final String value1, final String value2)
	{
		//try compare within each size system
		for (final List<String> sizeSystem : sizeSystems)
		{
			if (sizeSystem.contains(value1) && sizeSystem.contains(value2))
			{
				final int index1 = sizeSystem.indexOf(value1);
				final int index2 = sizeSystem.indexOf(value2);
				return index1 - index2;
			}
		}
		return null;
	}

	protected Integer processComplexSizeSystems(final String value1, final String value2, final boolean value1IsNumber,
			final boolean value2IsNumber)
	{
		//values may come from distinct size systems - where one is numeric
		final int value1SizeSystemIndex = getSizeSystemIndex(value1);
		final int value2SizeSystemIndex = getSizeSystemIndex(value2);
		if (value1IsNumber)
		{
			return processMinSizeSystems(value2, value2SizeSystemIndex);
		}
		else if (value2IsNumber)
		{
			return processMaxSizeSystems(value1, value1SizeSystemIndex);
		}
		//values may come from distinct size systems - where both are not numeric
		else if (value1SizeSystemIndex != -1)
		{
			return processNonNumericDistinctSystems(value1, value2, value1SizeSystemIndex, value2SizeSystemIndex);
		}
		else if (value2SizeSystemIndex != -1)
		{
			//values out of size-systems are placed as last thus so big number.
			return Integer.MAX_VALUE;
		}
		return null;
	}

	protected int processNonNumericDistinctSystems(final String value1, final String value2, final int value1SizeSystemIndex,
			final int value2SizeSystemIndex)
	{
		if (value2SizeSystemIndex == -1)
		{
			//values out of size-systems are placed as last thus so big number.
			return Integer.MIN_VALUE;
		}
		else
		{
			final int val1Index = (value1SizeSystemIndex + 1) * HUNDRED + sizeSystems.get(value1SizeSystemIndex).indexOf(value1);
			final int val2Index = (value2SizeSystemIndex + 1) * HUNDRED + sizeSystems.get(value2SizeSystemIndex).indexOf(value2);
			return val1Index - val2Index;
		}
	}

	protected int processMaxSizeSystems(final String value1, final int value1SizeSystemIndex)
	{
		if (value1SizeSystemIndex == -1)
		{
			//indicates numeric values comes first
			//and values out of size-systems are placed as last thus so big number.
			return Integer.MAX_VALUE;
		}
		else
		{
			//this will distribute other systems
			return (value1SizeSystemIndex + 1) * HUNDRED + sizeSystems.get(value1SizeSystemIndex).indexOf(value1);
		}
	}

	protected int processMinSizeSystems(final String value2, final int value2SizeSystemIndex)
	{
		if (value2SizeSystemIndex == -1)
		{
			//indicates numeric values comes first
			//and values out of size-systems are placed as last thus so big number.
			return Integer.MIN_VALUE;
		}
		else
		{
			//this will distribute other systems
			return -(value2SizeSystemIndex + 1) * HUNDRED + sizeSystems.get(value2SizeSystemIndex).indexOf(value2);
		}
	}

	/**
	 * @param value
	 *           to search number in.
	 * @return true if number can be found within given string
	 */
	protected boolean isNumber(final String value)
	{
		return getRegexPattern().matcher(value).find();
	}

	/**
	 * @param value
	 *           to search
	 * @return index of first size-system containing this value, if not found -1 is returned
	 */
	protected int getSizeSystemIndex(final String value)
	{
		for (final List<String> sizeSystem : sizeSystems)
		{
			if (sizeSystem.contains(value))
			{
				return sizeSystems.indexOf(sizeSystem);
			}
		}
		return -1;//indicates that value doesn't exist in any size-system
	}

	/**
	 * Compares two numbers
	 *
	 * @param value1 first double
	 * @param value2 second double
	 */
	protected int numericCompare(final String value1, final String value2)
	{
		final double number1 = getNumber(value1);
		final double number2 = getNumber(value2);
		return Double.compare(number1, number2);
	}

	/**
	 * Searches for the first double value (depends on pattern) found in given string
	 *
	 * @param value given string
	 * @return first double value (depends on pattern) found in given string
	 */
	protected double getNumber(final String value)
	{
		final Matcher matcher = getRegexPattern().matcher(value);
		if (matcher.find())
		{
			return Double.parseDouble(matcher.group());
		}
		return Integer.MAX_VALUE;//let unknown 'numbers' to end up at the end
	}

	protected String getPattern()
	{
		return pattern;
	}

	public void setPattern(final String pattern)
	{
		this.pattern = pattern;
		this.regexPattern = Pattern.compile(pattern);
	}

	protected Pattern getRegexPattern()
	{
		return regexPattern;
	}

	protected List<List<String>> getSizeSystems()
	{
		return sizeSystems;
	}

	public void setSizeSystems(final List<List<String>> sizeSystems)
	{
		this.sizeSystems = sizeSystems;
	}
}
