package com.example.springbootboard.service;

import com.example.springbootboard.dto.BoardDTO;
import com.example.springbootboard.entity.BoardEntity;
import com.example.springbootboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for(BoardEntity boardEntity : boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }

    public BoardDTO findById(Long id) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        if(optionalBoardEntity.isPresent()) {
            return BoardDTO.toBoardDTO(optionalBoardEntity.get());
        } else {
            return null;
        }
    }

    public BoardDTO saveForm(String myEmail) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setMemberEmail(myEmail);

        return boardDTO;
    }

    public void save(BoardDTO boardDTO) {
        boardRepository.save(BoardEntity.toBoardEntity(boardDTO));
    }

    public BoardDTO updateForm(String myEmail) {
        BoardDTO boardDTO = new BoardDTO();
        return boardDTO;
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.save(BoardEntity.toUpdateBoardEntity(boardDTO));
    }
}