package com.nv.usermodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nv.usermodule.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{

	

}
