/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.richfaces.resource.external;

import java.util.Map;

import javax.faces.context.FacesContext;

import org.richfaces.resource.ResourceKey;

/**
 * Tracks what external resources are renderered to the page (specific for Mojarra)
 *
 * @author Lukas Fryc
 */
public class ResourceTrackerForMojarra implements ResourceTracker {

    /*
     * (non-Javadoc)
     *
     * @see org.richfaces.resource.external.ExternalResourceTracker#isResourceRenderered(javax.faces.context.FacesContext,
     * org.richfaces.resource.ResourceKey)
     */
    @Override
    public boolean isResourceRenderered(FacesContext facesContext, ResourceKey resourceKey) {
        Map<Object, Object> contextMap = facesContext.getAttributes();

        String key = resourceKey.getResourceName() + resourceKey.getLibraryName();

        return contextMap.containsKey(key);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.richfaces.resource.external.ExternalResourceTracker#markResourceRendered(javax.faces.context.FacesContext,
     * org.richfaces.resource.ResourceKey)
     */
    @Override
    public void markResourceRendered(FacesContext facesContext, ResourceKey resourceKey) {
        final Map<Object, Object> contextMap = facesContext.getAttributes();

        String resourceName = resourceKey.getResourceName();
        String libraryName = resourceKey.getLibraryName();

        String key = resourceName + libraryName;
        putToContext(contextMap, key);

        // also store this in the context map with library as "null"
        if (libraryName == null || libraryName.isEmpty()) {
            libraryName = "null";
            key = resourceName + libraryName;
            putToContext(contextMap, key);
        }
    }

    /**
     * Put resource key to contextMap to avoid rendering that multiple times per request
     *
     * @param contextMap contextMap as provided by current {@link FacesContext}
     * @param key the resource key to be stored in contextMap
     */
    private void putToContext(Map<Object, Object> contextMap, String key) {
        if (!contextMap.containsKey(key)) {
            contextMap.put(key, Boolean.TRUE);
        }
    }
}
