package stadheim.eirik.api.controllers;

import org.hibernate.HibernateException;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import stadheim.eirik.api.dto.UserDto;
import stadheim.eirik.beans.BeanConfig;
import stadheim.eirik.persistence.model.User;
import stadheim.eirik.persistence.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by eirikstadheim on 22/03/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IUserService userService;

    @Autowired
    private BeanConfig.User sessionUser;

    @RequestMapping(method = RequestMethod.POST)
    public HttpStatus registerUser(@RequestBody UserDto user) {
        try {
            userService.create(new User(user.getUsername()));
        }
        catch(Exception e) {
            sessionUser.setUsername(user.getUsername());
            return HttpStatus.FOUND;
        }
        sessionUser.setUsername(user.getUsername());
        return HttpStatus.CREATED;
    }
}