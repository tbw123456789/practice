package cn.medigical.publish.utils;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author sky
 */

@Configuration
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        ctx = applicationContext;
    }


    /**
     * 根据指定Bean类型，获取对应的实例对象
     * @Title: getBean
     * @Description: TODO
     * @param requiredType	bean的class类型
     * @return
     * @throws BeansException
     * @author guonl
     */
    public static <T> T getBean(Class<T> requiredType) throws BeansException {
        if (ctx == null) {
            throw new RuntimeException("spring 上下文对象未初始化，无法完成bean的查找！");
        }
        return ctx.getBean(requiredType);
    }

    /**
     * 根据指定bean名称，获取对应的实例对象
     * @param name bean的名称
     * @return 对应bean的实例对象
     */
    public static Object getBean(String name) throws BeansException {
        if (ctx == null) {
            throw new RuntimeException("spring 上下文对象未初始化，无法完成bean的查找！");
        }

        return ctx.getBean(name);
    }

    /**
     * @return the ctx
     */
    public static ApplicationContext getApplicationContext() {
        return ctx;
    }
}