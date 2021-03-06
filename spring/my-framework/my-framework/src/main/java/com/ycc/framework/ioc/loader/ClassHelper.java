package com.ycc.framework.ioc.loader;

import com.ycc.framework.mvc.annotation.Controller;
import com.ycc.framework.mvc.annotation.Service;
import com.ycc.framework.ioc.configure.ConfigHelper;

import java.util.HashSet;
import java.util.Set;

/**
 * Get the set of the class by the annotation.
 *
 * @see com.ycc.framework.ioc.annotation
 *
 * created by ycc at 2018\4\23 0023
 */
public class ClassHelper {

    public static Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        for (Class<?> clazz : CLASS_SET) {
            if (clazz.isAnnotationPresent(Controller.class)) {
                classes.add(clazz);
            }
        }
        return classes;
    }

    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        for (Class<?> clazz : CLASS_SET) {
            if (clazz.isAnnotationPresent(Service.class)) {
                classes.add(clazz);
            }
        }
        return classes;
    }

    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.addAll(getControllerClassSet());
        classes.addAll(getServiceClassSet());
        return classes;
    }

}
