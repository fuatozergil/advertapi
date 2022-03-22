package com.poc.ilanapi.services;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.ilanapi.enums.StatusEnum;
import com.poc.ilanapi.model.Advert;
import com.poc.ilanapi.model.AdvertHistory;
import com.poc.ilanapi.repository.AdvertHistoryRepository;
import com.poc.ilanapi.repository.AdvertRepository;
import com.poc.ilanapi.util.Util;

/**
 * @author fuatozergil
 *
 */
@Service
public class AdvertServiceImpl implements AdvertService {

	private static final Logger LOGGER = LogManager.getLogger(AdvertServiceImpl.class);

	@Autowired
	private AdvertRepository advertRepository;

	@Autowired
	private AdvertHistoryRepository advertHistoryRepository;

	@Override
	public Advert createAdvert(Advert advert) {

		Advert createdAdvert = null;
		boolean headerApproved = false;
		boolean advertApproved = false;
		boolean advertDublicated = false;

		try {
			if (Util.detectNotInBadWords(advert.getHeader()))
				headerApproved = true;

			if ((advert.getCategory() != null && advert.getCategory().getApproved()))
				advert.setStatus(StatusEnum.AKTIF.getDetail());
			else {
				advert.setStatus(StatusEnum.ONAY_BEKLIYOR.getDetail());
			}

			advertDublicated = checkDuplicateOfAdvert(advert);

			// TODO check all validations

			createdAdvert = advertRepository.save(advert);
		} catch (IOException e) {
			LOGGER.info("createAdvert exception : " + e);
		}

		AdvertHistory advertHistory = new AdvertHistory(createdAdvert.getId(), createdAdvert.getContent(),
				createdAdvert.getStatus(), createdAdvert.getActive(), createdAdvert.getDuplicate(),
				createdAdvert.getUpdater(), createdAdvert.getVersion());
		createAdvertHistory(advertHistory);

		return createdAdvert;
	}

	@Override
	public Advert getAdvertById(Long id) {
		return advertRepository.getById(id);
	}

	@Override
	public List<Advert> getAllAdvert() {
		return advertRepository.findAll();
	}

	@Override
	public Advert updateAdvertStatus(long advertId, String status) {

		Advert toUpdateAdvert = advertRepository.getById(advertId);

		if (StatusEnum.AKTIF.getDetail().equals(status)) {
			toUpdateAdvert.setActive(1);
		} else {
			toUpdateAdvert.setActive(0);
		}

		Advert updatedAdvert = null;

		toUpdateAdvert.setStatus(status);

		updatedAdvert = advertRepository.save(toUpdateAdvert);

		AdvertHistory advertHistory = new AdvertHistory(toUpdateAdvert.getId(), toUpdateAdvert.getContent(),
				toUpdateAdvert.getStatus(), toUpdateAdvert.getActive(), toUpdateAdvert.getDuplicate(),
				toUpdateAdvert.getUpdater(), toUpdateAdvert.getVersion());
		createAdvertHistory(advertHistory);

		return updatedAdvert;
	}

	@Override
	public AdvertHistory createAdvertHistory(AdvertHistory advertHistory) {
		return advertHistoryRepository.save(advertHistory);
	}

	@Override
	public String getAdvertStatusStatistics() {

		// TODO will be change with more effective
		String result = advertRepository.getAdvertStatusStatistics();

		String resultActives = "Aktifler :" + result.substring(0, result.indexOf(","));
		String resultDeactives = "Deaktifler :" + result.substring(result.indexOf(",") + 1);

		return resultActives + " " + resultDeactives;
	}

	@Override
	public boolean checkDuplicateOfAdvert(Advert advert) {
		return advertRepository.checkDuplicateOfAdvert(advert) >= 1 ? true : false;
	}

	@Override
	public Advert updateAdvert(Advert advert) {
		return advertRepository.save(advert);
	}

	@Override
	public List<AdvertHistory> getAdvertHistory(Long advertId) {

		return advertHistoryRepository.getAdvertHistory(advertId);
	}

}
