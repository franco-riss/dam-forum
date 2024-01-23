package com.damforum.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum VoteType {

    UPVOTE(1), DOWNVOTE(-1);

    private int direction;
}