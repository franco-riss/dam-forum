package com.damforum.model.dto;

import com.damforum.model.VoteType;
import lombok.Data;

@Data
public class VoteRequestDto {
    private VoteType voteType;
    private Long postId;
}