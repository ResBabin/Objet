package com.kh.objet.visitedobjet.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class VisitedObjet implements Serializable {
	private static final long serialVersionUID = 18000L;
	
	private int objetno;
	private String userid;
	private Date visitdate;
	
	public VisitedObjet() {}

	public VisitedObjet(int objetno, String userid, Date visitdate) {
		super();
		this.objetno = objetno;
		this.userid = userid;
		this.visitdate = visitdate;
	}

	public int getObjetno() {
		return objetno;
	}

	public void setObjetno(int objetno) {
		this.objetno = objetno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getVisitdate() {
		return visitdate;
	}

	public void setVisitdate(Date visitdate) {
		this.visitdate = visitdate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "VisitedObjet [objetno=" + objetno + ", userid=" + userid + ", visitdate=" + visitdate + "]";
	}
	
	

}