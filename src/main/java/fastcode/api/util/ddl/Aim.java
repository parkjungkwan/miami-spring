package fastcode.api.util.ddl;

public enum Aim {
	ai_grade;
	@Override
	public String toString() {
		String s = "";
		switch(this) {
		case ai_grade:
			s = "create table ai_grade(\n" + 
					"   tea_num int primary key auto_increment,\n" + 
					"   name varchar(20),\n" + 
					"   password varchar(20),\n" + 
					"   subject varchar(20),\n" + 
					"   profile_image varchar(100),\n" + 
					"   sub_num int,\n" + 
					"   constraint sub_tea_fk foreign key(sub_num) " + 
					"                references subjects(sub_num)\n" + 
					"   )"; break;
		}
		return s;
	}	
}
