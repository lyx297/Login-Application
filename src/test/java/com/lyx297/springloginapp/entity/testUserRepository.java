package com.lyx297.springloginapp.entity;

import com.lyx297.springloginapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class testUserRepository {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateNewUser() {
        User user = new User();
        user.setName("namenamename");
        user.setUsername("asdflpoi123");
        user.setPassword("asdlTfkj234045u78!@#$");

        User savedUser = repo.save(user);
        User existsUser = entityManager.find(User.class, savedUser.getUserId());

        assertThat(user.getUsername()).isEqualTo(existsUser.getUsername());
    }

    @Test
    public void testFindByUsernameMethodIsWorking() {
        User user = new User();
        user.setName("testName");
        user.setUsername("test");
        user.setPassword("test1");

        repo.save(user);

        assertThat(repo.findByUsername("test").getUsername()).isEqualTo("test");
        assertThat(repo.findByUsername("test").getPassword()).isEqualTo("test1");
    }

}
