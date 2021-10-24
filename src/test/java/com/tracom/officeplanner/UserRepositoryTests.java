//package com.tracom.officeplanner;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import com.tracom.officeplanner.Models.Role;
//import com.tracom.officeplanner.Models.User;
//import com.tracom.officeplanner.Repository.RoleRepository;
//import com.tracom.officeplanner.Repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class UserRepositoryTests {
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Test
//    public void testAddRoleToExistingUser() {
//        User user = userRepository.getUserById(1).get();
//        Role roleUser = roleRepository.getRoleByName("User");
//        Role roleOfficer= new Role(3);
//
//        user.addRole(roleUser);
//        user.addRole(roleOfficer);
//
//        User saveUser = userRepository.save(user);
//
//        assertThat(saveUser.getRoles().size()).isEqualTo(2);
//    }
//}
