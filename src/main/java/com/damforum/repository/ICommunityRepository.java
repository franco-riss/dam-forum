package com.damforum.repository;

import com.damforum.model.entity.CommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommunityRepository extends JpaRepository<CommunityEntity, Long> {
    CommunityEntity findByName(String communityName);
}