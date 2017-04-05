package stadheim.eirik.persistence.dao.impl;

import org.springframework.stereotype.Repository;
import stadheim.eirik.persistence.dao.IMealProductDao;
import stadheim.eirik.persistence.dao.common.AbstractHibernateDao;
import stadheim.eirik.persistence.model.MealProduct;

@Repository
public class MealProductDao extends AbstractHibernateDao<MealProduct> implements IMealProductDao {

    public MealProductDao() {
        super();

        setClazz(MealProduct.class);
    }

    // API

}
