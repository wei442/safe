package com.cloud.consumer.safe.rest.request.fastdfs;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FastdfsRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "文件url", required = true)
	@NotBlank(message = "文件url为空")
	private String fileUrl;

}