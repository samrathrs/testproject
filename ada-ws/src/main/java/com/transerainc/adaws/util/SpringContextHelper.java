/**
 *
 */
package com.transerainc.adaws.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author rajeev.lochanam
 */
@Component
public class SpringContextHelper implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(final ApplicationContext appContext) throws BeansException {
        SpringContextHelper.context = appContext;
    }

    public static <T> T getBean(final Class<T> paramClass) {
        if (context != null) {
            return context.getBean(paramClass);
        } else {
            return null;
        }

    }

}
