package com.my.finalproject.question;

import java.util.ArrayList;

import com.my.finalproject.model.AnswerInstruction;
import com.my.finalproject.model.Answers;
import com.my.finalproject.model.Questions;

public class QuestionModel {
	
	private Questions question;
	private Answers answer;
	private ArrayList<AnswerInstruction> instruction;
	
	public QuestionModel(){
		this.instruction = new ArrayList<AnswerInstruction>();
	}
	
	public ArrayList<AnswerInstruction> getInstruction() {
		return instruction;
	}
	public void setInstruction(ArrayList<AnswerInstruction> instruction) {
		this.instruction = instruction;
	}
	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}
	public Answers getAnswer() {
		return answer;
	}
	public void setAnswer(Answers answer) {
		this.answer = answer;
	}
	
	
}
