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
@Table(name="communities")
public class CommunityEntity {
    @Id
    @Column(name="community_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long communityId;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="description", nullable = false)
    private String description;
    @Column(name="created")
    private Instant created;
}