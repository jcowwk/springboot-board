package com.example.springbootboard.entity;

import com.example.springbootboard.dto.BoardDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Table(name="board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "boardTitle")
    private String boardTitle;

    @Column(name = "boardContent")
    private String boardContent;

    @Column(name = "writtenDate")
    private Date writtenDate;

    @Column(name = "updateDate")
    private Date updateDate;

    @Column(name = "memberEmail")
    private String memberEmail;

    public static BoardEntity toBoardEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContent(boardDTO.getBoardContent());
        boardEntity.setMemberEmail(boardDTO.getMemberEmail());

        return boardEntity;
    }

    public static BoardEntity toUpdateBoardEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setId(boardDTO.getId());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContent(boardDTO.getBoardContent());
        boardEntity.setMemberEmail(boardDTO.getMemberEmail());

        return boardEntity;
    }
}