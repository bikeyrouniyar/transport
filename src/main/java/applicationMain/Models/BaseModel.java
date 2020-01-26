package applicationMain.Models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import io.swagger.annotations.ApiModelProperty;

@MappedSuperclass
public class BaseModel  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "automated generated id")
	@Column(name="id")
	private Long id;
	
	
	
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@Column(name="creation_date")
	private LocalDateTime creationDate;
	
	@UpdateTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime updatedTime;
	
	@Column(name="is_deleted")
	private Boolean isDeleted;

	public BaseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseModel(Long id, LocalDateTime creationDate, LocalDateTime updatedTime, Boolean isDeleted) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.updatedTime = updatedTime;
		this.isDeleted = isDeleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "BaseModel [id=" + id + ", creationDate=" + creationDate + ", updatedTime=" + updatedTime
				+ ", isDeleted=" + isDeleted + "]";
	}
	
	
	
	
	
	

}
