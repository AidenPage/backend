package com.computerstore.backend.repositories.components;

import com.computerstore.backend.domain.components.Chassis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Aiden on 2016/10/23.
 */
@Repository
public interface ChassisRepository extends CrudRepository<Chassis,Long> {
}
