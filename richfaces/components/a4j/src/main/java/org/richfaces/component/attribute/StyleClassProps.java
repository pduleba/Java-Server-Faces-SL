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

package org.richfaces.component.attribute;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.Description;

/**
 * Interface defining the methods for styleClass-prop.xml
 *
 * @author <a href="http://community.jboss.org/people/bleathem">Brian Leathem</a>
 */
public interface StyleClassProps {
    /**
     * Space-separated list of CSS style class(es) to be applied when this element is rendered. This value must be
     * passed through as the "class" attribute on generated markup.
     */
    @Attribute(passThrough = true,
            description = @Description(
                    value = "Space-separated list of CSS style class(es) to be applied when this element is rendered. This value must be passed through as the \"class\" attribute on generated markup.",
                    displayName = "CSS Style Classes"))
    String getStyleClass();
}