package spring5_mybatis_study.dto;

import java.util.Date;

public class Student { // db에서는 여러학생정보가 한테이블에 들어가기때문에 s를 붙이지만 여기서는 한 객체에 한명의 정보만 들어오기 때문에 student로 적ㄴ는당
	
		private int studId;
		private String name;
		private String email;
		private PhoneNumber phone;
		private Date dob;
		private Address address;
		
		
		

		public int getStudId() {
			return studId;
		}




		public void setStudId(int studId) {
			this.studId = studId;
		}




		public String getName() {
			return name;
		}




		public void setName(String name) {
			this.name = name;
		}




		public String getEmail() {
			return email;
		}




		public void setEmail(String email) {
			this.email = email;
		}




		public PhoneNumber getPhone() {
			return phone;
		}




		public void setPhone(PhoneNumber phone) {
			this.phone = phone;
		}




		public Date getDob() {
			return dob;
		}




		public void setDob(Date dob) {
			this.dob = dob;
		}




		public Address getAddress() {
			return address;
		}




		public void setAddress(Address address) {
			this.address = address;
		}




		//setter and getter method
		@Override
		public String toString() {
		return String.format("Student [%s, %s, %s, %s, %s %s]", studId, name, email,dob, phone,address);
		}
}
