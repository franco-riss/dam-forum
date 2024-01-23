package com.damforum.model.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="comments")
public class Comment {
    @Id
    @Column(name="comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Column(name="text", nullable = false)
    private String text;
    @Column(name="created", nullable = false)
    private Instant created;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}