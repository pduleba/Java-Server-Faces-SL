package org.richfaces.renderkit;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Test;
import org.richfaces.CustomizedHtmlUnitEnvironment;
import org.richfaces.renderkit.html.RendererTestBase;

public class InputNumberSpinnerRendererTest extends RendererTestBase {

    @Override
    public void setUp() throws URISyntaxException {
        environment = new CustomizedHtmlUnitEnvironment();
        environment.withWebRoot(new File(this.getClass().getResource(".").toURI()));
        environment.withResource("/WEB-INF/faces-config.xml", "org/richfaces/renderkit/faces-config.xml");
        environment.start();
    }

    @Test
    public void testBasicLayout() throws Exception {
        doTest("inputNumberSpinner", "inputNumberSpinner", "form:spinner");
    }
}
