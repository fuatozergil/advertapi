package com.poc.ilanapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poc.ilanapi.enums.StatusEnum;
import com.poc.ilanapi.model.Advert;
import com.poc.ilanapi.model.AdvertHistory;
import com.poc.ilanapi.model.Category;
import com.poc.ilanapi.repository.AdvertHistoryRepository;
import com.poc.ilanapi.repository.AdvertRepository;
import com.poc.ilanapi.repository.CategoryRepository;

@SpringBootTest
class TestAdvertServiceImpl {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	AdvertRepository advertRepository;
	
	@Autowired
	AdvertHistoryRepository advertHistoryRepository;

	@Test
	void testCreateAdvert() {

		List<Category> categoryList = categoryRepository.findAll();
		Category category = categoryList.stream().filter(c -> c.getCategory().equals("Emlak")).findFirst().orElse(null);

		Advert advert = new Advert(1, "", "", "", category, 1, 1, 1, 1, new Date(), new Date());

		assertNotNull(advertRepository.save(advert));
	}

	@Test
	void testGetAdvertById() {
		assertNotNull(advertRepository.getById(Long.valueOf(123)));
	}

	@Test
	void testGetAllAdvert() {
		assertNotNull(advertRepository.findAll());
	}

	@Test
	void testUpdateAdvertStatus() {
		
		Advert advert = advertRepository.getById(Long.valueOf(123));
		
		advert.setStatus(StatusEnum.AKTIF.getDetail());
		assertNotNull(advertRepository.save(advert));
	}

	@Test
	void testCreateAdvertHistory() {
		
		AdvertHistory advertHisory = new AdvertHistory(1,1, "", "", 1, 1, 1, 1, new Date(), new Date());
				
		assertNotNull(advertHistoryRepository.save(advertHisory));
	}

	@Test
	void testGetAdvertStatusStatistics() {
		assertNotNull(advertRepository.getAdvertStatusStatistics());
	}

}
