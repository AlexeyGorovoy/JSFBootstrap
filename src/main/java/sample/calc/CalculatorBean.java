package sample.calc;

import sample.domain.Expression;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by  Alexey Gorovoy
 * Date:    30.07.13
 * Time:    10:25
 * Email:   alexey.gorovoy.work@gmail.com
 */
@ManagedBean
@SessionScoped
public class CalculatorBean {
    @EJB
    Calculator calculator;

    double x;
    double y;
    double result;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String add() {
        result = calculator.add(x, y);
        return "success";
    }

    public Expression getExpression() {
        return new Expression(x, y);
    }
}