package com.uep.wap.service;

import com.uep.wap.MyUserPrincipal;
import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.Address;
import com.uep.wap.model.User;
import com.uep.wap.repository.AddressRepository;
import com.uep.wap.repository.RoleRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AddressRepository addressRepository;

    public void addUser(UserDTO userDTO){

        Address address = new Address();
        address.setCity(userDTO.getAddress().getCity());
        address.setPostal_code(userDTO.getAddress().getPostal_code());
        address.setStreet(userDTO.getAddress().getStreet());
        addressRepository.save(address);

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(roleRepository.findById(2L).get());
        user.setAddress(address);


        userRepository.save(user);
        System.out.println("user added!");
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return new MyUserPrincipal(user);
        }
        return null;
    }

    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }
}
