package org.retail.service.timed;

import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Schedules;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * Sometime business flow relies on timed events, actions repeated in time.
 * Timers: a. handled, going off by a container b. typed: single-event,
 * calendar, repeated, interval c. automatic (container), programmatic
 * (developer)
 *
 * Base: TimeService
 *
 * Automatic: java.ejb.Schedule java.ejb.Schedules
 *
 * Programmatic are set by creation through one of TimeService methods
 *
 * Miscella: calendar alike CRON timers second 0-59 minute 0-59 hour 0-23
 * dayOfWeek 0-7; Sun, Mon, Tue, Wed, Thu, Fri, Sat; dayOfMonth 1-31; -7 -1 (-n
 * days before the end of the month); Last; [1st 2nd 3rd 4th][Sun Tue Thu Fri]
 * like 2nd Fri or 3rd Tue month 1-12; Jan, Feb, Mar, Apr, May, Jun, Jul, Aug,
 * Sep, Oct, Nov, Dec year 2010, 2020
 *
 * dayOdWeek="Tue, Fri, Sat" day="1,5,10-15,20,25,30"
 *
 * minute"'asterisk'/10" is equivalent minute='0,10,20,30,40,50 hour="12/2" is
 * equivalent minute="12,14,16,18,20,22"
 *
 *
 * @author Paul Kulitski
 */
@Singleton
@Startup
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TimedBean {
    
    @Resource
    TimerService timerService;
    
    private static final Logger logger = Logger.getLogger(TimedBean.class.getName());
    
    public TimedBean() {
    }

    /*
     * Programmatic timeout
     */
    @Timeout
    public void programmaticTimeout(Timer timer) {
        /*
         * Cancel the timer
         */
        timer.cancel();
        
        timer.isPersistent();
        timer.isCalendarTimer();
        timer.getTimeRemaining();
        timer.getSchedule();
        timer.getNextTimeout();
        timer.getInfo();
        timer.getHandle();
        logger.warning("programmatic timeout has occured");
        logger.info("timer was: " + timer.toString());
    }
    
    @Schedules({
        @Schedule(minute = "*", hour = "*"),
        @Schedule(dayOfWeek = "Mon")
    })
    public void automaticTimeout() {
        logger.info("automatic timeout (@Schedule)");
    }
    
    public void setIntervalTimer(long miliseconds) {
        TimerConfig timerConfig = new TimerConfig("timed service interval timer", true);
        /*
         * Created a new interval timer and make it goes off
         */
        Timer timer = timerService.createIntervalTimer(100000, 10000, timerConfig);
    }
    
    public void setSingleActionTimer(long miliseconds) {
        TimerConfig timerConfig = new TimerConfig("timed service single timer", true);
        Timer timer = timerService.createSingleActionTimer(100000, timerConfig);
    }
    
    public void setCalendarTimer() {
        TimerConfig timerConfig = new TimerConfig("timed service calendar timer", true);
        ScheduleExpression scheduleExpression = new ScheduleExpression();
        scheduleExpression.dayOfMonth("*/2");
        scheduleExpression.hour("*");
        scheduleExpression.minute("*/10");
        Timer timer = timerService.createCalendarTimer(scheduleExpression, timerConfig);
    }
}
