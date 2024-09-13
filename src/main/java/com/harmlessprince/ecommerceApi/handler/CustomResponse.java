package com.harmlessprince.ecommerceApi.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomResponse<T> {
    private T data;
    private String message;
    private boolean status;

    public CustomResponse(String message, boolean status) {
        this.status = status;
        this.message = message;
        this.data = null;
    }


    public static <T>  CustomResponse<T> sendSuccessResponse(T data, String message) {
        if (message.isEmpty()) {
            message = "Success";
        }
        CustomResponse<T> response = new CustomResponse<>(message, true);
        response.setData(data);
        return response;
    }
    public static <T> CustomResponse<T> sendErrorResponse(String message) {
        if (message.isEmpty()) {
            message = "An error has occurred";
        }
        CustomResponse<T> response = new CustomResponse<>(message, false);
        response.setData(null);
        return response;
    }
}
