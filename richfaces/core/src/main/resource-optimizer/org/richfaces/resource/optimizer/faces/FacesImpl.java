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
package org.richfaces.resource.optimizer.faces;

import java.util.Collections;
import java.util.Set;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.context.FacesContext;

import org.richfaces.application.DependencyInjector;
import org.richfaces.application.DependencyInjectorImpl;
import org.richfaces.application.Module;
import org.richfaces.application.ServicesFactory;
import org.richfaces.application.ServicesFactoryImpl;
import org.richfaces.application.configuration.ConfigurationService;
import org.richfaces.application.configuration.ConfigurationServiceImpl;
import org.richfaces.resource.ResourceKey;
import org.richfaces.resource.external.MappedResourceFactory;
import org.richfaces.resource.external.ResourceTracker;
import org.richfaces.resource.external.ResourceTrackerImpl;
import org.richfaces.resource.mapping.ResourcePath;
import org.richfaces.resource.optimizer.Faces;
import org.richfaces.resource.optimizer.FileNameMapper;
import org.richfaces.resource.optimizer.skin.SkinFactoryImpl;
import org.richfaces.application.ServiceTracker;
import org.richfaces.skin.SkinFactory;

import com.google.common.collect.Sets;

/**
 * @author Nick Belaevski
 *
 */
public class FacesImpl implements Faces {
    private String webroot;
    private FileNameMapper fileNameMapper;
    private ResourceHandler resourceHandler;

    public FacesImpl(String webroot, FileNameMapper fileNameMapper, ResourceHandler resourceHandler) {
        super();
        this.webroot = webroot;
        this.fileNameMapper = fileNameMapper;
        this.resourceHandler = resourceHandler;
    }

    public void start() {

        final ServicesFactoryImpl serviceFactory = new ServicesFactoryImpl();
        Module module = new Module() {
            public void configure(ServicesFactory factory) {
                factory.setInstance(ConfigurationService.class, new ConfigurationServiceImpl());
                factory.setInstance(SkinFactory.class, new SkinFactoryImpl());
                factory.setInstance(FileNameMapper.class, fileNameMapper);
                factory.setInstance(DependencyInjector.class, new DependencyInjectorImpl());
                factory.setInstance(ResourceHandler.class, resourceHandler);
                factory.setInstance(ResourceTracker.class, new ResourceTrackerImpl());
                factory.setInstance(MappedResourceFactory.class, new NullMappedResourceFactory());
            }
        };

        ServiceTracker.setFactory(serviceFactory);

        // initialization with FacesContext available
        startRequest();
        serviceFactory.init(Collections.singleton(module));
        stopRequest();
    }

    public void stop() {
        ServiceTracker.release();
    }

    public void setSkin(String skinName) {
        SkinFactoryImpl.setSkinName(skinName);
    }

    public FacesContext startRequest() {
        FacesContextImpl facesContextImpl = new FacesContextImpl();
        facesContextImpl.getExternalContext().setWebRoot(webroot);
        assert FacesContext.getCurrentInstance() != null;

        return facesContextImpl;
    }

    public void stopRequest() {
        FacesContext.getCurrentInstance().release();
        assert FacesContext.getCurrentInstance() == null;
    }

    private static class NullMappedResourceFactory implements MappedResourceFactory {
        @Override
        public Set<ResourceKey> getAggregatedResources(ResourcePath resourcePath) {
            return Sets.newHashSet();
        }

        @Override
        public Resource createResource(FacesContext facesContext, ResourceKey resourceKey) {
            return null;
        }
    }
}
