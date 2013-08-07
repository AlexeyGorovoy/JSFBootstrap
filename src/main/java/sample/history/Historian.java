package sample.history;

import sample.domain.Expression;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by  Alexey Gorovoy
 * Date:    30.07.13
 * Time:    11:49
 * Email:   alexey.gorovoy.work@gmail.com
 */
@Remote
public interface Historian {
    public void addEntry(Expression exp);
    public List<Expression> getHistory();
}

