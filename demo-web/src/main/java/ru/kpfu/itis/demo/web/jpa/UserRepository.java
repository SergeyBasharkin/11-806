package ru.kpfu.itis.demo.web.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.demo.web.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
