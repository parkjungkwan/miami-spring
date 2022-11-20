package fastcode.api.ext.geomap.service;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Lazy
@Component
@NoArgsConstructor
public class GeomapVO {
	private String place,latitude;
	private List<GeomapVO> placeList;
	public GeomapVO(String place, String latitude) {
		this.place = place;
		this.latitude = latitude;
	}

}
