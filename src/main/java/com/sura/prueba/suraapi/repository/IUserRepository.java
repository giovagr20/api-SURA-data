package com.sura.prueba.suraapi.repository;

import com.sura.prueba.suraapi.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<UserModel, Integer> {
}
