package applicationMain.Models;

import java.io.Serializable;

public class AddressBean implements Serializable{

	private String houseNo;
	private String streetName;
	private String areaName;
	private String cityName;
	private String country;
	private String State;
	private String pinCode;

	public AddressBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AddressBean [houseNo=" + houseNo + ", streetName=" + streetName + ", areaName=" + areaName
				+ ", cityName=" + cityName + ", country=" + country + ", State=" + State + ", pinCode=" + pinCode + "]";
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

}
