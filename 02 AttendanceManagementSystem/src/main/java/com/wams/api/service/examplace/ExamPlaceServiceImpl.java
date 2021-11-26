//package com.wams.api.service.examplace;
//
//import com.wams.api.mapper.ExamPlaceMapper;
//import com.wams.api.mapper.OverseerAssignMapper;
//import com.wams.api.model.ExamPlace;
//import com.wams.api.model.OverseerAssign;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class ExamPlaceServiceImpl implements ExamPlaceService {
//
//    private final OverseerAssignMapper overseerAssignMapper;
//    private final ExamPlaceMapper examPlaceMapper;
//
//    @Override
//    public ExamPlace read(String examPlaceId) {
//        return examPlaceMapper.getExamPlace(examPlaceId);
//    }
//
//    // OverseerAssign 테이블에 overseerId와 매칭되는 examPlace 리스트 불러오기
//    @Override
//    public List<ExamPlace> getExamPlaceList(String overseerId) {
//        // 고사장 객체가 들어가는 리스트
//        List<ExamPlace> examPlaceList = new ArrayList<>();
//        // 감독관 id에 매칭되는 고사장 리스트 조회
//        List<OverseerAssign> matchList = overseerAssignMapper.getMatchList(overseerId);
//
//        for (OverseerAssign overseerAssign : matchList) {
//            examPlaceList.add(examPlaceMapper.getExamPlace(overseerAssign.getExamPlaceId()));
//        }
//        return examPlaceList;
//    }
//
//    @Override
//    public List<ExamPlace> list(ExamPlace examPlace) {
//        return null;
//    }
//    @Override
//    public ExamPlace search(ExamPlace examPlace) {
//        return null;
//    }
//    @Override
//    public ExamPlace update(ExamPlace examPlace) {
//        return null;
//    }
//    @Override
//    public void delete(ExamPlace examPlace) {}
//}