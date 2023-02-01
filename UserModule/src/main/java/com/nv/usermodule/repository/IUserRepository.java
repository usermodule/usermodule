package com.nv.usermodule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nv.usermodule.entity.Address;
import com.nv.usermodule.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{

	
}
