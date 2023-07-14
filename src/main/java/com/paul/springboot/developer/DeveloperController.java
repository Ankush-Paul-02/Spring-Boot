package com.paul.springboot.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//? API LAYER
@RestController
@RequestMapping(path = "api/v1/developer")
public class DeveloperController {

    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    public List<Developer> getDeveloper() {
        return developerService.getDeveloper();
    }

    @PostMapping
    public void registerDeveloper(@RequestBody Developer developer) {
        developerService.addNewDeveloper(developer);
    }

    @DeleteMapping(path = "{id}")
    public void deleteDeveloper(@PathVariable("id") Long id) {
        developerService.deleteDeveloper(id);
    }

    @PutMapping(path = "{id}")
    public void updateDeveloper(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        developerService.updateDeveloper(id, name, email);
    }

}
