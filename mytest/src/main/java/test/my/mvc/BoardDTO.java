package test.my.mvc;

import org.springframework.stereotype.Component;

@Component("bdto")
public class BoardDTO {
	int seq;
	String title, contents, writer, time;
	int password, viewcount;
	
	
	public BoardDTO() {
	}
	public BoardDTO(int seq, String title, String contents, String writer, String time, int password, int viewcount) {
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.time = time;
		this.password = password;
		this.viewcount = viewcount;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	@Override
	public String toString() {
		return "seq=" + seq + ", title=" + title + ", contents=" + contents + ", writer=" + writer + ", time="
				+ time + ", password=" + password + ", viewcount=" + viewcount + "]";
	}
	
	
}
