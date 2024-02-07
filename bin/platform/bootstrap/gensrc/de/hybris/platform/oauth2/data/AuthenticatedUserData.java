/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 7 de fev. de 2024 13:36:15
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.oauth2.data;

import java.io.Serializable;


import java.util.Objects;
public  class AuthenticatedUserData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AuthenticatedUserData.displayName</code> property defined at extension <code>oauth2</code>. */
	
	private String displayName;
	
	public AuthenticatedUserData()
	{
		// default constructor
	}
	
	public void setDisplayName(final String displayName)
	{
		this.displayName = displayName;
	}

	public String getDisplayName() 
	{
		return displayName;
	}
	

}