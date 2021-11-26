package com.wams.api.mapper;

import com.wams.api.model.Candidate;
import com.wams.api.model.OverseerAssign;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OverseerAssignMapper {

    // 감독관 ID가 들어있는 컬럼 리스트 불러오기
    @Results(id="OverseerAssignMap", value = {
            @Result(property = "overseerAssignId", column = "overseer_assign_id"),
            @Result(property = "overseerId", column = "overseer_id"),
            @Result(property = "examPlaceId", column = "exam_place_id")
    })
    @Select("SELECT * " +
            "FROM overseer_assign " +
            "WHERE overseer_id = #{overseerId}")
    List<OverseerAssign> getMatchList(@Param("overseerId")String overseerId);


//    감독관이 하나의 시험에 배정 된다 가정하고 진행
    @Select("select exam_place_id " +
            "from overseer_assign " +
            "where overseer_id = #{overseerId};")
    String getExamPlaceByOverseerId(@Param("overseerId") String overseerId);

    @Select("select exam_id " +
            "from overseer_assign " +
            "where overseer_id = #{overseerId};")
    String getExamIdByOverseerId(@Param("overseerId") String overseerId);
}