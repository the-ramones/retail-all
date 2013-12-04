package org.retail.service;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.Local;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;

/**
 *
 * @author the-ramones
 */
@Singleton
@Startup
// must be Singleton to work properly
// @DependsOn("CartBean")
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
// if not specified, @Lock(LockType.WRITE) is assumed
@Lock(LockType.READ)
@AccessTimeout(unit = TimeUnit.SECONDS, value = 4L)
@Local(value = Count.class)
public class SingletonBean implements Count {

    private final static Logger logger = Logger.getLogger(SingletonBean.class.getName());

    public SingletonBean() {
    }
    ///////////////////////// REAL INTERFACE ///////////////////////////////////
    private long hits = 1L;

    @AccessTimeout(value = 1L, unit = TimeUnit.SECONDS)
    @Lock(LockType.READ)
    public long getHits() {
        return hits;
    }

    @AccessTimeout(value = 10L, unit = TimeUnit.SECONDS)
    @Lock(LockType.WRITE)
    public void addHit() {
        hits++;
    }

    ///////////////////////// REAL INTERFACE ///////////////////////////////////    
    @PostConstruct
    public void init() {
        logger.info("Ready");
    }

    public void onlyRead() {
    }

    @Lock(LockType.WRITE)
    @AccessTimeout(unit = TimeUnit.SECONDS, value = 8L)
    public void onlyWrite(String value) {
    }

    @Timeout
    public void timedAction() {
    }

    @Timeout
    public void timedAction(Timer timer) {
    }
}
