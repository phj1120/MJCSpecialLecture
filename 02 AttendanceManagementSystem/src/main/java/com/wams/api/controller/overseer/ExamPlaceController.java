//package com.wams.api.controller.overseer;
//
//import com.wams.api.model.entity.Exam;
//import com.wams.api.model.ExamPlace;
//import com.wams.api.model.Overseer;
////import com.wams.api.service.exam.ExamService;
//import com.wams.api.repositroy.ExamRepository;
////import com.wams.api.service.examplace.ExamPlaceService;
//import com.wams.api.service.overseer.OverseerService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@RestController
//@RequiredArgsConstructor
//public class ExamPlaceController {
//
//    private final ExamPlaceService examPlaceService;
//    @PostMapping("/api/overseer/examplace/list")
//    public Map<String, Object> examPlaceList(@RequestParam String overseerId) {
//        Map<String, Object> jsonData = new HashMap<>();
//        List<ExamPlace> examPlaceList = examPlaceService.getExamPlaceList(overseerId);
//
//        if(!examPlaceList.isEmpty()) {
//            jsonData.put("examPlaceList", examPlaceList);
//        } else {
//            jsonData.put("result", "오류");
//            jsonData.put("message", "[/examplace/list]");
//        }
//
//        return jsonData;
//    }
//
//    private final ExamRepository examRepository;
//    private final OverseerService overseerService;
//
//    @PostMapping("/api/overseer/examplace/view")
////    관리자가 통제할 수 있는 시험장 목록 확인
//    public Map<String, Object> examPlaceView(@RequestParam String overseerId,
//                                             @RequestParam String examPlaceId) {
//        Map<String, Object> jsonData = new HashMap<>();
//        final ExamPlace getExamPlace = examPlaceService.read(examPlaceId);
//        final Overseer getOverseer = overseerService.read(overseerId);
//
//        Optional<Exam> optionalExam = examRepository.findByExamId(getOverseer.getExamId());
//        final Exam getExam = optionalExam.get();
//
//        if(getExamPlace == null || getExam == null) {
//            jsonData.put("result", "오류");
//            jsonData.put("message", "[/examplace/view]");
//        } else {
//            jsonData.put("overseerRole", "감독관");
//            jsonData.put("exam", getExam);
//            jsonData.put("examPlace", getExamPlace);
//        }
//
//        return jsonData;
//    }
//}
