package com.patheon.chatty.model.mapper.impl;

import com.patheon.chatty.model.dto.BaseEntityDto;
import com.patheon.chatty.model.entity.BaseEntity;
import com.patheon.chatty.model.mapper.DtoConvertService;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BaseEntityMapper implements DtoConvertService<BaseEntityDto, BaseEntity> {

    @Override
    public BaseEntityDto toDto(BaseEntity entity) {
        return new BaseEntityDto(
                entity.getId(),
                entity.getCreated(),
                entity.getUpdated()
        );
    }

    @Override
    public List<BaseEntityDto> toDto(List<BaseEntity> entity) {
        return null;
    }
}
