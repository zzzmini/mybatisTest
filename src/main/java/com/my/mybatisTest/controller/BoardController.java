package com.my.mybatisTest.controller;

import com.my.mybatisTest.dto.BoardDTO;
import com.my.mybatisTest.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/save")
    public String save() {
        return "save";
    }
    @PostMapping("/save")
    public String saveData(BoardDTO boardDTO) {
        System.out.println(boardDTO);
        boardService.save(boardDTO);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDTO> list = boardService.findAll();
        System.out.println(list);
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id,
                           Model model) {
        // 조회수 올리는 기능 처리
        boardService.updateHits(id);
        // 아이디 검색 후 상세페이지 보이기
        BoardDTO boardDTO = boardService.findById(id);
        System.out.println(boardDTO);
        model.addAttribute("board", boardDTO);
        return "detail";
    }

    @GetMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boardService.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping("update/{id}")
    public String updateById(@PathVariable("id") Long id,
                             Model model) {
        // 아이디 검색 후 업데이트페이지 보이기
        BoardDTO boardDTO = boardService.findById(id);
        System.out.println(boardDTO);
        model.addAttribute("board", boardDTO);
        return "update";
    }

    @PostMapping("update/{id}")
    public String updateByIdProc(
                        BoardDTO boardDTO,
                        @PathVariable("id") Long id,
                        Model model) {
        System.out.println(boardDTO);
        boardService.updateById(boardDTO);

        BoardDTO dto = boardService.findById(id);
        model.addAttribute("board", dto);
        return "detail";
    }
}