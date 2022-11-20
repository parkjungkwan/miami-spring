package fastcode.api.util;


import static com.bitcamp.lms.dwh.utility.Util.random;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.bitcamp.lms.ext.domain.Geomap;


@Component
public class Lambda {
	public static Consumer<String> print = System.out::print;
	public static Function<Object, String> string = String :: valueOf;
	public static Function<String, Integer> integer = Integer :: valueOf;
	public static BiFunction<String,String, Integer> mySkip = (t, u) -> (integer.apply(t) - 1) * integer.apply(u);
	public static Function<String, Object> intO = Integer :: valueOf;
	public static BiPredicate<String, String> equals = (t, u) -> t.equals(u);
	public static BiFunction<Integer, Integer, Integer> random =(t,u) -> (int)(Math.random()*(u-t))+t;
	public static Function<Integer, int[]> intArr = int[] :: new;
	public static Supplier<LocalDate> today = () -> LocalDate.now();
	public static Supplier<LocalTime> time = () -> LocalTime.now();
	public static BiFunction<String,String, File> mkDir = File::new;
	public static BiFunction<File,String, File> mkFile = File::new;
	public static Supplier<String> uuid = () -> UUID.randomUUID().toString().replace("-", "");
	public static Optional<Integer> optInteger(String s){
		try{
			return Optional.of(Integer.parseInt(s));
		}catch(Exception e){
			return Optional.empty();
		}
	}
	public static Optional<String> optLongToString(long l){
		try{
			return Optional.of(String.valueOf(l));
		}catch(Exception e){
			return Optional.empty();
		}
	}
	public static String unixtimeToDate(String p){ /* Unix timestamp  */
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss z",Locale.KOREA);
	    return sdf.format(Long.parseLong(p + "000"));
	}
	public static String dateToUnixtime(String p) { /* Unix timestamp  */
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss z",Locale.KOREA);
		Date date = null;
		try {
			date = dateFormat.parse(p);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long unixTime = (long)date.getTime()/1000;
	    return String.valueOf(unixTime);
	}
	public static String ymd(String role, String gcode, String ph) { /* Unix timestamp  */
		DateFormat sdf = new SimpleDateFormat("yyMMdd",Locale.KOREA);
	    return String.valueOf(sdf.format(new Date()))+role+gcode+ph;
	}
	public static String now() {return String.valueOf(System.currentTimeMillis() / 1000);}

	/**
	 * 1970 ~ 2000 사이의 랜덤한 연도수 뽑기 
	 * 
	 * 윤년은 해당 연도를 4로 나눈 값이 0인 것을 의미한다. 
	 * && 그중 100으로 나눈 값이 0인 것은 윤년에서 제외하나, 
	 * || 400으로 나눈 값이 0인 것은 윤년으로 포함된다. 
	 * 그 외의 나머지 연도는 평년이다.
	 * */
	public static String randomDateBetween(int from, int to) {
		int year = random.apply(from, to);
		int month = random.apply(1, 13);
		int date = 0;
		switch(month) {
		case 2: date = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 
				random.apply(1, 30) : random.apply(1, 29) ; break;
		case 4: case  6: case  9: case  11: date = random.apply(1, 31);	break;
		default: date = random.apply(1, 32); break;
		}
		return year+"-"+month+"-"+date;
	}
	public static String randomTimeBetween(int from, int to) {
		int year = random.apply(from, to);
		int month = random.apply(1, 13);
		int date = 0;
		switch(month) {
		case 2: date = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 
				random.apply(1, 30) : random.apply(1, 29) ; break;
		case 4: case  6: case  9: case  11: date = random.apply(1, 31);	break;
		default: date = random.apply(1, 32); break;
		}
		int hour = random.apply(1, 24);
		int mmss = random.apply(1, 60);
		return year+"-"+month+"-"+date+" "+hour+":"+mmss+":"+mmss;
	}
	public static String randomGender() {
		List<String> arr = Arrays.asList("M","F");
		Collections.shuffle(arr);
		return arr.get(0);
	}
	public static String randomUserid() { /*랜덤 사용자ID 생성하기*/
		List<String> ls = Arrays.asList(
				"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".split(""));
		Collections.shuffle(ls);
		return ls.get(0)+ls.get(1)+ls.get(2)+ls.get(3);
	}
	public static String randomPhoneNumber() {
		return "010-"+random.apply(1000, 10000)+"-"+random.apply(1000, 10000); 
	}
	public static String randomUsername() {
		List<String> fname = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
		        "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
		        "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양",
		        "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금",
		        "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
	    List<String> name1 = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
	        "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
	        "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
	        "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
	        "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
	        "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
	        "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
	        "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
	        "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
	        "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
	    List<String> name2 = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", 
	    		"다", "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", 
	    		"민", "바", "박", "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세",
	    		"소", "솔", "수", "숙", "순", "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", 
	    		"완", "요", "용", "우", "원", "월", "위", "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔",
	    		"장", "재", "전", "정", "제", "조", "종", "주", "준", "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", 
	    		"치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형", "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘",
	    		"희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비", "솜", "공", "면", "탁", "온", "디", "항",
	    		"후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼", "열", "웅", "분", "변", "양",
	    		"출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠", "흔", "악", "람",
	    		"뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
	    Collections.shuffle(fname);
	    Collections.shuffle(name1);
	    Collections.shuffle(name2);
	    String[] a = name1.stream()
	    		.flatMap( i -> name2.stream().map(j -> new String[] {i, j}))
	    		.collect(Collectors.toList())
	    		.get(0);
	    return fname.get(0)+a[0]+a[1];
	}
	public static String randomEmail() {
		List<String> ls = Arrays.asList("@test.com","@gmail.com","@naver.com");
		Collections.shuffle(ls);
		return randomUserid()+ls.get(0);
	}
	public static List<Integer> randomScore(){
		return Stream.generate(Math::random)
				.limit(1)
				.map(i -> (int)(i * 100)).collect(Collectors.toList());
	}
	
	public static List<String> randomPlaces() {
		List<String> place = Arrays.asList("프레이저 플레이스 센트럴",
				"포 포인츠 바이 쉐라톤",
				"베뉴지 호텔 서울",
				"호스텔코리아 창덕궁",
				"명동 멀린 호텔",
				"명동 바이 롯데",
				"그랜드 앰배서더 서울",
				"서울 신라 호텔",
				"써미트 호텔 동대문",
				"호텔 그레이스리 서울",
				"소테츠 호텔즈 더 스프라지르",
				"이태원 에이원호텔",
				"임피리얼 팰리스 부티크 호텔",
				"크라운 관광 호텔",
				"호텔 더 디자이너스",
				"나인트리 프리미어 호텔",
				"명가의뜰",
				"불고기브라더스 서울역사점",
				"계림식당",
				"황소고집",
				"필동면옥",
				"대림정",
				"명동교자 본점",
				"명동피자",
				"돈돈돈까스",
				"평안도 족발집",
				"동화반점",
				"에베레스트레스토랑",
				"약수순대국",
				"호박식당",
				"오레노",
				"강원정",
				"한국의집",
				"블루스퀘어",
				"숭례문(남대문)",
				"N서울타워",
				"명동대성당",
				"서울숲",
				"국립극장",
				"전쟁기념관",
				"종묘",
				"탑골공원",
				"창덕궁",
				"경복궁",
				"청계천",
				"경리단길",
				"매봉산 팔각정",
				"효창공원",
				"백범김구기념관",
				"광장시장");
		
		return place;
	}
	public List<String> latitudeList() {
		List<String> latitude = Arrays.asList("126.969861/37.5625981",
				"126.972763/37.5508409",
				"126.990822/37.5687196",
				"126.990289/37.5761166",
				"126.999040/37.5626203",
				"126.986963/37.5613490",
				"127.002379/37.5601606",
				"127.005932/37.5566106",
				"127.006861/37.5622328",
				"126.976947/37.5615817",
				"127.007721/37.5646924",
				"126.991607/37.5340224",
				"126.998215/37.5352301",
				"126.990793/37.5314275",
				"126.971577/37.5455428",
				"126.990936/37.5642416",
				
				"126.970466/37.5491014",
				"126.971042/37.5523812",
				"126.994478/37.5701434",
				"126.986124/37.5685659",
				"126.996901/37.5603768",
				"126.994592/37.5615660",
				"126.985741/37.5625562",
				"126.985854/37.5620427",
				"127.005197/37.5597281",
				"127.006034/37.5602506",
				"127.008163/37.5677287",
				"127.007302/37.5670170",
				"127.010017/37.5529974",
				"127.012304/37.5572950",
				"126.994866/37.5351489",
				"126.967811/37.5404511",
				
				"126.994603/37.5601875",
				"127.002627/37.5406902",
				"126.975317/37.5599595",
				"126.988923/37.5492850",
				"126.986827/37.5632772",
				"127.040535/37.5451436",
				"127.000025/37.5528716",
				"126.977023/37.5362457",
				"126.994840/37.5731167",
				"126.988331/37.5711790",
				"126.991295/37.5827570",
				"126.976952/37.5806736",
				"126.978687/37.5692675",
				"126.992365/37.5399870",
				"127.019736/37.5412834",
				"126.963237/37.5455404",
				"126.959096/37.5445659",
				"126.998689/37.5702697");
		
		return latitude;
	}
	 public List<Geomap> mapDB() {
		 Geomap maps= null;
		 List<Geomap> mapList = new ArrayList<>();
		 List<String> maplist = randomPlaces();
		 for(int i = 0 ; i<maplist.size();i++) {
			 maps = new Geomap(maplist.get(i), latitudeList().get(i));
			 mapList.add(maps);
			
		 }
		 
	  return mapList;
	 }
	
		
}