package stadheim.eirik.persistence.dao.impl;

import org.springframework.stereotype.Repository;
import stadheim.eirik.persistence.dao.IMealDao;
import stadheim.eirik.persistence.dao.common.AbstractHibernateDao;
import stadheim.eirik.persistence.model.Meal;

@Repository
public class MealDao extends AbstractHibernateDao<Meal> implements IMealDao {

    public MealDao() {
        super();

        setClazz(Meal.class);
    }

    // API

}
