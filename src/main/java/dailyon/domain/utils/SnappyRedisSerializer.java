package dailyon.domain.utils;

import java.io.Serializable;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.SerializationUtils;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.xerial.snappy.Snappy;

@RequiredArgsConstructor
public class SnappyRedisSerializer<T> implements RedisSerializer<T> {

  private final RedisSerializer<T> innerSerializer;

  @Override
  public byte[] serialize(T object) throws SerializationException {
    try {
      byte[] bytes =
          innerSerializer != null
              ? innerSerializer.serialize(object)
              : SerializationUtils.serialize((Serializable) object);
      return Snappy.compress(bytes);
    } catch (Exception e) {
      throw new SerializationException(e.getMessage(), e);
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public T deserialize(byte[] bytes) throws SerializationException {
    try {
      if(bytes != null) {
        byte[] bos = Snappy.uncompress(bytes);
        return (T)
                (innerSerializer != null
                        ? innerSerializer.deserialize(bos)
                        : SerializationUtils.deserialize(bos));
      } else {
        return null;
      }
    } catch (Exception e) {
      throw new SerializationException(e.getMessage(), e);
    }
  }
}
