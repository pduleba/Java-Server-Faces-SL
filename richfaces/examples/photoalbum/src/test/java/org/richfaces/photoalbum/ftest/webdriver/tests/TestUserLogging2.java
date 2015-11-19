/*******************************************************************************
 * JBoss, Home of Professional Open Source
 * Copyright 2010-2014, Red Hat, Inc. and individual contributors
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
 *******************************************************************************/
package org.richfaces.photoalbum.ftest.webdriver.tests;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import category.FailingOnPhantomJS;

/**
 * @author <a href="mailto:jstefek@redhat.com">Jiri Stefek</a>
 */
public class TestUserLogging2 extends AbstractPhotoalbumTest {

    /**
     * Removed from TestUserLogging, cannot get rid of G+ in cache
     */
    @Test
    @Category({ FailingOnPhantomJS.class })
    public void testLoginUser_loginWithSocials_logout() {
        page.login("amarkhel", "12345");
        page.checkUserLogged("amarkhel", true, false, false);
        page.getHeaderPanel().loginToFB();
        page.checkUserLogged("amarkhel", true, true, false);
        page.getHeaderPanel().loginToGPlus();
        page.checkUserLogged("amarkhel", true, true, true);
        page.logout();
        page.checkNotLogged();
    }
}
