package com.wangcr.kk.util;

import com.wangcr.kk.common.ResultList;

/**
 * @author wangcr
 * 结果集返回工具类
 */
public class ResultListUtil {
    /**
     * 默认成功返回
     * @param object
     * @return
     */
    public static ResultList success(Object object){
        ResultList result = new ResultList();
        result.setCode(200);
        result.setMessage("SUCCESS");
        result.setData(object);
        return result;
    }

    /**
     * 成功返回
     * @param Code
     * @param Message
     * @return
     */
    public static ResultList success(Integer Code ,String Message){
        ResultList result = new ResultList();
        result.setCode(Code);
        result.setMessage("SUCCESS Message:"+Message);
        return result;
    }

    /**
     * 错误返回
     * @param Code
     * @param Message
     * @return
     */
    public static ResultList error(Integer Code, String Message){
        ResultList result = new ResultList();
        result.setCode(Code);
        result.setMessage("ERROR Message:"+Message);
        return result;
    }

}
