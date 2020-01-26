package applicationMain.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "vehicle_details")
@TypeDefs(@TypeDef(name = "AddressType", typeClass = AddressType.class))
public class TruckDetailsModel extends BaseModel implements Serializable {

	@Column(nullable = false, name = "owner_name", updatable = true)
	private String ownerName;

	@Column(name = "is_available", nullable = false)
	private Boolean isAvailable;

	@Column(name = "vehicle_model", nullable = false)
	@NotEmpty(message = "vehicle model should not be empty")
	private String vehicleModel;

	@Column(name = "vehicle_no", nullable = false)
	@NotEmpty(message = "vehicle number should not be empty")
	private String vehicleNo;

	@Column(name = "capacity", nullable = true)
	@ApiModelProperty(notes = "vehicle capacity for goods")
	private String capacity;

	@Column(name = "live_address", nullable = true, updatable = true, columnDefinition = "jsonb")
	@Type(type = "AddressType")
	private AddressBean liveAddress;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "id")
	@JoinColumn(name = "id_driver")
	@JsonIgnoreProperties("id")
	private DriverDetailsModel driver;



	public TruckDetailsModel(String ownerName, Boolean isAvailable,
			@NotEmpty(message = "vehicle model should not be empty") String vehicleModel,
			@NotEmpty(message = "vehicle number should not be empty") String vehicleNo, String capacity,
			AddressBean liveAddress, DriverDetailsModel driver) {
		super();
		this.ownerName = ownerName;
		this.isAvailable = isAvailable;
		this.vehicleModel = vehicleModel;
		this.vehicleNo = vehicleNo;
		this.capacity = capacity;
		this.liveAddress = liveAddress;
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "TruckDetailsModel [ownerName=" + ownerName + ", isAvailable=" + isAvailable + ", vehicleModel="
				+ vehicleModel + ", vehicleNo=" + vehicleNo + ", capacity=" + capacity + ", liveAddress=" + liveAddress
				+ ", driver=" + driver + "]";
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	

	public AddressBean getLiveAddress() {
		return liveAddress;
	}

	public void setLiveAddress(AddressBean liveAddress) {
		this.liveAddress = liveAddress;
	}

	public DriverDetailsModel getDriver() {
		return driver;
	}

	public void setDriver(DriverDetailsModel driver) {
		this.driver = driver;
	}
	
	

}
