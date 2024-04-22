package com.jira.board.dto.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteItem {
    private String email;
    private String nickname;
    private String profileImage;
}
