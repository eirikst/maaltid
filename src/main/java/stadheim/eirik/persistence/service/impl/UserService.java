package stadheim.eirik.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stadheim.eirik.persistence.dao.IUserDao;
import stadheim.eirik.persistence.dao.common.IOperations;
import stadheim.eirik.persistence.model.User;
import stadheim.eirik.persistence.service.IUserService;
import stadheim.eirik.persistence.service.common.AbstractService;

@Service
public class UserService extends AbstractService<User> implements IUserService {

    @Autowired
    private IUserDao dao;

    public UserService() {
        super();
    }

    // API

    @Override
    protected IOperations<User> getDao() {
        return dao;
    }

}