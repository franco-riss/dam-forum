package com.damforum.repository;

import com.damforum.model.entity.CommentEntity;
import com.damforum.model.entity.PostEntity;
import com.damforum.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findAllByPostEntity(PostEntity post);
    List<CommentEntity> findAllByUserEntity(UserEntity user);
    int countByPostEntity(PostEntity postEntity);
}