package tn.Dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {

}
