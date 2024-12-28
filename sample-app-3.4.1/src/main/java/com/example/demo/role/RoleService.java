package com.example.demo.role;

import com.example.demo.user.UserMapper;
import com.example.demo.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

RoleRepository roleRepository;

    public RoleDTO findById(Long id) {
        Optional<RoleEntity> entity = roleRepository.findById(id);
        if(entity.isPresent()){
            return RoleMapper.INSTANCE.buildDTO(entity.get());
        }
        throw new RuntimeException("User Not Found.");
    }
}
