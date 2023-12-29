package dailyon.domain.sns.kafka.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class MemberCreateDTO {

  private Long id;
  private String nickname;
  private String profileImgUrl;
  private String code;
}
