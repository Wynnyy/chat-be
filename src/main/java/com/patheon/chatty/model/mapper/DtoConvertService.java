package com.patheon.chatty.model.mapper;

import java.util.List;

public interface DtoConvertService<T, D> {

    T toDto(D entity);
    List<T> toDto(List<D> entity);


}
