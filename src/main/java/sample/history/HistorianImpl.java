package sample.history;

import sample.domain.Expression;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by  Alexey Gorovoy
 * Date:    30.07.13
 * Time:    10:54
 * Email:   alexey.gorovoy.work@gmail.com
 */
@Stateful
public class HistorianImpl  implements Historian{
    private List<Expression> list = new LinkedList<Expression>();

    @PersistenceContext(name = "jpa_test")
    EntityManager em;

    @PostConstruct
    public void init() {
        Query q = em.createNamedQuery("getAll");
        list = (List<Expression>)q.getResultList();
    }

    public void addEntry(Expression exp) {
        list.add(exp);
        em.persist(exp);
    }

    @PreDestroy
    public void destroy() {
        em.close();
    }

    @Override
    public List<Expression> getHistory() {
        return list;
    }
}
