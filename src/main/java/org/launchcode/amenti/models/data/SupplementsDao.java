package org.launchcode.amenti.models.data;

import org.launchcode.amenti.models.Supplement;
import org.launchcode.amenti.models.SupplementsType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface SupplementsDao extends CrudRepository <Supplement, Integer> {

    List<Supplement> findByType(SupplementsType type);


}
