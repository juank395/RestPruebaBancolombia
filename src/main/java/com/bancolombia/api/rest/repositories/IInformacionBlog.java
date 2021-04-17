package com.bancolombia.api.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bancolombia.api.rest.entities.InformacionBlog;

@Repository
public interface IInformacionBlog extends JpaRepository<InformacionBlog, Long> {

}
