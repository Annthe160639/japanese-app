package com.prm.japaneseapp.model.response;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ResponseFactoryCustom {
    public ResponseEntity<Object> success(Object data, Class<?> clazz) {
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        ResponseStatus responseStatus = new ResponseStatus(ResponseStatusCode.SUCCESS);
        responseObject.setStatus(responseStatus);
        if (data instanceof Collection collection) {
            responseObject.setData(collection.stream().toList());
        } else {
            responseObject.setData(clazz.cast(data));
        }
        return ResponseEntity.ok(responseObject);
    }

    public ResponseEntity<Object> successDetail(DetailResponse<Object> data) {
        return ResponseEntity.ok(data);
    }

    public ResponseEntity<Object> fail(ResponseStatusCode responseStatusEnum) {
        ResponseNoBody responseObject = new ResponseNoBody();
        ResponseStatus responseStatus = new ResponseStatus(responseStatusEnum);
        responseObject.setStatus(responseStatus);
        return ResponseEntity.status(responseStatusEnum.getHttpCode()).body(responseObject);
    }
}
