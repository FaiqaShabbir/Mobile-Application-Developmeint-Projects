package com.example.assignm_1_bscs_19011519_006;

import java.util.Date;

public class SupervisorSelectionForm {

    private int ssfFormID;
    private String Date;
    private String CandidateName;
    private String FatherName;
    private String RegistrationNo;
    private String SupervisorNames;
    private String ResearchTopic1;
    private String Summary1;
    private String SupervisorSignature1;
    private String ResearchTopic2;
    private String Summary2;
    private String SupervisorSignature2;
    private String ResearchTopic3;
    private String Summary3;
    private String SupervisorSignature3;
    private boolean comments;


    public int getSsfFormID() {
        return ssfFormID;
    }

    public void setSsfFormID(int ssfFormID) {
        this.ssfFormID = ssfFormID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getCandidateName() {
        return CandidateName;
    }

    public void setCandidateName(String candidateName) {
        CandidateName = candidateName;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getRegistrationNo() {
        return RegistrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        RegistrationNo = registrationNo;
    }

    public String getSupervisorNames() {
        return SupervisorNames;
    }

    public void setSupervisorNames(String supervisorNames) {
        SupervisorNames = supervisorNames;
    }

    public String getResearchTopic1() {
        return ResearchTopic1;
    }

    public void setResearchTopic1(String researchTopic1) {
        ResearchTopic1 = researchTopic1;
    }

    public String getSummary1() {
        return Summary1;
    }

    public void setSummary1(String summary1) {
        Summary1 = summary1;
    }

    public String getSupervisorSignature1() {
        return SupervisorSignature1;
    }

    public void setSupervisorSignature1(String supervisorSignature1) {
        SupervisorSignature1 = supervisorSignature1;
    }

    public String getResearchTopic2() {
        return ResearchTopic2;
    }

    public void setResearchTopic2(String researchTopic2) {
        ResearchTopic2 = researchTopic2;
    }

    public String getSummary2() {
        return Summary2;
    }

    public void setSummary2(String summary2) {
        Summary2 = summary2;
    }

    public String getSupervisorSignature2() {
        return SupervisorSignature2;
    }

    public void setSupervisorSignature2(String supervisorSignature2) {
        SupervisorSignature2 = supervisorSignature2;
    }

    public String getResearchTopic3() {
        return ResearchTopic3;
    }

    public void setResearchTopic3(String researchTopic3) {
        ResearchTopic3 = researchTopic3;
    }

    public String getSummary3() {
        return Summary3;
    }

    public void setSummary3(String summary3) {
        Summary3 = summary3;
    }

    public String getSupervisorSignature3() {
        return SupervisorSignature3;
    }

    public void setSupervisorSignature3(String supervisorSignature3) {
        SupervisorSignature3 = supervisorSignature3;
    }

    public boolean isComments() {
        return comments;
    }

    public void setComments(boolean comments) {
        this.comments = comments;
    }

    public SupervisorSelectionForm(int ssfFormID,
                                   String date, String candidateName, String fatherName,
                                   String registrationNo, String supervisorNames,
                                   String researchTopic1, String summary1,
                                   String supervisorSignature1, String researchTopic2,
                                   String summary2, String supervisorSignature2,
                                   String researchTopic3, String summary3,
                                   String supervisorSignature3, boolean comments) {
        this.ssfFormID = ssfFormID;
        this.Date = date;
        CandidateName = candidateName;
        FatherName = fatherName;
        RegistrationNo = registrationNo;
        SupervisorNames = supervisorNames;
        ResearchTopic1 = researchTopic1;
        Summary1 = summary1;
        SupervisorSignature1 = supervisorSignature1;
        ResearchTopic2 = researchTopic2;
        Summary2 = summary2;
        SupervisorSignature2 = supervisorSignature2;
        ResearchTopic3 = researchTopic3;
        Summary3 = summary3;
        SupervisorSignature3 = supervisorSignature3;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return ssfFormID +
                ", " + Date +
                ", " + CandidateName +
                ", " + FatherName +
                ", " + RegistrationNo +
                ", " + SupervisorNames +
                ", " + ResearchTopic1 +
                ", " + Summary1 +
                ", " + SupervisorSignature1 +
                ", " + ResearchTopic2 +
                ", " + Summary2 +
                ", " + SupervisorSignature2 +
                ", " + ResearchTopic3 +
                ", " + Summary3 +
                ", " + SupervisorSignature3 +
                ", " + comments;
    }

//    public SupervisorSelectionForm(String candidateName, String registrationNo, String date) {
//        CandidateName = candidateName;
//        RegistrationNo = registrationNo;
//        Date = date;
//    }

}
