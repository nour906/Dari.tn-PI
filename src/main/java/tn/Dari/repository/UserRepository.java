package tn.Dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import tn.Dari.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
 
}
