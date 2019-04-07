package com.arslanyakup.dto;

import java.io.Serializable;

public class AdvancedFilterRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	// 7d filter active
	private Boolean percentChange7d;
	// etc. %x
	private Integer percentage7d;
	// type loss or profit
	private String percentType7d;

	// 1d filter active
	private Boolean percentChange1d;
	// etc. %x
	private Integer percentage1d;
	// type loss or profit
	private String percentType1d;

	// 1h filter active
	private Boolean percentChange1h;
	// etc. %x
	private Integer percentage1h;
	// type loss or profit
	private String percentType1h;

	public Boolean getPercentChange7d() {
		return percentChange7d;
	}

	public void setPercentChange7d(Boolean percentChange7d) {
		this.percentChange7d = percentChange7d;
	}

	public Integer getPercentage7d() {
		return percentage7d;
	}

	public void setPercentage7d(Integer percentage7d) {
		this.percentage7d = percentage7d;
	}

	public String getPercentType7d() {
		return percentType7d;
	}

	public void setPercentType7d(String percentType7d) {
		this.percentType7d = percentType7d;
	}

	public Boolean getPercentChange1d() {
		return percentChange1d;
	}

	public void setPercentChange1d(Boolean percentChange1d) {
		this.percentChange1d = percentChange1d;
	}

	public Integer getPercentage1d() {
		return percentage1d;
	}

	public void setPercentage1d(Integer percentage1d) {
		this.percentage1d = percentage1d;
	}

	public String getPercentType1d() {
		return percentType1d;
	}

	public void setPercentType1d(String percentType1d) {
		this.percentType1d = percentType1d;
	}

	public Boolean getPercentChange1h() {
		return percentChange1h;
	}

	public void setPercentChange1h(Boolean percentChange1h) {
		this.percentChange1h = percentChange1h;
	}

	public Integer getPercentage1h() {
		return percentage1h;
	}

	public void setPercentage1h(Integer percentage1h) {
		this.percentage1h = percentage1h;
	}

	public String getPercentType1h() {
		return percentType1h;
	}

	public void setPercentType1h(String percentType1h) {
		this.percentType1h = percentType1h;
	}

}
