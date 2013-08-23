package com.gpr.db.repository;

import com.gpr.db.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * Services for user persistence purposes.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long>  {

    public User findByUuid(@Param("uuid") UUID uuid);
}