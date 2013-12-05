package org.retail.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author the-ramones
 */
@Singleton
@Startup
public class ConfigBean {

    @EJB
    RequestBean requestBean;

    @PostConstruct
    public void fillUp() {
    }
}
