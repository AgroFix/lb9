package com.mycompany.desctopapp_publishing_6.license;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenseService {
    @Autowired private LicenseRepository repo;

    public List<License> listAll(){
        return (List<License>) repo.findAll();

    }

    public void save(License license) {

        repo.save(license);
    }
    public License get(Integer id) throws LicenseNotFoundExceptionn {
        Optional<License> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
    throw new LicenseNotFoundExceptionn("Could not find any licenses with ID " + id);

    }
    public void delete(Integer id) throws LicenseNotFoundExceptionn {
        Long count = repo.countById(id);
        if (count == null || count == 0){
            throw new LicenseNotFoundExceptionn("Could not find any licenses with ID " + id);
        }
        repo.deleteById(id);
    }
}
