package com.techbellys.authentication.repository;

import com.techbellys.authentication.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    public AppUser findByUsername(String username);

    public AppUser findByEmail(String email);


}
