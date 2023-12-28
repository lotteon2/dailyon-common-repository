package dailyon.domain.order.kafka;

import dailyon.domain.order.kafka.enums.OrderEvent;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class OrderDTO {

  private List<ProductInfo> productInfos;
  private List<Long> couponInfos;
  private PaymentInfo paymentInfo;
  private String orderNo;
  private Long memberId;
  private int usedPoints;
  private OrderEvent orderEvent;

  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class ProductInfo {
    private Long productId;
    private Long sizeId;
    private Long quantity;
  }

  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class PaymentInfo {
    private String pgToken;
  }
}
