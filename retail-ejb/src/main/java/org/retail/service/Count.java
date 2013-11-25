package org.retail.service;

import javax.ejb.Local;

/**
 *
 * @author the-ramones
 */
@Local
public interface Count {

    public long getHits();

    public void addHit();
}
