package com.wams.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Candidate {

    private String candidateId;
    private String examPlaceId;
    private String examId;
    private String candidateType;
    private String candidateRecruit;
    private int candidateBirth;
    private String candidateAttend;
    private String candidateTicketPhoto;
    private String candidatePhoto;
    private String candidateIssue;
    private String candidateExamNum;
}
