package com.wangcr.kk.common;

import lombok.Data;

/**
 * @author wangcr
 * 结果集
 * @param <T>
 */
@Data
public class ResultList<T> {
    // 状态码
    private Integer code;
    // 信息
    private String message;
    // 数据
    private T data;


}
