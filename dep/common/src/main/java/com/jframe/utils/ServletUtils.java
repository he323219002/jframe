package com.jframe.utils;

import cn.hutool.extra.servlet.ServletUtil;
import com.alibaba.fastjson2.JSON;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Jimmy He
 * @Date: 2023/10/22 11:34
 * @Description: TODO 描述
 */
public class ServletUtils {

    /**
     * 返回 JSON 字符串
     *
     * @param response 响应
     * @param object 对象，会序列化成 JSON 字符串
     */
    @SuppressWarnings("deprecation") // 必须使用 APPLICATION_JSON_UTF8_VALUE，否则会乱码
    public static void writeJSON(HttpServletResponse response, Object object) {
        String content = JSON.toJSONString(object);
        ServletUtil.write(response, content, MediaType.APPLICATION_JSON_UTF8_VALUE);
    }

}
