package dailyon.domain.common;

public interface KafkaTopic {

  String APPROVE_PAYMENT = "approve-payment";
  String CANCEL_ORDER = "cancel-order";
  String CREATE_ORDER = "create-order";
  String CREATE_ORDER_PRODUCT = "create-order-product";
  String CREATE_ORDER_USE_COUPON = "create-order-use-coupon";
  String CREATE_REVIEW = "create-review";
  String USE_MEMBER_POINTS = "use-member-points";
  String CREATE_MEMBER_FOR_SNS = "create-member-for-sns";
  String UPDATE_MEMBER_FOR_SNS = "update-member-for-sns";
}
