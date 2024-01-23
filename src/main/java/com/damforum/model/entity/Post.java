package com.damforum.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts")
public class Post {

    @Id
    @Column(name="post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="description", nullable = false)
    private String description;
    @Column(name="vote_count", nullable = false)
    private Integer voteCount;
    @Column(name="created", nullable = false)
    private Instant created;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_id", referencedColumnName = "community_id")
    private Community community;
}