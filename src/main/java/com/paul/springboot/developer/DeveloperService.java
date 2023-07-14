package com.paul.springboot.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

//? SERVICE LAYER
@Service
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    @Autowired
    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public List<Developer> getDeveloper() {
        return developerRepository.findAll();
    }

    public void addNewDeveloper(Developer developer) {
        Optional<Developer> developerByEmail = developerRepository.findDeveloperByEmail(developer.getEmail());
        if (developerByEmail.isPresent()) {
            throw new IllegalStateException("Email is already in use!");
        }
        developerRepository.save(developer);
    }

    public void deleteDeveloper(Long id) {
        boolean isExist = developerRepository.existsById(id);
        if (!isExist) {
            throw new IllegalStateException("Student with id " + id + " doesn't exist!");
        }
        developerRepository.deleteById(id);
    }

    @Transactional
    public void updateDeveloper(Long id, String name, String email) {
        Developer developer = developerRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Student with id " + id + " doesn't exist!")
        );

        if (name != null && name.length() > 0 && !Objects.equals(developer.getName(), name)) {
            developer.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(developer.getEmail(), email)) {
            Optional<Developer> developerOptional = developerRepository.findDeveloperByEmail(email);
            if (developerOptional.isPresent()) {
                throw new IllegalStateException("Email is already in use!");
            }
            developer.setEmail(email);
        }
    }
}
