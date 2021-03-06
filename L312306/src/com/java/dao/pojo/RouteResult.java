package com.java.dao.pojo;

import java.io.Serializable;

import hibernate.Route;

public class RouteResult implements Serializable{

	private Route start ;
	private Route end;
	
	public RouteResult() {
		super();
	}
	public RouteResult(Route start, Route end) {
		super();
		this.start = start;
		this.end = end;
	}
	public Route getStart() {
		return start;
	}
	public void setStart(Route start) {
		this.start = start;
	}
	public Route getEnd() {
		return end;
	}
	public void setEnd(Route end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "RouteResult [start=" + start + ", end=" + end + "]";
	}
}
