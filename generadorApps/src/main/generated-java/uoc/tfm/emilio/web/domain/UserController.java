/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/domain/Controller.e.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package uoc.tfm.emilio.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.jpa.querybyexample.SearchParameters;

import uoc.tfm.emilio.domain.User;
import uoc.tfm.emilio.domain.User_;
import uoc.tfm.emilio.printer.UserPrinter;
import uoc.tfm.emilio.repository.UserRepository;
import uoc.tfm.emilio.web.domain.support.GenericController;
import uoc.tfm.emilio.web.permission.UserPermission;

/**
 * Stateless controller for {@link User} conversation start.
 */
@Named
@Singleton
public class UserController extends GenericController<User, Integer> {
    public static final String USER_EDIT_URI = "/domain/userEdit.faces";
    public static final String USER_SELECT_URI = "/domain/userSelect.faces";

    @Inject
    public UserController(UserRepository userRepository, UserPermission userPermission, UserPrinter userPrinter) {
        super(userRepository, userPermission, userPrinter, USER_SELECT_URI, USER_EDIT_URI);
    }

    @Override
    protected SearchParameters defaultOrder(SearchParameters searchParameters) {
        return searchParameters.asc(User_.username);
    }
}