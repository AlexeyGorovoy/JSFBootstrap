package sample.history;

import sample.domain.Expression;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.persistence.*;
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
    private List list = new LinkedList<Expression>();

    @PersistenceUnit(name = "jpa_testUnit")
    private EntityManagerFactory entityManagerFactory;
    EntityManager em;

    @PostConstruct
    public void init() {
        em = entityManagerFactory.createEntityManager();
        Query q = em.createNamedQuery("getAll");
        list = q.getResultList();
    }

    public void addEntry(Expression exp) {
        em.persist(exp);
        list.clear();
        init();
    }

    @PreDestroy
    public void destroy() {
        em.close();
        list.clear();
    }

    @Override
    public List<Expression> getHistory() {
        List<Expression> expressionList = new LinkedList<Expression>();
        for (Object obj : list) {
            if (obj instanceof Expression)
            expressionList.add((Expression)obj);
        }
        return expressionList;
    }
}
