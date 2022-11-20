package fastcode.api.util.ddl.dam;

public enum Dwh {
	ai_file, truncate_table, drop_table, row_count, information_schema, profile_image_url,
	mgr,tut,std, stf
	;
	@Override
	public String toString() {
		String s = "";
		switch(this) {
		case mgr: s = "828"; break;
		case tut: s = "485"; break;
		case std: s = "371"; break;
		case stf: s = "990"; break;
		case truncate_table: s = "truncate table \t"; break;
		case drop_table: s = "drop table if exists \t"; break;
		case row_count: s = "select count(*) count from \t"; break;
		case information_schema: s = "select count(*) from information_schema.tables " + 
					"where table_schema = \'mariadb\'"; break;
		case profile_image_url: s = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0ZL7it9GAAc4a1Fb40d6fxu-paaRZ-zG2yQ&usqp=CAU"; break;
		default:
			break;
		}
		return s;
	}	
}
