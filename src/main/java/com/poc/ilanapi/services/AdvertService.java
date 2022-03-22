package com.poc.ilanapi.services;

import java.util.List;

import com.poc.ilanapi.model.Advert;
import com.poc.ilanapi.model.AdvertHistory;

/**
 * @author fuatozergil
 *
 */
public interface AdvertService {

	/**
	 * @param advert
	 * @return
	 */
	Advert createAdvert(Advert advert);

	/**
	 * @param id
	 * @return
	 */
	Advert getAdvertById(Long id);

	/**
	 * @return
	 */
	List<Advert> getAllAdvert();

	/**
	 * @return
	 */
	String getAdvertStatusStatistics();

	/**
	 * @param advertHistory
	 * @return
	 */
	AdvertHistory createAdvertHistory(AdvertHistory advertHistory);


	/**
	 * @param advert
	 * @return
	 */
	Advert updateAdvert(Advert advert);

	/**
	 * @param advert
	 * @return
	 */
	boolean checkDuplicateOfAdvert(Advert advert);

	/**
	 * @param advert
	 * @return
	 */
	List<AdvertHistory> getAdvertHistory(Long advertId);

	/**
	 * @param advertId
	 * @param status
	 * @return
	 */
	Advert updateAdvertStatus(long advertId, String status);
}
