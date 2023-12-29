package dailyon.domain.sns.kafka.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class MemberUpdateDTO {

  private Long id;
  private String nickname;
  private String profileImgUrl;
}
