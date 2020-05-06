package ru.kpfu.itis.demo.blog.rest.mock;

import java.lang.reflect.Method;

public class DataHolder {
    private Method method;
    private Object[] args;
    private Object returnObject;

    public DataHolder(Method method, Object[] args, Object returnObject) {
        this.method = method;
        this.args = args;
        this.returnObject = returnObject;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Object getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }
}
