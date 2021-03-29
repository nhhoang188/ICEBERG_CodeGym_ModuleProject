package com.icebergsocialnetwork.services.user.Impl;

import com.icebergsocialnetwork.model.user.Role;
import com.icebergsocialnetwork.repository.user.RoleRepository;
import com.icebergsocialnetwork.services.user.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    RoleRepository repository;

    @Override
    public Page<Role> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Iterable<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return repository.findRoleById(id);
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Role findByName(String name) {
        return repository.findByName(name);
    }
}
