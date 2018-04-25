package com.blue.utils.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基类控制器
 *
 * @author lblue
 * @date 2018/4/25
 */
public class BaseController {
    protected Logger log = Logger.getLogger(this.getClass().getName());

    /**
     * 时间字符串格式化为date
     * @param binder
     */
    @InitBinder
    private void bindingPreparation(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
    }

    /**
     * 获取HttpSession
     * @return
     */
    protected HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 获取HttpServletResponse
     * @return
     */
    protected HttpServletRequest getRequest() {
        return getServletRequestAttributes().getRequest();
    }

    /**
     * 获取HttpServletResponse
     * @return
     */
    protected HttpServletResponse getResponse() {
        return getServletRequestAttributes().getResponse();
    }

    /**
     * 获取ServletRequestAttributes
     * @return
     */
    protected ServletRequestAttributes getServletRequestAttributes() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
    }
}
