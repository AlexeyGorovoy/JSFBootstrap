package sample.timer;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by  Alexey Gorovoy
 * Date:    08.08.13
 * Time:    10:54
 * Email:   alexey.gorovoy.work@gmail.com
 */
@Stateless
public class PeriodicTimerImpl implements PeriodicTimer {
    @Resource
    TimerService timerService;

    public void setUpTimer(long interval) {
        System.out.println(":> Timer on " + interval + " started!");
        timerService.createTimer(interval, interval, null);
    }

    public void stopAll() {
        List<Timer> timers = new LinkedList<Timer>(timerService.getTimers());
        for (Timer t : timers) {
            t.cancel();
        }
        System.out.println(":> Timer stopped.");
    }

    @Timeout
    public void timeout() {
        System.out.println(":> Timeout!");
    }
}
