package com.example.demotest.service;

import com.example.demotest.dto.UserDTO;
import com.example.demotest.entity.User;
import com.example.demotest.repositor.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;
    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;

    }
    public List<UserDTO> getAllUsers(){
        List<User>userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO  updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }

    public UserDTO getUserByUserID(String userId){
        User user = userRepo.getUserByUserID(userId);
        return modelMapper.map(user, UserDTO.class);

    }

    public UserDTO getUserByUserIDandAddress(String userId, String address){
        User user = userRepo.getUserByUserIDandAddress(userId, address);
        return modelMapper.map(user, UserDTO.class);

    }
}
