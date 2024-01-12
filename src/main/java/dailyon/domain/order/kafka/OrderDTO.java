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
  private OrderType orderType;
  private String referralCode;

  @Getter
  public enum OrderType {
    SINGLE("단건주문"),
    CART("장바구니주문"),
    GIFT("선물하기"),
    AUCTION("경매주문");

    private final String message;

    OrderType(String message) {
      this.message = message;
    }
  }

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
