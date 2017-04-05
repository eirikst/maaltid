package stadheim.eirik.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stadheim.eirik.api.dto.UserDto;
import stadheim.eirik.persistence.model.User;
import stadheim.eirik.persistence.service.IUserService;

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

    @RequestMapping(method = RequestMethod.POST)
    public HttpStatus createUser(@RequestBody UserDto user) {
        userService.create(new User(user.getUsername()));

        return HttpStatus.CREATED;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> findUser(@PathVariable(value = "id") long id) {
        User user = userService.findOne(id);

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());

        return new ResponseEntity(userDto, HttpStatus.OK);
    }
}