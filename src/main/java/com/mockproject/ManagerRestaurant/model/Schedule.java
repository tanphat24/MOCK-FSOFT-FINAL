package com.mockproject.ManagerRestaurant.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
//@Data
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scheduleId;
	
	@Column(name = "SCHEDULE_TIMESTART")
	private Date scheduleTimeStart;
	
	@Column(name = "SCHEDULE_TIMEEND")
	private Date scheduleTimeEnd;

	public Schedule(int scheduleId, Date scheduleTimeStart, Date scheduleTimeEnd) {
		super();
		this.scheduleId = scheduleId;
		this.scheduleTimeStart = scheduleTimeStart;
		this.scheduleTimeEnd = scheduleTimeEnd;
	}

	public Schedule() {
		super();
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Date getScheduleTimeStart() {
		return scheduleTimeStart;
	}

	public void setScheduleTimeStart(Date scheduleTimeStart) {
		this.scheduleTimeStart = scheduleTimeStart;
	}

	public Date getScheduleTimeEnd() {
		return scheduleTimeEnd;
	}

	public void setScheduleTimeEnd(Date scheduleTimeEnd) {
		this.scheduleTimeEnd = scheduleTimeEnd;
	}

	public Schedule(Date scheduleTimeStart) {
		this.scheduleTimeStart = scheduleTimeStart;
	}
	
}
