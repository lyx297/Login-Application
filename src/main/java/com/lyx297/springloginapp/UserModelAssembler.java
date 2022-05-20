package com.lyx297.springloginapp;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.lyx297.springloginapp.controllers.UserController;
import com.lyx297.springloginapp.entity.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public
class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

    @Override
    public EntityModel<User> toModel(User user) {

        return EntityModel.of(user,
                linkTo(methodOn(UserController.class).one(user.getUserId())).withSelfRel(),
                linkTo(methodOn(UserController.class).all()).withRel("users"));
    }
}