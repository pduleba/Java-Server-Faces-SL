/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc. and individual contributors
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
package org.richfaces.renderkit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.Resource;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.context.FacesContext;

/**
 * @author <a href="http://community.jboss.org/people/lfryc">Lukas Fryc</a>
 */
@ResourceDependencies({ @ResourceDependency(library = "javax.faces", name = "jsf.js"),
        @ResourceDependency(library = "org.richfaces", name = "jquery.js"),
        @ResourceDependency(library = "org.richfaces", name = "richfaces.js"),
        @ResourceDependency(library = "org.richfaces", name = "richfaces-queue.reslib"),
        @ResourceDependency(library = "org.richfaces", name = "richfaces-base-component.js"),
        @ResourceDependency(library = "org.richfaces", name = "richfaces-event.js"),
        @ResourceDependency(library = "org.richfaces", name = "richfaces-utils.js"),
        @ResourceDependency(library = "org.richfaces.ckeditor", name = "ckeditor.js"),
        @ResourceDependency(library = "org.richfaces.ckeditor", name = "config.js"),
        @ResourceDependency(library = "org.richfaces", name = "editor.js") })
public class EditorRendererBase extends InputRendererBase {

    public static final String DEFAULT_WIDTH = "100%";
    public static final String DEFAULT_HEIGHT = "200px";

    private Pattern DB_PATTERN = Pattern.compile("(^|.*[&|?])(db=[^&]*).*");

    public String resolveUnits(Object dimension) {
        String dim = (String) dimension;
        if (dim.matches("^[0-9]+$")) {
            return dim + "px";
        } else {
            return dim;
        }
    }

    public String getCKEditorRequestPath(FacesContext facesContext) {
        Resource resource = facesContext.getApplication().getResourceHandler()
                .createResource("ckeditor.js", "org.richfaces.ckeditor");
        return resource.getRequestPath();
    }

    public String getECSSQueryString(FacesContext facesContext, String resourceName) {
        Resource resource = facesContext.getApplication().getResourceHandler()
                .createResource(resourceName, "org.richfaces.ckeditor");
        String requestPath = resource.getRequestPath();

        Matcher matcher = DB_PATTERN.matcher(requestPath);
        if (matcher.matches()) {
            return "?" + matcher.group(2);
        } else {
            return "";
        }
    }
}
