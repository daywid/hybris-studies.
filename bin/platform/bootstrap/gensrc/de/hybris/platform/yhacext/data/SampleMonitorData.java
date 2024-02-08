/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 8 de fev. de 2024 10:08:20
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.yhacext.data;

import java.io.Serializable;
import de.hybris.platform.yhacext.data.SampleMonitorResultData;
import java.util.List;


import java.util.Objects;
public  class SampleMonitorData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SampleMonitorData.results</code> property defined at extension <code>yhacext</code>. */
	
	private List<SampleMonitorResultData> results;
	
	public SampleMonitorData()
	{
		// default constructor
	}
	
	public void setResults(final List<SampleMonitorResultData> results)
	{
		this.results = results;
	}

	public List<SampleMonitorResultData> getResults() 
	{
		return results;
	}
	

}