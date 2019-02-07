package org.launchcode.amenti.models.data;

import org.launchcode.amenti.models.SupplementModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface SupplementsDao extends CrudRepository <SupplementModel, Integer> {


}
