package com.dmved.spring.bpp;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TransactionBeanPostProcessor implements BeanPostProcessor {

    Map<String, Class<?>> transactionBeans = new HashMap<>();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().isAnnotationPresent(Transaction.class)){
            transactionBeans.put(beanName, bean.getClass());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = transactionBeans.get(beanName);
        if(beanClass != null){
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
                                          (proxy, method, args) ->{
                                              System.out.println("Open transaction");
                                              try{
                                                  return method.invoke(bean, args);
                                              } finally {
                                                  System.out.println("Close transaction");
                                              }
                                          });
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
