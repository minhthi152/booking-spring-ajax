package com.tp.service.user;

import com.tp.model.User;
import com.tp.model.dto.UserDTO;
import com.tp.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User getByUsername(String username);

    Optional<User> findByUsername(String username);

    Optional<UserDTO> findUserDTOByUsername(String username);
}

