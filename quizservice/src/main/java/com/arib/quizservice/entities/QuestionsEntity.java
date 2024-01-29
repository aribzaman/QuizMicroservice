//package com.arib.quizservice.entities;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.DynamicUpdate;
//
//
//@Entity
//@Table(name = "questions")
//@DynamicUpdate
//public class QuestionsEntity {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "quesId", nullable = false, unique = true)
//	int ques_id;
//
//	@Column(nullable = false)
//	String questiontext;
//	
//	@Column(nullable = false)
//	String questioncategory;
//	
//	String difficultylevel;
//	
//
//	String option1;
//	String option2;
//	String option3;
//	String option4;
//	String correct;
//	
//	String explanation;
//
//	public QuestionsEntity() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public QuestionsEntity(int ques_id, String questiontext, String questioncategory, String difficultylevel,
//			String option1, String option2, String option3, String option4, String correct, String explanation) {
//		super();
//		this.ques_id = ques_id;
//		this.questiontext = questiontext;
//		this.questioncategory = questioncategory;
//		this.difficultylevel = difficultylevel;
//		this.option1 = option1;
//		this.option2 = option2;
//		this.option3 = option3;
//		this.option4 = option4;
//		this.correct = correct;
//		this.explanation = explanation;
//	}
//
//	public int getQues_id() {
//		return ques_id;
//	}
//
//	public void setQues_id(int ques_id) {
//		this.ques_id = ques_id;
//	}
//
//	public String getQuestiontext() {
//		return questiontext;
//	}
//
//	public void setQuestiontext(String questiontext) {
//		this.questiontext = questiontext;
//	}
//
//	public String getQuestioncategory() {
//		return questioncategory;
//	}
//
//	public void setQuestioncategory(String questioncategory) {
//		this.questioncategory = questioncategory;
//	}
//
//	public String getDifficultylevel() {
//		return difficultylevel;
//	}
//
//	public void setDifficultylevel(String difficultylevel) {
//		this.difficultylevel = difficultylevel;
//	}
//
//	public String getOption1() {
//		return option1;
//	}
//
//	public void setOption1(String option1) {
//		this.option1 = option1;
//	}
//
//	public String getOption2() {
//		return option2;
//	}
//
//	public void setOption2(String option2) {
//		this.option2 = option2;
//	}
//
//	public String getOption3() {
//		return option3;
//	}
//
//	public void setOption3(String option3) {
//		this.option3 = option3;
//	}
//
//	public String getOption4() {
//		return option4;
//	}
//
//	public void setOption4(String option4) {
//		this.option4 = option4;
//	}
//
//	public String getCorrect() {
//		return correct;
//	}
//
//	public void setCorrect(String correct) {
//		this.correct = correct;
//	}
//
//	public String getExplanation() {
//		return explanation;
//	}
//
//	public void setExplanation(String explanation) {
//		this.explanation = explanation;
//	}
//
//	@Override
//	public String toString() {
//		return "QuestionsEntity [ques_id=" + ques_id + ", questiontext=" + questiontext + ", questioncategory="
//				+ questioncategory + ", difficultylevel=" + difficultylevel + ", option1=" + option1 + ", option2="
//				+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", correct=" + correct + ", explanation="
//				+ explanation + "]";
//	}
//	
//	
//
//
//}
