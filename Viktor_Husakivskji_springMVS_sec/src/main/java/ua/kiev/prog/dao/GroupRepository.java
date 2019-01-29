package ua.kiev.prog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.prog.domain.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
