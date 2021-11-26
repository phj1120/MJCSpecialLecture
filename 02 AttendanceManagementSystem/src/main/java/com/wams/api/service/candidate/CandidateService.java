//package com.wams.api.service.candidate;
//
//import com.wams.api.model.Candidate;
//
//import java.util.List;
//
//public interface CandidateService {
//    List<Candidate> list(String examPlaceId);
//
//    Candidate search(Candidate candidate);
//
//    Candidate issueUpdate(String candidateId, String candidatePhoto);
//
//    Candidate noNid(String candidateId, String candidatePhoto);
//
//    Candidate read(String candidateId);
//
//    Candidate update(Candidate candidate);
//
//    Candidate attend(String candidateId, String examPlaceId);
//
//    void delete(Candidate candidate);
//
//    List<Candidate> getCandidateExamList(String userId);
//}