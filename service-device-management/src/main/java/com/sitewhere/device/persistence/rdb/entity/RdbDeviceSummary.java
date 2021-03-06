/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.device.persistence.rdb.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.sitewhere.rdb.entities.RdbPersistentEntity;
import com.sitewhere.spi.device.IDeviceSummary;

@Entity
@Table(name = "device_summary")
public class RdbDeviceSummary extends RdbPersistentEntity implements IDeviceSummary {

    /** Serial version UID */
    private static final long serialVersionUID = -5098914785194194103L;

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "device_type_id", nullable = false)
    private UUID deviceTypeId;

    @Column(name = "device_type_name", nullable = false)
    private String deviceTypeName;

    @Column(name = "device_type_image_url", nullable = false)
    private String deviceTypeImageUrl;

    @Column(name = "parent_device_id", nullable = true)
    private UUID parentDeviceId;

    /** Comments */
    @Column(name = "comments")
    private String comments;

    /** Status indicator */
    @Column(name = "status")
    private String status;

    /** Zone bounds */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "device")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<RdbDeviceAssignmentSummary> deviceAssignmentSummaries = new ArrayList<>();

    @Transient
    private Map<String, String> metadata;

    public UUID getId() {
	return id;
    }

    public void setId(UUID id) {
	this.id = id;
    }

    public UUID getDeviceTypeId() {
	return deviceTypeId;
    }

    public void setDeviceTypeId(UUID deviceTypeId) {
	this.deviceTypeId = deviceTypeId;
    }

    public String getDeviceTypeName() {
	return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
	this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceTypeImageUrl() {
	return deviceTypeImageUrl;
    }

    public void setDeviceTypeImageUrl(String deviceTypeImageUrl) {
	this.deviceTypeImageUrl = deviceTypeImageUrl;
    }

    public UUID getParentDeviceId() {
	return parentDeviceId;
    }

    public void setParentDeviceId(UUID parentDeviceId) {
	this.parentDeviceId = parentDeviceId;
    }

    public String getComments() {
	return comments;
    }

    public void setComments(String comments) {
	this.comments = comments;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public List<RdbDeviceAssignmentSummary> getDeviceAssignmentSummaries() {
	return deviceAssignmentSummaries;
    }

    public void setDeviceAssignmentSummaries(List<RdbDeviceAssignmentSummary> deviceAssignmentSummaries) {
	this.deviceAssignmentSummaries = deviceAssignmentSummaries;
    }

    public Map<String, String> getMetadata() {
	return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
	this.metadata = metadata;
    }
}
