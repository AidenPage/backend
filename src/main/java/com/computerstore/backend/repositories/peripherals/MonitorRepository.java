package com.computerstore.backend.repositories.peripherals;

import com.computerstore.backend.domain.peripherals.Monitor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Aiden on 2016/10/23.
 */
@Repository
public interface MonitorRepository extends CrudRepository<Monitor,Long> {
}
