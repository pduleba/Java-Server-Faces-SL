package org.richfaces.service;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.ajax4jsf.javascript.JSLiteral;
import org.richfaces.application.ServiceTracker;
import org.richfaces.focus.FocusManager;
import org.richfaces.javascript.JavaScriptService;
import org.richfaces.log.Logger;
import org.richfaces.log.RichfacesLogger;
import org.richfaces.renderkit.util.RendererUtils;

public class FocusManagerImpl implements FocusManager {

        // find first text input among children or self
    private static final String SCRIPT = "RichFaces.jQuery(document.getElementById('%s'))"
                                       + ".find(':text:visible:first').addBack().focus();";
    private static final Logger LOG = RichfacesLogger.APPLICATION.getLogger();

    @Override
    public void focus(String componentId) {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context == null) {
            throw new IllegalStateException(FocusManager.class.getSimpleName()
                    + " can't be used without FacesContext available");
        }

        if (componentId == null) {
            setContextAttribute(context, null);
        } else {
            UIComponent currentComponent = UIComponent.getCurrentComponent(context);
            if (currentComponent == null) {
                currentComponent = context.getViewRoot();
            }
            currentComponent.findComponent(componentId);
            UIComponent component = RendererUtils.getInstance().findComponentFor(currentComponent, componentId);

            if (component == null) {
                String message = FocusManager.class.getSimpleName() + ": Component with ID '" + componentId + "' was not found";
                LOG.warn(message);
                context.addMessage(null, new FacesMessage(message));
            } else {
                String clientId = component.getClientId(context);

                setContextAttribute(context, clientId);

                JavaScriptService javaScriptService = ServiceTracker.getService(context, JavaScriptService.class);
                javaScriptService.addPageReadyScript(context, new JSLiteral(String.format(SCRIPT, clientId)));
            }
        }
    }

    private void setContextAttribute(FacesContext context, String clientId) {
        context.getAttributes().put(FocusManager.FOCUS_CONTEXT_ATTRIBUTE, clientId);
    }
}

