package com.gpr.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.gpr.db.domain.JobSeeker;

public interface JobSeekerRepository extends PagingAndSortingRepository<JobSeeker, Long>   {

}
