package com.teamproject.devTalks.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamproject.devTalks.entity.primaryKey.report.ReportPk;
import com.teamproject.devTalks.entity.report.ReportEntity;

public interface ReportRepository extends JpaRepository<ReportEntity, ReportPk> {

    public ReportEntity findByReported(int userNumber);

    public boolean existsByReporterAndReported(int repoter, int reported);

}
