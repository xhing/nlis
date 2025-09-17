package com.sinosoft.nlis.base.http;

import java.io.Serializable;

import lombok.Data;

/**
 * http请求体.
 * 
 * @author caoxinli
 */
@Data
public class BaseRequest<T> implements Serializable {

    private String headers;
    
}
