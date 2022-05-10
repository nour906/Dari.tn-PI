package tn.Dari.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.Dari.entities.User;
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {
  Optional<User> findByEmail(String email);
	
  @Transactional
  @Modifying
  @Query("UPDATE User a " +
          "SET a.enabled = TRUE WHERE a.email = ?1")
  int enableUser(String email);
 
}
