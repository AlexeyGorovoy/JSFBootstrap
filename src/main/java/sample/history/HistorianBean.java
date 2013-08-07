package sample.history;

import sample.domain.Expression;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by  Alexey Gorovoy
 * Date:    30.07.13
 * Time:    12:41
 * Email:   alexey.gorovoy.work@gmail.com
 */
@ManagedBean
@ApplicationScoped
public class HistorianBean {
    @EJB
    Historian historian;

    public List<Expression> getHistory(){
        return historian.getHistory();
    }
    public void addEntry(Expression exp) {
        historian.addEntry(exp);
    }

    public List<String> getHistoryStrings() {
        List<String> list = new LinkedList<String>();
        for (Expression exp : historian.getHistory()) {
            list.add(exp.toString());
        }
        return list;
    }
}
