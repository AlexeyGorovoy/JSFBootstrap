package sample.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by  Alexey Gorovoy
 * Date:    06.08.13
 * Time:    12:34
 * Email:   alexey.gorovoy.work@gmail.com
 */

@Entity
@Table(name = "addition")
@NamedQuery(name = "getAll", query = "select a from addition a")
public class Expression implements Serializable {

    public Expression() {
    }

    public Expression(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "add_seq_gen")
    @SequenceGenerator(name = "add_seq_gen", sequenceName = "add_seq")
    private Integer id;

    @Column
    private Double x;

    @Column
    private Double y;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(x.toString());
        sb.append(" + ");
        sb.append(y.toString());
        sb.append(" = ");
        sb.append(x + y);
        return sb.toString();
    }
}
