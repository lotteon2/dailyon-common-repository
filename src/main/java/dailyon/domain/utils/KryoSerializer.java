package dailyon.domain.utils;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.pool.KryoFactory;
import com.esotericsoftware.kryo.pool.KryoPool;
import java.io.ByteArrayOutputStream;
import lombok.extern.slf4j.Slf4j;
import org.objenesis.strategy.StdInstantiatorStrategy;

@Slf4j
public class KryoSerializer {

  private static final KryoFactory factory =
      () -> {
        Kryo kryo = new Kryo();
        try {
          kryo.setRegistrationRequired(false);
          ((Kryo.DefaultInstantiatorStrategy) kryo.getInstantiatorStrategy())
              .setFallbackInstantiatorStrategy(new StdInstantiatorStrategy());
        } catch (Exception e) {
          log.error(e.getMessage(), e);
        }
        return kryo;
      };

  private static final KryoPool pool = new KryoPool.Builder(factory).softReferences().build();

  public static byte[] serialize(final Object obj) {

    return pool.run(
        kryo -> {
          ByteArrayOutputStream stream = new ByteArrayOutputStream();
          Output output = new Output(stream);
          kryo.writeClassAndObject(output, obj);
          output.close();
          return stream.toByteArray();
        });
  }

  @SuppressWarnings("unchecked")
  public static <V> V deserialize(final byte[] objectData) {

    return (V)
        pool.run(
            kryo -> {
              Input input = new Input(objectData);
              return (V) kryo.readClassAndObject(input);
            });
  }

  public static <V> V deepCopy(final V obj) {

    return (V) pool.run(kryo -> (V) kryo.copy(obj));
  }
}
