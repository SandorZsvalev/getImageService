package org.getimageservice.service.mapper;

import org.getimageservice.service.ModelMicroService;

public interface Mapper<E extends ModelMicroService, T extends ModelMicroService> {

    E toDo(T model);

}
