package com.mall_of329.base;

import lombok.Data;

/**
 * @author huangRong
 * @date 2021/10/24 22:42
 */
@Data
public class BaseResponse<T> {
   private int code;
   private T data;
   private String message;

   public BaseResponse(int code, T data, String message) {
      this.code = code;
      this.data = data;
      this.message = message;
   }

}
