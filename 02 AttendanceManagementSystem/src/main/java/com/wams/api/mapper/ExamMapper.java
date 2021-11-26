package com.wams.api.mapper;

import com.wams.api.model.Exam;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ExamMapper {

    @Results(id = "ExamMap", value = {
            @Result(property = "examId", column = "exam_id"),
            @Result(property = "examName", column = "exam_name"),
            @Result(property = "examTime", column = "exam_time")
    })

    @Select("select * " +
            "from exam " +
            "where exam_id = #{exam_id};")
    Exam getExamInfoByExamId(@Param("exam_id") String examId);


}
