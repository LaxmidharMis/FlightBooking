package com.flightapp.util;


public class Address {
	
	private String houseNo;
	private String laneNo;
	private String landMark;
	private String city;
	private String state;
	private String country;
	private Integer pinCode;
	
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getLaneNo() {
		return laneNo;
	}
	public void setLaneNo(String laneNo) {
		this.laneNo = laneNo;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getPinCode() {
		return pinCode;
	}
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address(String houseNo, String laneNo, String landMark, String city, String state, String country,
			Integer pinCode) {
		super();
		this.houseNo = houseNo;
		this.laneNo = laneNo;
		this.landMark = landMark;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
	}
	
	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", laneNo=" + laneNo + ", landMark=" + landMark + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", pinCode=" + pinCode + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((houseNo == null) ? 0 : houseNo.hashCode());
		result = prime * result + ((landMark == null) ? 0 : landMark.hashCode());
		result = prime * result + ((laneNo == null) ? 0 : laneNo.hashCode());
		result = prime * result + ((pinCode == null) ? 0 : pinCode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	} 
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (houseNo == null) {
			if (other.houseNo != null)
				return false;
		} else if (!houseNo.equals(other.houseNo))
			return false;
		if (landMark == null) {
			if (other.landMark != null)
				return false;
		} else if (!landMark.equals(other.landMark))
			return false;
		if (laneNo == null) {
			if (other.laneNo != null)
				return false;
		} else if (!laneNo.equals(other.laneNo))
			return false;
		if (pinCode == null) {
			if (other.pinCode != null)
				return false;
		} else if (!pinCode.equals(other.pinCode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	
	

}
