package com.sura.prueba.suraapi.repository;

import com.sura.prueba.suraapi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Integer> {
}
