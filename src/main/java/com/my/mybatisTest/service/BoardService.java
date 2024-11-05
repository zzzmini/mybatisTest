package com.my.mybatisTest.service;

import com.my.mybatisTest.dto.BoardDTO;
import com.my.mybatisTest.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;

    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }

    public void save(BoardDTO boardDTO) {
        mapper.save(boardDTO);
    }

    public List<BoardDTO> findAll() {
        return mapper.findAll();
    }

    public void updateHits(Long id) {
        mapper.updateHits(id);
    }

    public BoardDTO findById(Long id) {
        return mapper.findById(id);
    }

    public void deleteById(Long id) {
        mapper.deleteById(id);
    }

    public void updateById(BoardDTO boardDTO) {
        mapper.updateById(boardDTO);
    }
}
