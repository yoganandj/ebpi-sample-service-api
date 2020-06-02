package com.sample.platform.services.ebpi.hr.app.repositories;

import com.sample.platform.services.ebpi.hr.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByLogin(String login);

}
