package com.medialog.medialog.service;

import com.medialog.medialog.User.Role;
import com.medialog.medialog.User.User;
import com.medialog.medialog.User.UserDto;
import com.medialog.medialog.repository.RoleRepository;
import com.medialog.medialog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(user.getEmail());
        // spring security lets us encrypt data
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // check if admin role
        Role role = roleRepository.findByName("ROLE_ADMIN");

        if(role==null){
            role = createAdminRoleIfNotPresent();
        }
        // need to return to this later. Otherwise, all roles are admin roles
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }


    public User findUserByEmail(String email){
        return  userRepository.findByEmail(email);
    }

    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> mapToUserDto(user)).collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role createAdminRoleIfNotPresent(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return  roleRepository.save(role);
    }


}
