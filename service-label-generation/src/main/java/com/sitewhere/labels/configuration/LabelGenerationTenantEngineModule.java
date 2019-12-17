/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.labels.configuration;

import com.sitewhere.microservice.multitenant.TenantEngineModule;

/**
 * Guice module used for configuring components associated with a label
 * generation tenant engine.
 */
public class LabelGenerationTenantEngineModule extends TenantEngineModule<LabelGenerationTenantConfiguration> {

    public LabelGenerationTenantEngineModule(LabelGenerationTenantConfiguration configuration) {
	super(configuration);
    }
}
