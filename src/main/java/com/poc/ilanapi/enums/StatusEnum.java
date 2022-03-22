package com.poc.ilanapi.enums;

public enum StatusEnum {

	ONAY_BEKLIYOR("Onay Bekliyor"), AKTIF("Aktif"), DEAKTIF("Deaktif");

	private String detail;

	StatusEnum(String detail) {
		this.detail = detail;
	}

	public String getDetail() {
		return detail;
	}

}
