package com.omniwyse.redshiftpoc.repository;

import org.springframework.data.repository.CrudRepository;

import com.omniwyse.redshiftpoc.models.FileDemo;

public interface Filerepository extends CrudRepository<FileDemo, Long> {


}
