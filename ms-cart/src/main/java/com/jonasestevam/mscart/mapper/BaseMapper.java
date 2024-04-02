package com.jonasestevam.mscart.mapper;

import java.util.List;

public interface BaseMapper<D, E> {

    D toDto(E entity);

    E toEntity(D dto);

    List<D> toDto(List<E> entities);
}
