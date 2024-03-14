package com.example.springbootboard.dto;

import com.example.springbootboard.entity.BoardEntity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDTO {
    private Long id;
    private String boardTitle;
    private String boardContent;
    private Date writtenDate;
    private Date updateDate;

    private String memberEmail;

    public static BoardDTO toBoardDTO(BoardEntity boardEntity) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardContent(boardEntity.getBoardContent());
        boardDTO.setWrittenDate(boardEntity.getWrittenDate());
        boardDTO.setUpdateDate(boardEntity.getUpdateDate());
        boardDTO.setMemberEmail(boardEntity.getMemberEmail());
        return boardDTO;
    }
}