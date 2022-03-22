package com.poc.ilanapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.ilanapi.model.Advert;
import com.poc.ilanapi.model.AdvertHistory;
import com.poc.ilanapi.services.AdvertService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author fuatozergil
 *
 */
@RestController
@RequestMapping(path = "/advert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Advert Crud")
public class AdvertController {


	@Autowired
	AdvertService advertService;

	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "creates advert")
	public ResponseEntity<Advert> createAdvert(@RequestBody Advert advert) {
		return ResponseEntity.ok(advertService.createAdvert(advert));
	}

	@PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "updates advert")
	public ResponseEntity<Advert> updateAdvert(@RequestBody Advert advert) {
		return ResponseEntity.ok(advertService.updateAdvert(advert));
	}

	@PostMapping(path = "/updateStatus", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "updates adverts status")
	public ResponseEntity<Advert> updateAdvertStatus(@RequestParam long advertId, @RequestParam String status) {
		return ResponseEntity.ok(advertService.updateAdvertStatus(advertId, status));
	}

	@GetMapping(path = "/getAdvertHistory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get adverts historical changes")
	public ResponseEntity<List<AdvertHistory>> getAdvertHistory(@RequestParam long advertId) {
		return ResponseEntity.ok(advertService.getAdvertHistory(advertId));
	}

}
