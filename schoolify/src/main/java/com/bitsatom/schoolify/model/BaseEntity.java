package com.bitsatom.schoolify.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import lombok.Getter;
import lombok.ToString;

@ToString
public class BaseEntity {
	@Getter
	@Column(name = "creation_time", nullable = false)
	private Date creationTime;

	@Getter
	@Column(name = "modification_time", nullable = false)
	private Date modificationTime;

	@Getter
	@Version
	private long version = 0;

	@PreUpdate
	public void preUpdate() {
		modificationTime = new Date();
	}

	@PrePersist
	public void prePersist() {
		Date now = new Date();
		creationTime = now;
		modificationTime = now;
	}
}
