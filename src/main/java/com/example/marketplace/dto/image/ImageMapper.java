package com.example.marketplace.dto.image;

import com.example.marketplace.models.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class ImageMapper {
    public abstract ImageDto toDto(Image image);

    @Mapping(target = "id", ignore = true)
    public abstract Image toEntity(ImageDto imageDto);
}

