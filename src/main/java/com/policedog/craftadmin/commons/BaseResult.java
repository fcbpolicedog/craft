package com.policedog.craftadmin.commons;

public class BaseResult {
    public static final int STATUS_SUCCESS = 200;
    public static final int STAUS_FAIL = 500;

    private int status;
    private String message;

    public static BaseResult success(){
        return BaseResult.createResuylt(STATUS_SUCCESS,"成功");
    }

    public static BaseResult success(String message){
        return BaseResult.createResuylt(STATUS_SUCCESS,message);

    }

    public static BaseResult fail(){
        return BaseResult.createResuylt(STAUS_FAIL,"失败");
    }

    public static BaseResult fail(String message){
        return BaseResult.createResuylt(STAUS_FAIL,message);
    }

    public static BaseResult fail(int status,String message){
        return BaseResult.createResuylt(status,message);
    }
    private static BaseResult createResuylt(int status,String message){
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return baseResult;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
