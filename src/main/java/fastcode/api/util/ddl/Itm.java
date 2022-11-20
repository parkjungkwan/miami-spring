package fastcode.api.util.ddl;

public enum Itm {
	ai_team, ai_subject, ai_course, ai_train
	
	
	;
	@Override
	public String toString() {
		String s = "";
		switch(this) {
		case ai_team:
			s = "create table ai_team(\n" 
					+"   tim_no int primary key,\n" 
					+"   tim_nm varchar(20),\n"
					+"   start_dt varchar(12),\n"
					+"   end_dt varchar(12)\n" + 
				/*	"   stu_cnt varchar(3),\n" + 
					"   out_cnt varchar(3),\n" + 
					"   mb_no varchar(3),\n" + 
					"   constraint sub_tea_fk foreign key(sub_num) " + 
					"                references subjects(sub_num)\n" +  */
					"   )"; break;
		case ai_subject:
			s = "create table ai_subject \n"  
					+"(sub_num int primary key auto_increment, \n" 
					+"subject varchar(20), "  
					+"description varchar(100)) "; break; 
		case ai_course:
					s = "create table ai_course \n"  
					+"(sub_num int primary key auto_increment, \n"  
					+"subject varchar(20), " 
					+"description varchar(100)) "; break; 
		case ai_train:
			s = "create table ai_train \n"  
					+"(train_id int primary key auto_increment, \n" 
					+ "train_title varchar(50) not null  default '기본값', \n" 
					+ "train_details text , \n"
					+ "train_goal varchar(300) not null  default '기본값', \n"
					+ "train_option varchar(50) not null default '기본값', \n"
					+ "train_list text not null default '기본값', \n"
					+ "train_capacity int not null default 0, \n"
					+ "train_days int not null default 0, \n"
					+ "train_hours int not null default 0, \n"
					+ "train_threads int not null default 0, \n"
					+ "train_complete varchar(50) not null default '기본값', \n"
					+ "train_tutor int not null default 0, \n"
					+ "train_rgdate date, \n"
					+ "train_mdate date, \n"
					+ "train_version int not null default 0,\n"
					+ "train_enable bit, \n"
					+ "train_price int not null default 0, \n"
					+ "train_cost varchar(50), \n"
					+ "train_thum varchar(50), \n"
					+ "train_start date, \n"
					+ "train_end date,\n"
					+ "train_path varchar(50)"
					+ ") "; break; 
					
					
		}
		return s;
	}	
}















