/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/faces/LocaleSetterListener.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package uoc.tfm.emilio.web.faces;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

import org.omnifaces.eventlistener.DefaultPhaseListener;

import uoc.tfm.emilio.context.LocaleHolder;
import uoc.tfm.emilio.web.filter.LocaleResolverRequestFilter;

/**
 * Set the current locale to jsf from the resolver initialized in {@link LocaleResolverRequestFilter} filter.
 */
public class LocaleSetterListener extends DefaultPhaseListener {
    private static final long serialVersionUID = 1L;

    public LocaleSetterListener() {
        super(PhaseId.RESTORE_VIEW);
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        if (FacesContext.getCurrentInstance().getViewRoot() != null) {
            FacesContext.getCurrentInstance().getViewRoot().setLocale(LocaleHolder.getLocale());
        }
    }
}
