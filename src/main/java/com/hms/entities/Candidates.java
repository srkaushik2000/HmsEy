package com.hms.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/*
 * 
 */
@Entity
public class Candidates implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int candidates_id;

	private String firstname;
	private String lastname;
	private int exp;
	private int noticeperiod;
	private String phoneno;
	private String email;
	private String status;
	private LocalDate interview_sceduled_date;
	private String feedback;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "interviewer_fk")
	private Interviewer interviewer;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "candidates_id", referencedColumnName = "candidates_id")
	private List<Candidates_skills> candidates_skill = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "questionaire_id")
	private List<Questionaire> questionaire = new ArrayList<>();

	public Candidates() {
		super();
	}

	public Candidates(int candidates_id, String firstname, String lastname, int exp, int noticeperiod, String phoneno,
			String email, String status, LocalDate interview_sceduled_date, String feedback, Interviewer interviewer,
			List<Candidates_skills> candidates_skill, List<Questionaire> questionaire) {
		super();
		this.candidates_id = candidates_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.exp = exp;
		this.noticeperiod = noticeperiod;
		this.phoneno = phoneno;
		this.email = email;
		this.status = status;
		this.interview_sceduled_date = interview_sceduled_date;
		this.feedback = feedback;
		this.interviewer = interviewer;
		this.candidates_skill = candidates_skill;
		this.questionaire = questionaire;
	}

	public int getCandidates_id() {
		return candidates_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getNoticeperiod() {
		return noticeperiod;
	}

	public void setNoticeperiod(int noticeperiod) {
		this.noticeperiod = noticeperiod;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getInterview_sceduled_date() {
		return interview_sceduled_date;
	}

	public void setInterview_sceduled_date(LocalDate interview_sceduled_date) {
		this.interview_sceduled_date = interview_sceduled_date;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@JsonbTransient
	public Interviewer getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Interviewer interviewer) {
		this.interviewer = interviewer;
	}

	@JsonbTransient
	public List<Candidates_skills> getCandidates_skill() {
		return candidates_skill;
	}

	public void setCandidates_skill(List<Candidates_skills> candidates_skill) {
		this.candidates_skill = candidates_skill;
	}

	@JsonbTransient
	public List<Questionaire> getQuestionaire() {
		return questionaire;
	}

	public void setQuestionaire(List<Questionaire> questionaire) {
		this.questionaire = questionaire;
	}

	@Override
	public String toString() {
		return "Candidates [candidates_id=" + candidates_id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", exp=" + exp + ", noticeperiod=" + noticeperiod + ", phoneno=" + phoneno + ", email=" + email
				+ ", status=" + status + ", interview_sceduled_date=" + interview_sceduled_date + ", feedback="
				+ feedback + ", interviewer=" + interviewer + ", candidates_skill=" + candidates_skill
				+ ", questionaire=" + questionaire + "]";
	}

}