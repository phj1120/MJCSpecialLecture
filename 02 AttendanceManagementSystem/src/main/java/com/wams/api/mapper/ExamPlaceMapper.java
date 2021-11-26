package com.wams.api.mapper;

import com.wams.api.model.ExamPlace;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ExamPlaceMapper {

    // id로 examPlace 가져오기

    @Results(id="ExamPlaceMap", value = {
            @Result(property = "examPlaceId", column = "exam_place_id"),
            @Result(property = "examPlaceLocation", column = "exam_place_location")
    })

    @Select("SELECT * " +
            "FROM exam_place " +
            "WHERE exam_place_id = #{examPlaceId}")
    ExamPlace getExamPlace(@Param("examPlaceId")String examPlaceId);
}
