package fastcode.api.util.enums;

enum G5MemberEnum {
    CREATE;
    @Override
    public String toString() {
        String s = "";
        switch(this) {
            case CREATE:
                s = "create table g5_member(\n" +
                        "   stu_sq int primary key auto_increment,\n" +
                        "   mgr_sq int,\n" +
                        "   stu_id varchar(20),\n" +
                        "   stu_pw varchar(20),\n" +
                        "   stu_nm varchar(20),\n" +
                        "   stu_im varchar(100), \n" +
                        "   save_dt varchar(12),\n" +
                        "   edit_dt varchar(12),\n" +
                        "   birthday varchar(20),\n" +
                        "   gender varchar(20),\n" +
                        "   constraint mgr_stu_fk foreign key(mgr_num) " +
                        "                references managers(mgr_num)\n" +
                        "   )"; break;
        }
        return s;
    }
}
