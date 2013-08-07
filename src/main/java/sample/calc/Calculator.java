package sample.calc;

import javax.ejb.Remote;

/**
 * Created by  Alexey Gorovoy
 * Date:    30.07.13
 * Time:    10:22
 * Email:   alexey.gorovoy.work@gmail.com
 */
@Remote
public interface Calculator {
    public double add(double x, double y);
}
