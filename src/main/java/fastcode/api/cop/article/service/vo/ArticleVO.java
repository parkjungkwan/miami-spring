package fastcode.api.cop.article.service.vo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import lombok.Data;

@Component
@Data  @Lazy
public class ArticleVO {
	private int artNo;
}
