package com.teamproject.devTalks.repository.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.teamproject.devTalks.entity.primaryKey.report.ReportPk;
import com.teamproject.devTalks.entity.report.ReportEntity;

public interface ReportRepository extends JpaRepository<ReportEntity, ReportPk> {

    public ReportEntity findByReported(int userNumber);

    public ReportEntity findByReporterAndReported(int reporter, int reported);

    public boolean existsByReporterAndReported(int repoter, int reported);
    
}
