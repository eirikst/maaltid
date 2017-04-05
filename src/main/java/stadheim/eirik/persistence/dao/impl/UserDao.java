package stadheim.eirik.persistence.dao.impl;

import org.springframework.stereotype.Repository;
import stadheim.eirik.persistence.dao.common.AbstractHibernateDao;
import stadheim.eirik.persistence.dao.IUserDao;
import stadheim.eirik.persistence.model.User;

@Repository
public class UserDao extends AbstractHibernateDao<User> implements IUserDao {

    public UserDao() {
        super();

        setClazz(User.class);
    }

    // API

}
