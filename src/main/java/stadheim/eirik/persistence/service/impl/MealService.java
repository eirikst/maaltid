package stadheim.eirik.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stadheim.eirik.persistence.dao.IMealDao;
import stadheim.eirik.persistence.dao.IMealProductDao;
import stadheim.eirik.persistence.dao.common.IOperations;
import stadheim.eirik.persistence.model.Meal;
import stadheim.eirik.persistence.model.MealProduct;
import stadheim.eirik.persistence.service.IMealService;
import stadheim.eirik.persistence.service.common.AbstractService;


@Service
public class MealService extends AbstractService<Meal> implements IMealService {

    @Autowired
    private IMealDao dao;

    @Autowired
    private IMealProductDao mealProductDao;

    public MealService() {
        super();
    }

    // API

    @Override
    protected IOperations<Meal> getDao() {
        return dao;
    }

    @Override
    public void create(Meal entity) {
        //ikke lagre grocery, fordi den alltid vil finnes
        //ikke lagre product, fordi den alltid vil finnes
        //lagre meal før mealproduct, fordi meal må finnes før den referes til
        super.create(entity);
        for(MealProduct mealProduct: entity.getMealProducts()) {
            mealProduct.setMeal(entity);
            mealProductDao.create(mealProduct);
        }
    }





    //Testing
    /*public void testCreate(Meal entity) {
        //super.create(meal);

        Grocery grocery = new Grocery();
        grocery.setName("Kylling");

        Product product = new Product();
        product.setName("Kyllinglår fra REMA");
        product.getGroceries().add(grocery);

        grocery.getProducts().add(product);

        Meal meal = new Meal();
        meal.setTime(new Date());

        MealProduct mealProduct = new MealProduct();
        mealProduct.setMeal(meal);
        mealProduct.setProduct(product);

        groceryDao.create(grocery);
        productDao.create(product);
        super.create(meal);
        mealProductDao.create(mealProduct);
    }*/
}