package com.my.mybatisTest.mapper;

import com.my.mybatisTest.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    void save(@Param("boardDTO") BoardDTO boardDTO);

    List<BoardDTO> findAll();

    void updateHits(@Param("id")Long id);

    BoardDTO findById(@Param("id")Long id);

    void deleteById(Long id);

    void updateById(@Param("boardDto")BoardDTO boardDTO);

    List<BoardDTO> searchData(
            @Param("search")String search,
            @Param("keyword")String keword);
}
