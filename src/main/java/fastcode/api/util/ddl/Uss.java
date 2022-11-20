package fastcode.api.util.ddl;

public enum Uss {
	g5_member, ai_student, ai_teacher, ai_student_change_column
	
	
	
	;
	@Override
	public String toString() {
		String s = "";
		switch(this) {
		case g5_member:
			s = "create table g5_member(\n" + 
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
		case ai_student:
			s = "create table ai_student(\n" + 
					"   stu_no int primary key auto_increment,\n" + 
					"   train_id int,\n" + 
					"   stu_id varchar(20),\n" + 
					"   stu_pw varchar(20),\n" + 
					"   stu_name varchar(20),\n" + 
					"   stu_img varchar(100), \n" + 
					"   save_dt varchar(12),\n" + 
					"   edit_dt varchar(12),\n" + 
					"   birth varchar(12),\n" + 
					"   gender varchar(1),\n" + 
					"   constraint stu_train_fk foreign key(train_id) " + 
					"                references train(train_id)\n" +
					"   )"; break;
		case ai_teacher:
			s = "create table ai_teacher(\n" + 
					"   tea_no int primary key auto_increment,\n" + 
					"   tea_id varchar(20),\n" + 
					"   tea_pw varchar(20),\n" + 
					"   tea_name varchar(20)\n" + 
				/*	"   tea_im varchar(100), \n" + 
					"   save_dt varchar(12),\n" + 
					"   edit_dt varchar(12),\n" + 
					"   birthday varchar(20),\n" + 
					"   gender varchar(20),\n" + 
					"   constraint mgr_stu_fk foreign key(mgr_num) " + 
					"                references managers(mgr_num)\n" +*/
					"   )"; break;
		case ai_student_change_column:
			s ="alter table ai_student \n" + 
					"change stu_nm stu_name VARCHAR(20)";
		}
		return s;
	}		
}
