package com.project.tgdd_be.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerDTO {
		
		private Integer manufacturerId;
		@NotEmpty(message = "Manufacturer name can not be empty")
		private String manufacturerName;
		
		private Boolean status;
}
