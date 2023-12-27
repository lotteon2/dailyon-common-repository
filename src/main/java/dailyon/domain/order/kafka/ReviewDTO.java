package dailyon.domain.order.kafka;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDTO {
  private String orderDetailNo;
  private Long productId;
  private Long memberId;
  private int point;
  private double ratingAvg;
}
