package com.plant.plant_backend.data.dtos;

public interface IMapEntities<TDto, TEntity> {

    TDto map(TEntity entity);
    TEntity mapToEntity(TDto tDto);
//    TEntity mapToEntityId(TDto tDto, Tid tid);
}
