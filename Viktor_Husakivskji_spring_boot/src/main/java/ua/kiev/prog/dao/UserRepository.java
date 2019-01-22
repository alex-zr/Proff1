package ua.kiev.prog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.prog.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{



}
