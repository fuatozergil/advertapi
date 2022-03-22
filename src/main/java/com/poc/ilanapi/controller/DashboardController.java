package com.poc.ilanapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.ilanapi.model.Advert;
import com.poc.ilanapi.services.AdvertService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author fuatozergil
 *
 */
@RestController
@RequestMapping(path = "/dashboard", consumes = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Advert Dashboard")
public class DashboardController { 
	@Autowired
	AdvertService advertService;

	@GetMapping(path = "/classifieds/statistics", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get statistics of status")
	public ResponseEntity<String> getAdvertStatistics(@RequestBody Advert advert) {
		return ResponseEntity.ok(advertService.getAdvertStatusStatistics());
	}
}
