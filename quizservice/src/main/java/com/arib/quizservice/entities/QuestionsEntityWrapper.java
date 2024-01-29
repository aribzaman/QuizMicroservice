package com.arib.quizservice.entities;


public class QuestionsEntityWrapper {

	int ques_id;
	String questiontext;
	String option1;
	String option2;
	String option3;
	String option4;
	public QuestionsEntityWrapper(int ques_id, String questiontext, String option1, String option2, String option3,
			String option4) {
		super();
		this.ques_id = ques_id;
		this.questiontext = questiontext;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}
	public int getQues_id() {
		return ques_id;
	}
	public void setQues_id(int ques_id) {
		this.ques_id = ques_id;
	}
	public String getQuestiontext() {
		return questiontext;
	}
	public void setQuestiontext(String questiontext) {
		this.questiontext = questiontext;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	@Override
	public String toString() {
		return "QuestionsEntityWrapper [ques_id=" + ques_id + ", questiontext=" + questiontext + ", option1=" + option1
				+ ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + "]";
	}

	
}
