package com.zytx.init.exception;

public class NetWorkException extends Exception{

    //无参构造方法
    public NetWorkException(){

        super();
    }

    //有参的构造方法
    public NetWorkException(String message){
        super(message);

    }

    // 用指定的详细信息和原因构造一个新的异常
    public NetWorkException(String message, Throwable cause){

        super(message,cause);
    }

    //用指定原因构造一个新的异常
    public NetWorkException(Throwable cause) {

        super(cause);
    }

    public NetWorkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
