package com.tp.service.role;


import com.tp.model.Role;
import com.tp.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}

