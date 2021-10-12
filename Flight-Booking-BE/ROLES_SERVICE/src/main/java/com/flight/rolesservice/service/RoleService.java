package com.flight.rolesservice.service;

import com.flight.rolesservice.dao.RoleDao;
import com.flight.rolesservice.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
