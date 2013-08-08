package sample.timer;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 * Created by  Alexey Gorovoy
 * Date:    08.08.13
 * Time:    10:54
 * Email:   alexey.gorovoy.work@gmail.com
 */
@ManagedBean
public class PeriodicTimerBean {

    private long interval = 1000*60;

    @EJB
    PeriodicTimer timer;

    private boolean timerStarted;

    public boolean isTimerStarted(){
        return timerStarted;
    }

    public void setTimerStarted(boolean state) {
        timerStarted = state;
    }

    public void startTimer() {
        timer.setUpTimer(interval);
        timerStarted = true;
    }

    public void stopTimer() {
        timer.stopAll();
        timerStarted = false;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long secs) {
        this.interval = secs;
    }
}