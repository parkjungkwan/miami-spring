package fastcode.api.util.ddl;

public enum Olh {
	g5_faq, g5_faq_master, ai_jedo, ai_sms
	
	
	;
	@Override
	public String toString() {
		String s = "";
		switch(this) {
		case g5_faq:
			s = "create table g5_faq(\n" + 
					"   tea_num int primary key auto_increment,\n" + 
					"   name varchar(20),\n" + 
					"   password varchar(20),\n" + 
					"   subject varchar(20),\n" + 
					"   profile_image varchar(100),\n" + 
					"   sub_num int,\n" + 
					"   constraint sub_tea_fk foreign key(sub_num) " + 
					"                references subjects(sub_num)\n" + 
					"   )"; break;
		case g5_faq_master:
			s = "create table g5_faq_master(\n" + 
					"   tea_num int primary key auto_increment,\n" + 
					"   name varchar(20),\n" + 
					"   password varchar(20),\n" + 
					"   subject varchar(20),\n" + 
					"   profile_image varchar(100),\n" + 
					"   sub_num int,\n" + 
					"   constraint sub_tea_fk foreign key(sub_num) " + 
					"                references subjects(sub_num)\n" + 
					"   )"; break;
		case ai_jedo:
			s = "create table ai_jedo(\n" + 
					"   jedo_no INT PRIMARY KEY AUTO_INCREMENT, \n" + 
					"   jedo_intro VARCHAR(300),\n" + 
					"   daum1 VARCHAR(200),\n" + 
					"   daum2 VARCHAR(200),\n" + 
					"   daum3 VARCHAR(200),\n" + 
					"   illegal VARCHAR(300)\n" +  
					"   )"; break;
		case ai_sms:
			s = "create table ai_sms(\n" + 
					"   sms_no INT PRIMARY KEY AUTO_INCREMENT, \n" + 
					"   sms_date VARCHAR(15),\n" + 
					"   sms_msg VARCHAR(200),\n" + 
					"   tim_status VARCHAR(15),\n" + 
					"   progress VARCHAR(3),\n" + 
					"   tim_no int, \n" +  
					"   tim_name VARCHAR(50) \n" +  
					"   )"; break;
		}
		return s;
	}	
}
