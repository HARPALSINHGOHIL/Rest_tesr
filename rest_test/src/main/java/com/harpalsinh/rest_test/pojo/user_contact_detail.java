package com.harpalsinh.rest_test.pojo;

public class user_contact_detail {

		long phone_number;
		String comments;
		int contact_id;
	
		public user_contact_detail()
		{
			
		}

		public long getPhone_number() {
			return phone_number;
		}

		public void setPhone_number(long phone_number) {
			this.phone_number = phone_number;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public int getContact_id() {
			return contact_id;
		}

		public void setContact_id(int contact_id) {
			this.contact_id = contact_id;
		}
		
}
