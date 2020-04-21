package com.spring.mvc.service;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.Locale;

@Service
public class HelloService {

    public String hi() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes) requestAttributes;
        Locale locale = LocaleContextHolder.getLocale();
        return "success";
    }
}
