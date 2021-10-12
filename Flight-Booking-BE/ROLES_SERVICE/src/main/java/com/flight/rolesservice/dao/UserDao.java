package com.flight.rolesservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flight.rolesservice.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
