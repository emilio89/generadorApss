/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/permission/support/TypeAwarePermission.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package uoc.tfm.emilio.web.permission.support;

import static com.google.common.collect.Maps.newHashMap;
import static org.hibernate.proxy.HibernateProxyHelper.getClassWithoutInitializingProxy;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.jpa.querybyexample.Identifiable;

/**
 * Permission service that should be used only in certain cases (e.g. from facelet tags). 
 * 
 * @see GenericPermission
 */
@Named("permission")
@Singleton
@SuppressWarnings("rawtypes")
public class TypeAwarePermission {
    private Map<Class, GenericPermission<?>> permissions = newHashMap();

    @Inject
    void buildCache(List<GenericPermission> registredPermissions) {
        for (GenericPermission permission : registredPermissions) {
            permissions.put(permission.getTarget(), permission);
        }
    }

    @SuppressWarnings("unchecked")
    private <E extends Identifiable<? extends Serializable>> GenericPermission<E> getPermission(E entity) {
        // note: getClassWithoutInitializingProxy expects a non null object
        // _HACK_ as we depend on hibernate here.
        return (GenericPermission<E>) permissions.get(getClassWithoutInitializingProxy(entity));
    }

    // --------------------------------------------------------------
    // Permission shortcut methods that can be used from facelet tags
    // --------------------------------------------------------------

    public <E extends Identifiable<?>> boolean canView(E e) {
        return e == null ? false : getPermission(e).canView(e);
    }

    public <E extends Identifiable<?>> boolean canEdit(E e) {
        return e == null ? false : getPermission(e).canEdit(e);
    }

    public <E extends Identifiable<?>> boolean canDelete(E e) {
        return e == null ? false : getPermission(e).canDelete(e);
    }

    public <E extends Identifiable<?>> boolean canSearch(E e) {
        return e == null ? false : getPermission(e).canSearch(e);
    }

    public <E extends Identifiable<?>> boolean canSelect(E e) {
        return e == null ? false : getPermission(e).canSelect(e);
    }

    public <E extends Identifiable<?>> boolean canUse(E e) {
        return e == null ? false : getPermission(e).canUse(e);
    }
}