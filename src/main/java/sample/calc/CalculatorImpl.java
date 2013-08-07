package sample.calc;

import javax.ejb.Stateless;

/**
 * Created by  Alexey Gorovoy
 * Date:    30.07.13
 * Time:    10:23
 * Email:   alexey.gorovoy.work@gmail.com
 */
@Stateless
public class CalculatorImpl implements Calculator {

    @Override
    public double add(double x, double y) {
        return x+y;
    }
}
