package tn.Dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.Dari.entities.Agent;
import tn.Dari.entities.Announcement;

@Repository
public interface AnnouncementRepository extends CrudRepository<Announcement,Long> {
	
	Announcement findByidan(long id_an);

}
