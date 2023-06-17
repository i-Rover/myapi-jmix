package com.company.myapiadminx.dao;

import com.company.myapiadminx.entity.WorkProgram;
import io.jmix.core.repository.JmixDataRepository;
import io.jmix.core.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

public interface WorkProgramRepository extends JmixDataRepository<WorkProgram, UUID> {
    @Query("select e from WorkProgram e join e.berthForm a where a.id=:id")
    Optional<WorkProgram> findWorkProgramAndBerthForm(@Param("id") UUID id);

    @Override
    Page<WorkProgram> findAll(Pageable pageable);
}
