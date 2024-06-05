package com.example.apfast.service;


import com.example.apfast.model.Role;
import com.example.apfast.repository.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleDAO roleDAO;

    public void addRole(Role role) {
        roleDAO.save(role);
    }

    public void updateRole(Role role) {
        roleDAO.save(role);
    }

    public void deleteRole(Long id) {
        roleDAO.deleteById(id);
    }

    public Role getRoleById(Long id) {
        return roleDAO.findById(id).orElse(null);
    }

    public List<Role> getAllRoles() {
        return roleDAO.findAll();
    }
}
