package tn.Dari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.Dari.entities.Visit;

import tn.Dari.entities.Type;

public interface VisitRepository extends JpaRepository<Visit, Long> {

	List<Visit> findByAnnouncementIdAnnouncementAndAnnouncementType(Long id_an, Type type);

	List<Visit> findByAnnouncementIdAnnouncement(Long id_an);
}
