package com.pgs.soft.workshop.backend.model;

import java.io.Serializable;

abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = -5011563683700188680L;
	
	private static long SEQ = 0;

	public AbstractModel() {
		super();
		this.id = ++SEQ;
	}

	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
