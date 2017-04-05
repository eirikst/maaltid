package stadheim.eirik.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stadheim.eirik.persistence.dao.IGroceryDao;
import stadheim.eirik.persistence.dao.IProductDao;
import stadheim.eirik.persistence.dao.common.IOperations;
import stadheim.eirik.persistence.model.Grocery;
import stadheim.eirik.persistence.model.Product;
import stadheim.eirik.persistence.service.IProductService;
import stadheim.eirik.persistence.service.common.AbstractService;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductService extends AbstractService<Product> implements IProductService {

    @Autowired
    private IProductDao dao;

    @Autowired
    private IGroceryDao groceryDao;

    public ProductService() {
        super();
    }

    // API

    @Override
    protected IOperations<Product> getDao() {
        return dao;
    }

    @Override
    public void create(Product entity) {
        //må fjerne groceries som kommer inn, da disse ikke skal genereres igjen
        Set<Grocery> tempGroceries = entity.getGroceries();
        entity.setGroceries(new HashSet<>());
        super.create(entity);

        for(Grocery tempGrocery: tempGroceries) {
            Grocery grocery = groceryDao.findOne(tempGrocery.getId());
            entity.getGroceries().add(grocery);

            grocery.getProducts().add(entity);
            groceryDao.update(grocery);
        }

        super.create(entity);
    }
}