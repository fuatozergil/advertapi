package com.poc.ilanapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "advertHistory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertHistory {

	public AdvertHistory(long advertId, @Size(min = 20, max = 200) String content, String status, int active,
			int duplicate, int updater, long version) {
		super();
		this.advertId = advertId;
		this.content = content;
		this.status = status;
		this.active = active;
		this.duplicate = duplicate;
		this.updater = updater;
		this.version = version;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "advert_id")
	private long  advertId;

	@Size(min = 20, max = 200)
	@Column(name = "content")
	private String content;

	@Column(name = "status")
	private String status;

	@Column(name = "Active")
	private int active;

	@Column(name = "Duplicate")
	private int duplicate;

	@Column(name = "Updater")
	private int updater;

	@Column(name = "VERSION")
	private long version;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date creationDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;

}
