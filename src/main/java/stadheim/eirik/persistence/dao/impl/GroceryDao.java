package stadheim.eirik.persistence.dao.impl;

import org.springframework.stereotype.Repository;
import stadheim.eirik.persistence.dao.IGroceryDao;
import stadheim.eirik.persistence.dao.common.AbstractHibernateDao;
import stadheim.eirik.persistence.model.Grocery;

@Repository
public class GroceryDao extends AbstractHibernateDao<Grocery> implements IGroceryDao {

    public GroceryDao() {
        super();

        setClazz(Grocery.class);
    }

    // API

}
