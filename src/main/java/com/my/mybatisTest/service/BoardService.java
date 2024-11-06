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
        if (boardDTO.getBoard_file().get(0).isEmpty()) {
            // 파일 선택 안한 부분
            boardDTO.setFile_attached(0);
            mapper.save(boardDTO);
        } else {
            // 파일을 선택했을 경우
            boardDTO.setFile_attached(1);
            mapper.save(boardDTO);
            // 저장된 id를 확보....
            System.out.println("[BoardService.save] = " + boardDTO);
            //  BoardFileDTO 를 생성 해서 얘도 저장

        }
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

    public List<BoardDTO> searchData(String search, String keword) {
        return mapper.searchData(search, keword);
    }
}
