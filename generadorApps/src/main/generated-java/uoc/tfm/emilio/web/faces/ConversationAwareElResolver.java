/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/faces/ConversationAwareElResolver.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package uoc.tfm.emilio.web.faces;

import static uoc.tfm.emilio.web.conversation.ConversationHolder.getCurrentConversation;

import javax.el.ELContext;
import javax.el.ELException;

import org.springframework.web.jsf.el.SpringBeanFacesELResolver;

import uoc.tfm.emilio.web.conversation.Conversation;

/**
 * ConversationAwareElResolver is declared in faces-config.xml.
 * It tries to find values in the current {@link ConversationContext}. 
 */
public class ConversationAwareElResolver extends SpringBeanFacesELResolver {

    @Override
    public Object getValue(ELContext elContext, Object base, Object property) throws ELException {
        if (base == null && property != null) {
            Conversation currentConversation = getCurrentConversation();
            if (currentConversation != null) {
                Object result = currentConversation.getVar(property.toString());
                if (result != null) {
                    elContext.setPropertyResolved(true);
                    return result;
                }
            }
        }

        return super.getValue(elContext, base, property);
    }

    @Override
    public Class<?> getType(ELContext elContext, Object base, Object property) throws ELException {
        if (base == null && property != null) {
            Conversation currentConversation = getCurrentConversation();
            if (currentConversation != null) {
                Object value = currentConversation.getVar(property.toString());
                if (value != null) {
                    elContext.setPropertyResolved(true);
                    return value.getClass();
                }
            }
        }

        return super.getType(elContext, base, property);
    }
}