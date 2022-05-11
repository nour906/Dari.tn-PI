package tn.Dari.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.entities.VisitType;

import tn.Dari.entities.Visit;

@Repository
public interface VisiteRepository extends JpaRepository<Visit, Long> {
	
//	List<Visit> findByAnnouncementIdAnnouncementAndAnnouncementType(Long id_an, Type type);

//	List<Visit> findByAnnouncementIdAnnouncement(Long id_an);
	
	//List<Visit> findByDateCreationBetween(Date d1 , Date d2);

}
