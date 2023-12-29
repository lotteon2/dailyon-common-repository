package dailyon.domain.common;

import lombok.Getter;

@Getter
public enum KafkaTopic {
  APPROVE_PAYMENT("approve-payment"),
  CANCEL_ORDER("cancel-order"),
  CREATE_ORDER("create-order"),
  CREATE_ORDER_PRODUCT("create-order-product"),
  CREATE_ORDER_USE_COUPON("create-order-use-coupon"),
  CREATE_REVIEW("create-review"),
  USE_MEMBER_POINTS("use-member-points"),
  CREATE_MEMBER_FOR_SNS("create-member-for-sns"),
  UPDATE_MEMBER_FOR_SNS("update-member-for-sns");

  private final String value;

  KafkaTopic(String value) {
    this.value = value;
  }
}
