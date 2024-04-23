package cc.xuepeng.ray.framework.core.common.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * LocalDateTime类型的序列化处理类
 * 在使用Jackson序列化对象时，会做如下操作：
 * 1、将LocalDateTime类型的对象序列化成毫秒数；
 * 2、将毫秒数序列化成LocalDateTime类型的对象；
 * 以上转换均采用系统默认时区
 *
 * @author xuepeng
 */
public class JacksonLocalDateTimeModule {

    private static final JavaTimeModule JACKSON_LOCAL_DATE_TIME_MODULE;

    static {
        JACKSON_LOCAL_DATE_TIME_MODULE = new JavaTimeModule();
        // 获取系统默认时区
        final ZoneOffset zoneOffset = OffsetDateTime.now().getOffset();
        // LocalDateTime类型序列化成时间戳（毫秒数）
        JACKSON_LOCAL_DATE_TIME_MODULE.addSerializer(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
            @Override
            public void serialize(LocalDateTime localDateTime,
                                  JsonGenerator jsonGenerator,
                                  SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeNumber(localDateTime.toInstant(zoneOffset).toEpochMilli());
            }
        });
        // 时间戳（秒数）序列化成LocalDateTime
        JACKSON_LOCAL_DATE_TIME_MODULE.addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
                final long timestamp = jsonParser.getLongValue();
                return LocalDateTime.ofEpochSecond(timestamp / 1000, 0, zoneOffset);
            }
        });
    }

    /**
     * 构造函数
     */
    private JacksonLocalDateTimeModule() {
    }


    /**
     * @return 获取单例的Java时间序列化配置模块
     */
    public static JavaTimeModule getInstance() {
        return JACKSON_LOCAL_DATE_TIME_MODULE;
    }

}
