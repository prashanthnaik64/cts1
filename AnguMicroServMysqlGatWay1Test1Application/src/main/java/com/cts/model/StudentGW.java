package com.cts.model;

public class StudentGW {
	 private Long sid;
		private String firstname;
	    private String subject;
		
	    public Long getSid() {
			return sid;
		}
		public void setSid(Long sid) {
			this.sid = sid;
		}	
		
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public StudentGW() {
			super();
			// TODO Auto-generated constructor stub
		}
		public StudentGW(Long sid, String firstname, String subject) {
			super();
			this.sid = sid;
			this.firstname = firstname;
			this.subject = subject;
		}

}
