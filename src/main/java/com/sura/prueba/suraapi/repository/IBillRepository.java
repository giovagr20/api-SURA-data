package com.sura.prueba.suraapi.repository;

import com.sura.prueba.suraapi.model.BillsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends CrudRepository<BillsModel, Integer> {

}