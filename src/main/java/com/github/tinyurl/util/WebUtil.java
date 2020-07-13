package com.github.tinyurl.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 * spring web工具类
 *
 * @author errorfatal89@gmail.com
 * @date 2020/07/13
 */
public class WebUtil {

    public static void printJson(HttpServletResponse response, Object o) {
        String result = JSON.toJSONString(o);
        try (OutputStream os = response.getOutputStream();
             Writer out = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            out.write(result);
            out.flush();
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
