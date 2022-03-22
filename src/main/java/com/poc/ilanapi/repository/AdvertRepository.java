package com.poc.ilanapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poc.ilanapi.model.Advert;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {

	@Query(value = "SELECT SUM(CASE WHEN ad.active >= 1 THEN 1 ELSE 0 END) as Aktifler,SUM(CASE WHEN ad.active = 0 THEN 1 ELSE 0 END) as Deaktifler FROM Advert ad")
	String getAdvertStatusStatistics();


	@Query(value = "SELECT count (a) FROM Advert a where a.category.id = :#{#advert.category.id} and a.header = :#{#advert.header} and a.content = :#{#advert.content}")
	int checkDuplicateOfAdvert(@Param("advert") Advert advert);

}
