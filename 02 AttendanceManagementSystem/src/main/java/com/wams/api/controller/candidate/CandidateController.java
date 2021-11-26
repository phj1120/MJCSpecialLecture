package com.wams.api.controller.candidate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wams.api.mapper.CandidateMapper;
import com.wams.api.mapper.ExamMapper;
import com.wams.api.mapper.UserMapper;
import com.wams.api.model.Candidate;
import com.wams.api.model.Exam;
import com.wams.api.model.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class CandidateController {

    private final Logger logger = LoggerFactory.getLogger(CandidateController.class);

    private final CandidateMapper candidateMapper;
    private final ExamMapper examMapper;
    private final UserMapper userMapper;

    @PostMapping("/api/candidate/examlist")
    public Map<String, Object> responseCandidateExamList(@RequestHeader("Authorization") String authorizationHeader) {
//        헤더에 있는 jwt 토큰에서 유저 Id 추출
        String userId = getUserIdToToken(authorizationHeader);
        Map<String, Object> jsonData = new HashMap<>();
        List<Map<String, String>> examList = new ArrayList<>();
        List<Candidate> candidateExamList = candidateMapper.getCandidateExamList(userId);

        for (Candidate candidateExam : candidateExamList) {
            String examName = examMapper.getExamInfoByExamId(candidateExam.getExamId()).getExamName();
            String candidateExamNum = candidateExam.getCandidateExamNum();

            Map<String, String> examInfo = new HashMap<>();
            examInfo.put("examName", examName);
            examInfo.put("candidateExamNum", candidateExamNum);
            examList.add(examInfo);
        }
        jsonData.put("examList", examList);

        logger.info("/api/candidate/examlist " +userId);
        logger.info(jsonData.toString());
        return jsonData;
    }

    @PostMapping("/api/candidate/info")
    public Map<String, Object> responseCandidateInfo(@RequestHeader("Authorization") String authorizationHeader, @RequestParam String candidateExamNum) {
        String userId = getUserIdToToken(authorizationHeader);
        Map<String, Object> jsonData = new HashMap<>();

        Candidate candidate = candidateMapper.getCandidateByExamNum(candidateExamNum);
        Timestamp examDate = examMapper.getExamInfoByExamId(candidate.getExamId()).getExamTime();
        User user = userMapper.findByUserId(userId);
        String candidateAttend = candidate.getCandidateAttend();

        HashMap<String, String> userInfoMap = new HashMap<>();
        userInfoMap.put("name", user.getUserName());
        userInfoMap.put("place", candidate.getExamPlaceId());
        userInfoMap.put("subject", candidate.getExamId());
        userInfoMap.put("attend", candidateAttend);
        userInfoMap.put("date", String.valueOf(examDate));
        userInfoMap.put("usr_number", candidate.getCandidateExamNum());
        jsonData.put("candidateInfo", userInfoMap);

        logger.info("/api/candidate/info " +userId);
        logger.info(jsonData.toString());
        return jsonData;
    }

    @PostMapping("/api/candidate/attend")
    private Map<String, Object> CandidateAttend(@RequestHeader("Authorization") String authorizationHeader, @RequestParam String candidateExamNum) {
        Map<String, Object> jsonData = new HashMap<>();
        String userId = getUserIdToToken(authorizationHeader);
        Candidate candidateByExamNum = candidateMapper.getCandidateByExamNum(candidateExamNum);
        Exam examInfoByExamId = examMapper.getExamInfoByExamId(candidateByExamNum.getExamId());
        Timestamp examTime = examInfoByExamId.getExamTime();
        System.out.println("examDate = " + examTime);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);

        String candidateAttend = candidateByExamNum.getCandidateAttend();
        String candidateIssue = candidateByExamNum.getCandidateIssue();

//        로그인된 계정의 사용자만 출석 요청 가능하도록
        if (!candidateByExamNum.getCandidateId().equals(userId)) {
            logger.info("/api/candidate/attend userId 불일치");
            jsonData.put("status", "userId 불일치");
            return jsonData;
        }
        
//        시험 시작 후에는 출석 신청 못하도록
        if (examTime.before(timestamp)){
            logger.info("/api/candidate/attend 요청 시간 초과");
            jsonData.put("status", "요청 시간 초과");
            return jsonData;
        }
        System.out.println("candidateAttend = " + candidateAttend);
        if (candidateIssue.equals("미출석") || (candidateIssue.equals("출석처리중") && candidateAttend.equals("0000-00-00 00:00:00"))) {
            candidateMapper.updateAttend(candidateExamNum, nowTime);
            candidateMapper.updateIssue(candidateExamNum, "출석처리중");
            jsonData.put("status", "요청 성공");
        } else if (candidateIssue.equals("출석처리중")) {
            jsonData.put("status", "출석처리중");
        } else if (candidateIssue.equals("출석완료")) {
            jsonData.put("status", "출석 완료");
        } else if (candidateIssue.equals("결석")) {
            jsonData.put("status", "결석");
        }

        logger.info("/api/candidate/attend " +userId);
        logger.info(jsonData.toString());
        return jsonData;
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
}

