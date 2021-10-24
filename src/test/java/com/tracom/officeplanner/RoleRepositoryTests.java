package com.tracom.officeplanner;

import static org.assertj.core.api.Assertions.assertThat;
import com.tracom.officeplanner.Models.Role;
import com.tracom.officeplanner.Repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository repository;

    @Test
    public void testCreateRoles() {
        Role user = new Role("User");
        Role admin = new Role("Admin");
        Role officer = new Role("Officer");

        repository.saveAll(List.of(user, admin, officer));

        List<Role> listRoles = repository.findAll();

        assertThat(listRoles.size()).isEqualTo(3);
    }

}
