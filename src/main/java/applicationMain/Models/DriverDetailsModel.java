package applicationMain.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;


@Entity
@Table(name = "driver_details")
@TypeDef(name="jsonb", typeClass = JsonBinaryType.class)
public class DriverDetailsModel extends BaseModel implements Serializable {

	@Column(name = "name", nullable = false, updatable = true)
	@NotEmpty(message = "name required")
	private String name;

	@Column(name = "liscense_no", nullable = false)
	@NotEmpty(message = "liscense no required")
	private String LiscenseNo;

	@Column(name = "identity_no", nullable = false)
	@NotEmpty(message = "identification number required")
	private String identityNo;

	@Column(name = "contact_no", nullable = false, updatable = true)
	@NotEmpty(message = "required mobile number")
	@Size(min = 10, max = 12, message = "phone number must be atleast 10 digits long")
	private String contactNo;
	
	
    @Column(name="live_adderss", nullable = true, updatable = true, columnDefinition = "jsonb")
    @Type(type = "jsonb")
	private AddressBean liveAddress;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	@JsonIgnoreProperties("id")
	private TruckDetailsModel truck;

	@Column(name = "is_avabilable", nullable = false)
	private Boolean isAvailable;

	public DriverDetailsModel(@NotEmpty(message = "name required") String name,
			@NotEmpty(message = "liscense no required") String liscenseNo,
			@NotEmpty(message = "identification number required") String identityNo,
			@NotEmpty(message = "required mobile number") @Size(min = 10, max = 12, message = "phone number must be atleast 10 digits long") String contactNo,
			AddressBean liveAddress, TruckDetailsModel truck, Boolean isAvailable) {
		super();
		this.name = name;
		LiscenseNo = liscenseNo;
		this.identityNo = identityNo;
		this.contactNo = contactNo;
		this.liveAddress = liveAddress;
		this.truck = truck;
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "DriverDetailsModel [name=" + name + ", LiscenseNo=" + LiscenseNo + ", identityNo=" + identityNo
				+ ", contactNo=" + contactNo + ", liveAddress=" + liveAddress + ", truck=" + truck + ", isAvailable="
				+ isAvailable + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLiscenseNo() {
		return LiscenseNo;
	}

	public void setLiscenseNo(String liscenseNo) {
		LiscenseNo = liscenseNo;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public AddressBean getLiveAddress() {
		return liveAddress;
	}

	public void setLiveAddress(AddressBean liveAddress) {
		this.liveAddress = liveAddress;
	}

	public TruckDetailsModel getTruck() {
		return truck;
	}

	public void setTruck(TruckDetailsModel truck) {
		this.truck = truck;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	

}
