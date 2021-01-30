package com.GameAdministration.Exception;


/**
 * 
 * @author YP
 * @Description: 全局异常处理
 * @param:  
 * @date:     2021年1月27日下午3:30:27
 * 
 */
public class ApplicationException extends RuntimeException{

	private static final long serialVersionUID = 8781576190677734099L;
	private ErrorCode errorCode;
	
    public ApplicationException(ErrorCode errorCode){
        super(formatMsg(errorCode));
        this.errorCode = errorCode;
    }

    public ApplicationException(ErrorCode errorCode,Throwable cause){
        this.errorCode = errorCode;
    }

    private static String formatMsg(ErrorCode errorCode) {
        return errorCode.getMessage();
    }

    public String code(){
        return errorCode.getCode();
    }

    public String message(){
        return errorCode.getMessage();
    }
	
}
