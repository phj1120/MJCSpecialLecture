package com.wams.api.mapper;

import com.wams.api.model.Candidate;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Map;

@Mapper
public interface CandidateMapper {

    @Results(id="CandidateMap", value = {
            @Result(property = "candidateId", column = "candidate_id"),
            @Result(property = "candidateName", column = "candidate_name"),
            @Result(property = "candidateType", column = "candidate_type"),
            @Result(property = "candidateRecruit", column = "candidate_recruit"),
            @Result(property = "candidateBirth", column = "candidate_birth"),
            @Result(property = "candidateAttend", column = "candidate_attend"),
            @Result(property = "candidateTicketPhoto", column = "candidate_ticket_photo"),
            @Result(property = "candidatePhoto", column = "candidate_photo"),
            @Result(property = "candidateIssue", column = "candidate_issue"),
            @Result(property = "examPlaceId", column = "exam_place_id"),
            @Result(property = "examId", column = "exam_id"),
            @Result(property = "candidateExamNum", column = "candidate_examNum")
    })

    @Select("SELECT * " +
            "FROM candidate " +
            "WHERE exam_place_id = #{examPlaceId}")
    List<Candidate> list(@Param("examPlaceId") String examPlaceId);

    @Select("SELECT * " +
            "FROM candidate " +
            "WHERE candidate_id = #{candidateId}")
    @ResultMap("CandidateMap")
    Candidate getCandidate(@Param("candidateId") String candidateId);

    @Select("SELECT * " +
            "FROM candidate "+
            "WHERE candidate_examNum = #{candidateExamNum}")
    @ResultMap("CandidateMap")
//    이거 안해주니까 오류나네
    Candidate getCandidateByExamNum(@Param("candidateExamNum") String candidateExamNum);

    @Select("SELECT * " +
            "FROM candidate " +
            "WHERE candidate_id = #{candidateId};")
    @ResultMap("CandidateMap")
    List<Candidate> getCandidateExamList(@Param("candidateId") String candidateId);

//    @Results(id = "CandidateCountMap", value = {
//            @Result(property = "attendComplete", column = "attendComplete"),
//            @Result(property = "attendTotal", column = "attendTotal")
//    })
//    @Select("SELECT (SELECT COUNT(*) FROM candidate WHERE exam_id = #{examId} AND candidate_issue='출석 완료') AS attendComplete, (SELECT count(*) FROM candidate WHERE exam_id = #{examId}) AS attendTotal")
//    Map<String, String> getAttendCount(@Param("examId") String examId);

    @Select("SELECT COUNT(*) FROM candidate WHERE exam_id = #{examId} AND candidate_issue='출석 완료'")
    String getAttendComplete(@Param("examId") String examId);

    @Select("SELECT count(*) FROM candidate WHERE exam_id = #{examId}")
    String getAttendTotal(@Param("examId") String examId);


    @Select("SELECT * " +
            "FROM candidate " +
            "WHERE exam_id = #{examId};")
    @ResultMap("CandidateMap")
    List<Candidate> getCandidateListByExamId(@Param("examId") String examId);


    @Update("UPDATE candidate " +
            "SET candidate_attend = #{candidateAttend} " +
            "WHERE candidate_examNum = #{candidateExamNum}")
    void updateAttend(@Param("candidateExamNum") String candidateExamNum,
                      @Param("candidateAttend") String candidateAttend);

    @Update("UPDATE candidate " +
            "SET candidate_issue = #{candidateIssue} " +
            "WHERE candidate_examNum = #{candidateExamNum}")
    void updateIssue(@Param("candidateExamNum") String candidateExamNum,
                      @Param("candidateIssue") String candidateIssue);


    @Update("UPDATE candidate " +
            "SET candidate_photo = #{candidatePhoto} " +
            "WHERE candidate_id = #{candidateId}")
    void noNid(@Param("candidateId") String candidateId,
               @Param("candidatePhoto") String candidatePhoto);// /need

    @Update("UPDATE candidate " +
            "SET candidate_issue = #{candidateIssue} " +
            "WHERE candidate_id = #{candidateId}")
    void issueUpdate(@Param("candidateId") String candidateId,
                     @Param("candidateIssue") String candidateIssue);

}