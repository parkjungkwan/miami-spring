package fastcode.api.util.ddl.cop;

public enum Bbs {
	g5_board, g5_board_file, g5_board_file_project, g5_board_good, g5_board_new, 
	ai_article

	;
	@Override
	public String toString() {
		String s = "";
		switch(this) {
		case g5_board:
			s = "create table g5_board(\n" + 
					"   tea_no int primary key auto_increment,\n" + 
					"   name varchar(20),\n" + 
					"   password varchar(20),\n" + 
					"   subject varchar(20),\n" + 
					"   profile_image varchar(100),\n" + 
					"   sub_num int,\n" + 
					"   constraint sub_tea_fk foreign key(sub_num) " + 
					"                references subjects(sub_num)\n" + 
					"   )"; break;
		case g5_board_file:
			s = "create table g5_board_file(\n" + 
					"   tea_no int primary key auto_increment,\n" + 
					"   name varchar(20),\n" + 
					"   password varchar(20),\n" + 
					"   subject varchar(20),\n" + 
					"   profile_image varchar(100),\n" + 
					"   sub_num int,\n" + 
					"   constraint sub_tea_fk foreign key(sub_num) " + 
					"                references subjects(sub_num)\n" + 
					"   )"; break;
		case g5_board_file_project:
			s = "create table g5_board_file_project(\n" + 
					"   tea_no int primary key auto_increment,\n" + 
					"   name varchar(20),\n" + 
					"   password varchar(20),\n" + 
					"   subject varchar(20),\n" + 
					"   profile_image varchar(100),\n" + 
					"   sub_num int,\n" + 
					"   constraint sub_tea_fk foreign key(sub_num) " + 
					"                references subjects(sub_num)\n" + 
					"   )"; break;
		case g5_board_good:
			s = "create table g5_board_good(\n" + 
					"   tea_no int primary key auto_increment,\n" + 
					"   name varchar(20),\n" + 
					"   password varchar(20),\n" + 
					"   subject varchar(20),\n" + 
					"   profile_image varchar(100),\n" + 
					"   sub_num int,\n" + 
					"   constraint sub_tea_fk foreign key(sub_num) " + 
					"                references subjects(sub_num)\n" + 
					"   )"; break;
		case g5_board_new:
			s = "create table g5_board_new(\n" + 
					"   tea_no int primary key auto_increment,\n" + 
					"   name varchar(20),\n" + 
					"   password varchar(20),\n" + 
					"   subject varchar(20),\n" + 
					"   profile_image varchar(100),\n" + 
					"   sub_num int,\n" + 
					"   constraint sub_tea_fk foreign key(sub_num) " + 
					"                references subjects(sub_num)\n" + 
					"   )"; break;
		case ai_article:
			s = "create table ai_article(\n" + 
					"   art_no int primary key auto_increment,\n" + 
					"   name varchar(20),\n" + 
					"   password varchar(20),\n" + 
					"   subject varchar(20),\n" + 
					"   profile_image varchar(100),\n" + 
					"   sub_num int,\n" + 
					"   constraint sub_tea_fk foreign key(sub_num) " + 
					"                references ai_subject(sub_num)\n" + 
					"   )"; break;
		}
		return s;
	}	
}
