package com.poc.ilanapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poc.ilanapi.model.AdvertHistory;

@Repository
public interface AdvertHistoryRepository extends JpaRepository<AdvertHistory, Long> {
	@Query(value = "SELECT ad FROM AdvertHistory ad where ad.advertId = ?1")
	List<AdvertHistory> getAdvertHistory(Long advertId);

}
