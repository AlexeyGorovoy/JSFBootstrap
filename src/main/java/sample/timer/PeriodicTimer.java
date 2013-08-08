package sample.timer;

import javax.ejb.Remote;

/**
 * Created by  Alexey Gorovoy
 * Date:    08.08.13
 * Time:    10:53
 * Email:   alexey.gorovoy.work@gmail.com
 */
@Remote
public interface PeriodicTimer {
    public void setUpTimer(long interval);
    public void stopAll();
}
