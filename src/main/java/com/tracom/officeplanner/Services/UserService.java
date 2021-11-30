package com.tracom.officeplanner.Services;

import com.tracom.officeplanner.Exceptions.UserNotFoundException;
import com.tracom.officeplanner.Models.Role;
import com.tracom.officeplanner.Models.User;
import com.tracom.officeplanner.Repository.RoleRepository;
import com.tracom.officeplanner.Repository.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JavaMailSender mailSender;

    public void register(User user, String siteURL)
    throws UnsupportedEncodingException, MessagingException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role roleUser =roleRepository.getRoleByName("ROLE_USER");
        user.addRole(roleUser);

        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        user.setEnabled(false);

        userRepository.save(user);

        sendVerificationEmail(user, siteURL);

    }
    private void sendVerificationEmail(User user, String siteURL)
        throws MessagingException, UnsupportedEncodingException{
        String toAddress =user.getEmail();
        String fromAddress ="officeplannertracom@gmail.com";
        String senderName= "OfficeMeeting Planner";
        String subject ="Please verify your registration";
        String mailContent ="<p>Dear [[name]],</p>";
            mailContent +="<p>Please click the link below to verify your registration:</p>";
        String verifyURL = siteURL+ "/verify?code=" +user.getVerificationCode();
                mailContent += "<h3><a href =\"" + verifyURL + "\">VERIFY</a></h3>";
               mailContent+= "<p>Thank you,<br> Office Planner Tracom. </p>";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper =new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        mailContent= mailContent.replace("[[name]]", user.getFirstname());

//        mailContent =mailContent.replace("[[URL]]", verifyURL);

        helper.setText(mailContent, true);

        mailSender.send(message);

    }


    public void saveUserWithDefaultRole(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role roleUser =roleRepository.getRoleByName("ROLE_USER");
        user.addRole(roleUser);
        userRepository.save(user);
    }

    public void save(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

    }
    public boolean verify(String verificationCode){
        User user = userRepository.findByVerificationCode(verificationCode);

        if(user==null || user.isEnabled()){
            return false;
        }else{
            userRepository.enable(user.getId());
//            userRepository.save(user);
            return true;
        }
    }


    //List
    public List<User> listUsers(){
        return userRepository.findAll();
    }
    //Deleting
    public void deleteUser(Integer user_id){
        userRepository.deleteById(user_id);
    }
    //Editing
    public User editUser(Integer user_id)
    {
        return userRepository.getUserById(user_id);
    }

    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    public User get(Integer id){
        return userRepository.getUserById(id);
    }

    public boolean isEmailUnique(String email) {
        User existUser = (User) userRepository.getUserByEmail(email);
        return existUser ==null;
    }

//    public User findOne(String email){
//        return userRepository.findOne(email);
//    }

    //Forgot Password Reset
    public void updateResetPasswordToken (String token, String email)
        throws UserNotFoundException {
        User user = (User) userRepository.getUserByEmail(email);
        if(user!=null){
           user.setResetPasswordToken(token);
           userRepository.save(user);
        }else{
            throw new UserNotFoundException("Could not find User with the email +email");
        }
    }
    public User getResetPasswordToken(String token){
        return userRepository.findByResetPasswordToken(token);
    }
    public void updatePasswordResetToken(User user,String email){
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        user.setResetPasswordToken(null);
        userRepository.save(user);
    }
}
