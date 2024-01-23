package com.damforum.model.entity;

import com.damforum.model.VoteType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="votes")
public class Vote {
    @Id
    @Column(name="vote_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;
    @Column(name="vote_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private VoteType voteType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}