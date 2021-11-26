package com.wams.api.controller.overseer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wams.api.controller.candidate.CandidateController;
import com.wams.api.mapper.*;
import com.wams.api.model.Candidate;
import com.wams.api.model.Exam;
import com.wams.api.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OverseerCandidateController {

    private final Logger logger = LoggerFactory.getLogger(CandidateController.class);

    private final ExamPlaceMapper examPlaceMapper;
    private final CandidateMapper candidateMapper;
    private final OverseerAssignMapper overseerAssignMapper;
    private final ExamMapper examMapper;
    private final UserMapper userMapper;

    //    관리자가 감독할 시험 정보 조회
    @PostMapping("api/overseer/view")
    public Map<String, Object> overseerInfo(@RequestHeader("Authorization") String authorizationHeader) {
        Map<String, Object> jsonData = new HashMap<>();
        String overseerId = getUserIdToToken(authorizationHeader);

        String examPlace = overseerAssignMapper.getExamPlaceByOverseerId(overseerId);
        String examId = overseerAssignMapper.getExamIdByOverseerId(overseerId);
        String userName = userMapper.findByUserId(overseerId).getUserName();
        Exam examInfoByExamId = examMapper.getExamInfoByExamId(examId);

        System.out.println("examInfoByExamId = " + examInfoByExamId);
        Timestamp examTimestamp = examInfoByExamId.getExamTime();
        String examName = examInfoByExamId.getExamName();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH시 mm분");
        String examTime = simpleDateFormat.format(examTimestamp);
        System.out.println("examTime = " + examTime);

        String attendTotal = candidateMapper.getAttendTotal(examId);
        String attendComplete = candidateMapper.getAttendComplete(examId);
        String candidateCount = attendComplete + "/" + attendTotal;

        jsonData.put("examPlace", examPlace);
        jsonData.put("examSubject", examName);
        jsonData.put("examDate", examTime);
        jsonData.put("overseerName", userName);
        jsonData.put("candidateCount", candidateCount);

        logger.info("api/overseer/view");
        logger.info(jsonData.toString());
        return jsonData;
    }

    //    감독관이 관리하는 학생 정보 조회
    @GetMapping("/api/overseer/candidate/list")
    public Map<String, Object> list(@RequestHeader("Authorization") String authorizationHeader) {
        String userId = getUserIdToToken(authorizationHeader);
        Map<String, Object> jsonData = new HashMap<>();

        String examId = overseerAssignMapper.getExamIdByOverseerId(userId);
        List<Candidate> candidateList = candidateMapper.getCandidateListByExamId(examId);
        jsonData.put("candidate", candidateList);

        logger.info("/api/overseer/candidate/list " +userId);
        logger.info(jsonData.toString());
        return jsonData;
    }

    //    감독관이 관리하는 학생 정보 조회
    @PostMapping("/api/overseer/candidate/detail")
    public Map<String, Object> view(@RequestHeader("Authorization") String authorizationHeader, @Param("candidateExamNum") String candidateExamNum) {
        Map<String, Object> jsonData = new HashMap<>();

        String userId = getUserIdToToken(authorizationHeader);
        String examId = overseerAssignMapper.getExamIdByOverseerId(userId);
        List<Candidate> candidateList = candidateMapper.getCandidateListByExamId(examId);

        for (Candidate candidate : candidateList) {
            if (candidate.getCandidateExamNum().equals(candidateExamNum)) {
                Timestamp examTime = examMapper.getExamInfoByExamId(candidate.getExamId()).getExamTime();
                User user = userMapper.findByUserId(userId);
                String candidate_attend = getAttend(candidate);

                HashMap<String, String> userInfoMap = new HashMap<String, String>();
                userInfoMap.put("name", user.getUserName());
                userInfoMap.put("place", candidate.getExamPlaceId());
                userInfoMap.put("subject", candidate.getExamId());
                userInfoMap.put("attend", candidate_attend);
                userInfoMap.put("date", String.valueOf(examTime));
                userInfoMap.put("usrNumber", candidate.getCandidateExamNum());
                jsonData.put("candidateInfo", userInfoMap);
            }
        }
        logger.info("/api/overseer/candidate/detail " +userId);
        logger.info(jsonData.toString());
        return jsonData;
    }

    //    출석 처리
    @PostMapping("/api/overseer/candidate/attend")
    public Map<String, Object> AttendCheck(@RequestHeader("Authorization") String authorizationHeader, @Param("candidateExamNum") String candidateExamNum) {
        Map<String, Object> jsonData = new HashMap<>();
        String userId = getUserIdToToken(authorizationHeader);
        String examId = overseerAssignMapper.getExamIdByOverseerId(userId);
        List<Candidate> candidateList = candidateMapper.getCandidateListByExamId(examId);

        System.out.println("candidateList = " + candidateList);

        Timestamp examTime = examMapper.getExamInfoByExamId(examId).getExamTime();
        System.out.println("examTime = " + examTime);

        for (Candidate candidate : candidateList) {
            if (candidate.getCandidateExamNum().equals(candidateExamNum)) {

                Timestamp candidateAttend = Timestamp.valueOf(candidate.getCandidateAttend());

                System.out.println("candidate = " + candidate);
                System.out.println("candidateAttend = " + candidateAttend);
                if (candidateAttend.before(examTime)) {
                    candidateMapper.updateIssue(candidateExamNum, "출석 완료");
                    String candidateIssue = candidate.getCandidateIssue();
                    jsonData.put("status", candidateIssue);
                }
            }
        }
        logger.info("/api/overseer/candidate/attend " +userId);
        logger.info(jsonData.toString());
        return jsonData;
    }

    private String getAttend(Candidate candidate) {
        String candidate_state;
        String candidateAttend = candidate.getCandidateAttend();
        String candidateIssue = candidate.getCandidateIssue();

        if (candidateIssue == null) {
            if (candidateAttend.equals("0000-00-00 00:00:00")) {
                candidate_state = "미출석";
            } else {
                candidate_state = "오류 : 출석시간 O ,출석처리 X";
            }
        } else {
            if (!candidateAttend.equals("0000-00-00 00:00:00")) {
                if (candidateIssue.equals("출석처리중")) {
                    candidate_state = "인증 요청 중";
                } else if (candidateIssue.equals("출석완료")) {
                    candidate_state = "출석 완료";
                } else {
                    candidate_state = "오류";
                }
            } else {
                candidate_state = "오류";
            }
        }
        return candidate_state;
    }

    private String getUserIdToToken(String authorizationHeader) {
        authorizationHeader = authorizationHeader.substring(7);
        String[] chunks = authorizationHeader.split("\\.");
        Base64.Decoder decoder = Base64.getDecoder();
        String payload = new String(decoder.decode(chunks[1]));

        ObjectMapper mapper = new ObjectMapper();

        Map<String, String> map = null;
        try {
            map = mapper.readValue(payload, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String userId = map.get("sub");
        return userId;
    }

//    @PostMapping("/api/overseer/candidate/issue/update")
//    public Map<String, Object> issueUpdate(@RequestParam String candidateId,
//                                           @RequestParam String candidateIssue) {
//        Map<String, Object> jsonData = new HashMap<>();
//        Candidate getCandidate = candidateService.read(candidateId);
//
//        if (getCandidate == null) {
//            jsonData.put("result", "수험번호 오류");
//            jsonData.put("message", "해당 수험번호의 학생이 없습니다.");
//        } else {
//            Candidate issueCandidate = candidateService.issueUpdate(getCandidate.getCandidateId(), candidateIssue);
//            jsonData.put("candidate", issueCandidate);
//        }
//        return jsonData;
//    }

//    @PostMapping("/api/overseer/candidate/nonid")
//    public Map<String, Object> noNid(@RequestParam String candidateId,
//                                     @RequestParam String candidatePhoto) {
//        Map<String, Object> jsonData = new HashMap<>();
//        Candidate getCandidate = candidateService.read(candidateId);
//
//        if (getCandidate == null) {
//            jsonData.put("result", "수험번호 오류");
//            jsonData.put("message", "해당 수험번호의 학생이 없습니다.");
//        } else {
//            Candidate nidCandidate = candidateService.noNid(candidateId, candidatePhoto);
//            jsonData.put("candidate", nidCandidate);
//        }
//        return jsonData;
//    }

//    @PostMapping("/api/overseer/candidate/attend")
//    public Map<String, Object> attend(@RequestParam String overseerId,
//                                      @RequestParam String candidateId,
//                                      @RequestParam String examPlaceId) {
//        Map<String, Object> jsonData = new HashMap<>();
//        Candidate candidate = candidateService.read(candidateId);
//        ExamPlace examPlace = examPlaceService.read(examPlaceId);
//        Overseer overseer = overseerService.read(overseerId);
//
//        if (candidate == null) {
//            jsonData.put("result", "수험번호 오류");
//            jsonData.put("message", "해당 수험번호의 학생이 없습니다.");
//            return jsonData;
//        } else if (examPlace == null) {
//            jsonData.put("result", "고사장 오류");
//            jsonData.put("message", "잘못된 고사장 ID");
//            return jsonData;
//        } else if (overseer == null) {
//            jsonData.put("result", "감독관 오류");
//            jsonData.put("message", "잘못된 감독관 ID");
//            return jsonData;
//        }
//
//        Exam exam = examMapper.getExamInfoByExamId(candidate.getExamId());
//
//        if( !candidate.getExamPlaceId().equals(examPlace.getExamPlaceId()) ) {
//            jsonData.put("result", "고사장 불일치");
//            jsonData.put("message", "고사장이 일치하지 않습니다.");
//            jsonData.put("candidate", candidate);
//            jsonData.put("exam", exam);
//            jsonData.put("examPlaceLocation", examPlace.getExamPlaceLocation());
//        } else if(!exam.getExamId().equals(overseer.getExamId())) {
//            jsonData.put("result", "고사일/교시 불일치");
//            jsonData.put("message", "고사일/교시가 일치하지 않습니다.");
//            jsonData.put("candidate", candidate);
//            jsonData.put("exam", exam);
//            jsonData.put("examPlaceLocation", examPlace.getExamPlaceLocation());
//        } else if(!candidate.getCandidateAttend().equals("0000-00-00 00:00:00")) {
//            jsonData.put("result", "이미출석");
//            jsonData.put("message", "이미 출석 했습니다.");
//            jsonData.put("candidate", candidate);
//            jsonData.put("exam", exam);
//            jsonData.put("examPlaceLocation", examPlace.getExamPlaceLocation());
//        } else {
//            Candidate attendCandidate = candidateService.attend(candidate.getCandidateId(), examPlace.getExamPlaceId());
//            jsonData.put("candidate", attendCandidate);
//            jsonData.put("exam", exam);
//            jsonData.put("examPlaceLocation", examPlace.getExamPlaceLocation());
//        }
//        return jsonData;
//    }

}
