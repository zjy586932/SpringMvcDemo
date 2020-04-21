package com.spring.mvc.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletContext;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("/asyn")
public class AsynController {
    private static final String SUCCESS = "SUCCESS";
    private static final String ERROR = "ERROR";

    @GetMapping("/testAsyn")
    public Callable<String> testCallableAsyn() {
        System.out.println(Thread.currentThread().toString() + "-----main start---------");

        Callable<String> callable = () -> {
            System.out.println(Thread.currentThread().toString() + "-----testB start---------");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().toString() + "-----testB end---------");
            return SUCCESS;
        };

        System.out.println(Thread.currentThread().toString() + "-----main end---------");
        return callable;
    }

    @GetMapping("/testWebAsynTask")
    public WebAsyncTask<String> testWebAsynTask() {
        System.out.println(Thread.currentThread().toString() + "-----main start---------");
        Callable<String> callable = () -> {
            System.out.println(Thread.currentThread().toString() + "-----testB start---------");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().toString() + "-----testB end---------");
            return SUCCESS;
        };
        WebAsyncTask<String> webAsyncTask = new WebAsyncTask<String>(6000, callable);
        webAsyncTask.onCompletion(() -> {
            System.out.println("asyn complete");
        });
        webAsyncTask.onError(() -> {
            return ERROR;
        });

        webAsyncTask.onTimeout(() -> {
            return "timeout";
        });
        System.out.println(Thread.currentThread().toString() + "-----main end---------");
        return webAsyncTask;
    }

    final DeferredResult<String> deferredResult = new DeferredResult<>();

    @GetMapping("/testDeferredResult")
    public DeferredResult<String> testDeferredResult() {
        System.out.println(Thread.currentThread().toString() + "-----main start---------");

        Callable<String> callable = () -> {
            System.out.println(Thread.currentThread().toString() + "-----testB start---------");
            try {
                Thread.sleep(20000);
                deferredResult.setResult("success");
            } catch (InterruptedException e) {
                e.printStackTrace();
                deferredResult.setErrorResult("error");
            }
            System.out.println(Thread.currentThread().toString() + "-----testB end---------");
            return SUCCESS;
        };
        System.out.println(Thread.currentThread().toString() + "-----main end---------");
        return deferredResult;
    }

    @GetMapping("/getDeferredResult")
    public String getDeferredResult() {
        return deferredResult.getResult() == null ? "" : String.valueOf(deferredResult.getResult());
    }



}
