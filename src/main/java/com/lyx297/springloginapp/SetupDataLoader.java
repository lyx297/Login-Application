package com.lyx297.springloginapp;

import com.lyx297.springloginapp.entity.Role;
import com.lyx297.springloginapp.entity.User;
import com.lyx297.springloginapp.repository.RoleRepository;
import com.lyx297.springloginapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;

        createRoleIfNotFound("ROLE_ADMIN");
        createRoleIfNotFound("ROLE_MANAGER");
        createRoleIfNotFound("ROLE_USER");

        Role adminRole = roleRepository.findByRoleName("ROLE_ADMIN");
        Role managerRole = roleRepository.findByRoleName("ROLE_MANAGER");
        Role userRole = roleRepository.findByRoleName("ROLE_USER");
        Set<Role> adminRoleSet = new HashSet<>();
        adminRoleSet.add(adminRole);
        adminRoleSet.add(managerRole);
        adminRoleSet.add(userRole);

        Set<Role> managerRoleSet = new HashSet<>();
        managerRoleSet.add(managerRole);
        managerRoleSet.add(userRole);

        User admin = new User();
        admin.setName("Harry");
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin1"));
        admin.setRoles(adminRoleSet);
        userRepository.save(admin);

        User manager = new User();
        manager.setName("Hermione");
        manager.setUsername("manager");
        manager.setPassword(passwordEncoder.encode("manager1"));
        manager.setRoles(managerRoleSet);
        userRepository.save(manager);

        User user = new User();
        user.setName("Ron");
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user1"));
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    Role createRoleIfNotFound(String name) {

        Role role = roleRepository.findByRoleName(name);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);
        }
        return role;
    }
}
