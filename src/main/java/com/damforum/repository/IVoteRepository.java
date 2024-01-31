package com.damforum.repository;

import com.damforum.model.entity.PostEntity;
import com.damforum.model.entity.UserEntity;
import com.damforum.model.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IVoteRepository extends JpaRepository<VoteEntity, Long> {
    Optional<VoteEntity> findByPostEntityAndUserEntity(PostEntity post, UserEntity currentUser);
}