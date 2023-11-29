package org.ht.rpg.game.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

@Component
public class CustomResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object response;
    private String msg;

    private String detail;

    public CustomResponse() {
    }

    public CustomResponse(Object response, String msg, String detail) {
        this.response = response;
        this.msg = msg;
        this.detail = detail;
    }

    public Object getResponse() {
        return response;
    }


    public void setResponse(Object response) {
        this.response = response;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
