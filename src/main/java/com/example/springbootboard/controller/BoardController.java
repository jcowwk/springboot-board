package com.example.springbootboard.controller;

import com.example.springbootboard.dto.BoardDTO;
import com.example.springbootboard.dto.MemberDTO;
import com.example.springbootboard.entity.BoardEntity;
import com.example.springbootboard.service.BoardService;
import com.example.springbootboard.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Builder
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public String boardList(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "board/list";
    }

    @GetMapping("/board/{id}")
    public String boardDetail(@PathVariable Long id, Model model, HttpSession session) {
        BoardDTO boardDTO = boardService.findById(id);
        session.setAttribute("selectId", id);
        model.addAttribute("board", boardDTO);
        return "board/detail";
    }

    @GetMapping("/board/save")
    public String boardSaveForm(HttpSession session, Model model) {
        String myEmail = (String) session.getAttribute("loginEmail");
        BoardDTO boardDTO = boardService.saveForm(myEmail);
        model.addAttribute("board", boardDTO);
        return "board/save";
    }

    @PostMapping("/board/save")
    public String boardSave(@ModelAttribute BoardDTO boardDTO, HttpSession session) {
        String myEmail = (String) session.getAttribute("loginEmail");
        boardDTO.setMemberEmail(myEmail);
        boardService.save(boardDTO);
        return "board/list";
    }

    @GetMapping("/board/update")
    public String updateForm(HttpSession session, Model model) {
        String myEmail = (String) session.getAttribute("loginEmail");
        Long myId = (Long) session.getAttribute("selectId");

        BoardDTO boardDTO = boardService.updateBoard(myEmail, myId);
        model.addAttribute("updateBoard", boardDTO);
        return "board/update";
    }

    @PostMapping("/board/update")
    public String update(@ModelAttribute BoardDTO boardDTO) {
        boardService.update(boardDTO);
        return "redirect:/board/" + boardDTO.getId();
    }

    @GetMapping("/board/delete/{id}")
    public String deleteById(@PathVariable Long id, HttpSession session) {
        String loginEmail = String.valueOf(session.getAttribute("loginEmail"));
        boardService.deleteById(loginEmail, id);
        return "redirect:/board";
    }
}