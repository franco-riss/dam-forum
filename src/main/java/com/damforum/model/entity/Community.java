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
public class Community {
    @Id
    @Column(name="community_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long communityId;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="description", nullable = false)
    private String description;
    @Column(name="created", nullable = false)
    private Instant created;
}