package com.sinosoft.nlis.base.http;

import java.io.Serializable;

import lombok.Data;

/**
 * http响应体.
 * 
 * @author caoxinli
 */
@Data
public class BaseResponse<T> implements Serializable {
    
    private String headers;

}
