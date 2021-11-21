package com.mycompany.desctopapp_publishing_6.license;

import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License, Integer> {
    public Long countById(Integer id);
}
