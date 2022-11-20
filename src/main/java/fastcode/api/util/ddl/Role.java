package fastcode.api.util.ddl;

public enum Role {         // ID, LEVEL
	ROLE_ADMIN, ADMIN,     // 1, 10         관리자(시스템 내 모든 관리 기능 권한 보유자)
	ROLE_MGR, MGR,         // 2, 9           책임자(교육 운영 관리 기능 권한 보유자)
	ROLE_STAFF,STAFF,      // 3, 7           과정운영 담당자
	ROLE_TUTOR, TUTOR,     // 4, 5           교강사
	ROLE_STUDENT, STUDENT, // 5, 3           하나 이상의 과정 수료자 (예비)
	ROLE_USER, USER,        // 6, 1           학습자
	ROLE_DEVELOPER         // 7, 8      IT 시스템운영자

}

/**
CREATE TABLE USER( 
	no int auto_increment primary key,
	id varchar(30) not null,
	password varchar(30) not null,
	enabled boolean not null //계정활성화 여부

)

한명의 사용자는 여러개의 권한을 가질 수 있습니다.(ROLE_USER, ROLE_ADMIN 등등)
SPRING SECURITY를 사용하지 않고 권한을 체크하는 경우,
회원별로 레벨을 부여하고 게시판 정보에 읽기권한레벨, 쓰기권한레벨을 넣어 준 뒤
회원의 레벨이 게시판의 권한레벨보다 클 경우 권한을 주는 방식입니다.
하지만 SECURITY는 레벨의 비교가 아닌, 권한(String)이 일치하는 대상에 대해 권한을 주기 때문에
관리자 권한 즉, ROLE_ADMIN을 보유하고 있더라도 사용자 권한인 ROLE_USER를 보유하고 있지 않을 경우 접근을 못하게 됩니다.
따라서 한 유저는 여러개의 권한(1:n)을 보유할 수 있어야합니다.

create table ai_role(
	role_id int not null auto_increment,
	role_level int,
	role_name varchar(50) default 'ROLE_USER',
	role_site varchar(50),
	role_alias varchar(50) default USER,
	memo varchar(50) default USER
)

USER TABLE과 no를 기준으로 외래키를 설정할 수 있지만 마이그레이션, DB복구 및 성능저하로 인해 논리적 설계만 해주고 실제론 적용하지 않습니다. 
따라서 fk 미적용 시엔 트랜잭션 처리를 해주어야 합니다.
이후 스프링 시큐리티에서 기본으로 제공하는 JDBC를 사용하여 테이블로부터 도메인 객체를 받아옵니다.
security-context.xml의 user-service부분을 다음과 같이 변경하여줍니다.
 */