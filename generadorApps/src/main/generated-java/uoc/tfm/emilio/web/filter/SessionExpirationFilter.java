/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/filter/SessionExpirationFilter.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package uoc.tfm.emilio.web.filter;

import java.io.IOException;

import javax.inject.Named;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uoc.tfm.emilio.web.util.PrimeFacesUtil;

/**
 * This filter handles session expiration during ajax request.
 * IMPORTANT: The spring security filter MUST be placed after this one.
 *
 * Note: if you do not use Spring Security filter then you do not need this filter since you can 
 * handle ViewExpiredException as any other exception (see {@link ConversationAwareExceptionHandler}).
 */
@Named
public class SessionExpirationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (PrimeFacesUtil.isAjax(request) && !request.isRequestedSessionIdValid()) {
            response.getWriter().print(xmlPartialRedirectToPage(request, "/login.faces?session_expired=1"));
            response.flushBuffer();
            return;
        }

        filterChain.doFilter(request, response);
    }

    private String xmlPartialRedirectToPage(HttpServletRequest request, String page) {
        return "<?xml version='1.0' encoding='UTF-8'?>" //
                + "<partial-response>" //
                + "<redirect url=\"" + request.getContextPath() + page + "\"/>" //
                + "</partial-response>";
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}