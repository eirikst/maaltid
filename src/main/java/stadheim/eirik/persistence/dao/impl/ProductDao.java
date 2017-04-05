package stadheim.eirik.persistence.dao.impl;

import org.springframework.stereotype.Repository;
import stadheim.eirik.persistence.dao.IProductDao;
import stadheim.eirik.persistence.dao.common.AbstractHibernateDao;
import stadheim.eirik.persistence.model.Product;

@Repository
public class ProductDao extends AbstractHibernateDao<Product> implements IProductDao {

    public ProductDao() {
        super();

        setClazz(Product.class);
    }

    // API

}
