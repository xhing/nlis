package com.sinosoft.nlis.base.http;

import lombok.Data;
/**
 * http请求头.
 * 
 * @author caoxinli
 */

@Data
public class BaseHeader {

    private String code;

    private boolean success;

    private String message;

}
