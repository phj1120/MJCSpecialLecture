//package com.wams.api.service.candidate;
//
//import com.wams.api.mapper.CandidateMapper;
//import com.wams.api.mapper.ExamPlaceMapper;
//import com.wams.api.model.Candidate;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class CandidateServiceImpl implements CandidateService {
//
//    private final CandidateMapper candidateMapper;
//    private final ExamPlaceMapper examPlaceMapper;
//
//    @Override
//    public Candidate read(String candidateId) {
//        return candidateMapper.getCandidate(candidateId);
//    }
//
//    @Override
//    public List<Candidate> list(String examPlaceId) {
//        return candidateMapper.list(examPlaceId);
//    }
//
//    @Override
//    public Candidate issueUpdate(String candidateId, String candidateIssue) {
//        candidateMapper.issueUpdate(candidateId, candidateIssue);
//        return candidateMapper.getCandidate(candidateId);
//    }
//
//    @Override
//    public Candidate attend(String candidateId, String examPlaceId) {
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        String s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
//        candidateMapper.updateAttend(candidateId, s);
////        examPlaceMapper.attend(examPlaceId);
//        return candidateMapper.getCandidate(candidateId);
//    }
//
//    @Override
//    public Candidate noNid(String candidateId, String candidatePhoto) {
//        candidateMapper.noNid(candidateId, candidatePhoto);
//        return candidateMapper.getCandidate(candidateId);
//    }
//
//    @Override
//    public Candidate search(Candidate candidate) {
//        return null;
//    }
//
//    @Override
//    public Candidate update(Candidate candidate) {
//        return null;
//    }
//
//    @Override
//    public void delete(Candidate candidate) {
//
//    }
//
//    @Override
//    public List<Candidate> getCandidateExamList(String userId) {
//        List<Candidate> candidateExamList = candidateMapper.getCandidateExamList(userId);
//        return candidateExamList;
//    }
//}