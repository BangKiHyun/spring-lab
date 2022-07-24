package com.lab.springlab.mockito.repository;

import com.lab.springlab.mockito.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
