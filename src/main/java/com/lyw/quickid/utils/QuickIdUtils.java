package com.lyw.quickid.utils;

import com.lyw.quickid.core.QuickId;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuickIdUtils implements ApplicationContextAware {

    private static QuickId quickId = null;

    @Override
    public void setApplicationContext(ApplicationContext arg) throws BeansException {
        if (quickId == null) {
            quickId = arg.getBean(QuickId.class);
        }
    }

    public static long next() {
        return quickId.next();
    }

}
