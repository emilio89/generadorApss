/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/util/TabBean.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package uoc.tfm.emilio.web.util;

import java.io.Serializable;

/**
 * Tracks the <code>p:tabView</code> active index.
 */
public class TabBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int activeIndex = 0;

    public void setActiveIndex(int activeIndex) {
        this.activeIndex = activeIndex;
    }

    public int getActiveIndex() {
        return activeIndex;
    }
}