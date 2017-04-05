package stadheim.eirik.persistence.service.impl;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stadheim.eirik.persistence.dao.IGroceryDao;
import stadheim.eirik.persistence.dao.common.IOperations;
import stadheim.eirik.persistence.model.Grocery;
import stadheim.eirik.persistence.service.IGroceryService;
import stadheim.eirik.persistence.service.common.AbstractService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class GroceryService extends AbstractService<Grocery> implements IGroceryService {

    public static final Set<String> allergens = new HashSet<String>
            (Arrays.asList("Gluten", "Melk", "Hvete", "Soya", "Nøtter", "Selleri"));

    @Autowired
    private IGroceryDao dao;

    public GroceryService() {
        super();
    }

    // API

    @Override
    protected IOperations<Grocery> getDao() {
        return dao;
    }

    @Override
    public void create(Grocery entity) {
        for(String allergen: entity.getAllergens()) {
            if(!allergens.contains(allergen)) {
                throw new HibernateException("Name of allergen " + " 'allergen' " + " not valid");
            }
        }

        super.create(entity);
    }
}