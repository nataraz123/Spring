package com.nt.beans;

public class Course {
	private int courseId;
	private String courseName;
	private int duration;
	private float fee;
	
	public Course(int courseId, String courseName, int duration, float fee) {
		System.out.println("Course.Course()");
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration + ", fee=" + fee
				+ "]";
	}
	
	
	

}
