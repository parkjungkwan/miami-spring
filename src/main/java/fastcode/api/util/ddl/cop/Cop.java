package fastcode.api.util.ddl.cop;

public enum Cop {
	ai_classroom, ai_company, ai_department;
	@Override
	public String toString() {
		String s = "";
		switch(this) {
		case ai_classroom:
			s = "create table ai_classroom(\n" + 
					"   mb_no int primary key auto_increment,\n" + 
					"   mb_id varchar(20) unique, \n" +
					"   mb_password varchar(20),\n" + 
					"   mb_name varchar(20),\n" + 
					"   mb_nick varchar(20),\n" + 
					"   mb_nick_date varchar(100), \n" + 
					"   mb_email varchar(12),\n" + 
					"   mb_homepage varchar(12),\n" + 
					"   mb_level varchar(20),\n" + 
					"   mb_sex varchar(20),\n" + 
					"   mb_birth varchar(12),\n" +
					"   mb_tel varchar(15),\n" +
					"   mb_hp varchar(20)\n" +
					"   )"; break;
		case ai_company:
			s = "create table ai_company(\n" + 
					"   stu_no int primary key auto_increment,\n" + 
					"   tim_no int,\n" + 
					"   stu_id varchar(20),\n" + 
					"   stu_pw varchar(20),\n" + 
					"   stu_nm varchar(20),\n" + 
					"   stu_im varchar(100), \n" + 
					"   save_dt varchar(12),\n" + 
					"   edit_dt varchar(12),\n" + 
					"   birth varchar(12),\n" + 
					"   gender varchar(1),\n" + 
					"   constraint stu_tim_fk foreign key(tim_no) " + 
					"                references teams(tim_no)\n" +
					"   )"; break;
		case ai_department:
			s = "create table ai_department(\n" + 
					"   tea_no int primary key auto_increment,\n" + 
					"   tea_id varchar(20),\n" +
					"   tea_id varchar(20),\n" + 
					"   tea_pw varchar(20),\n" + 
					"   tea_nm varchar(20)\n" + 
					"   )"; break;
		}
		return s;
	}		
}
