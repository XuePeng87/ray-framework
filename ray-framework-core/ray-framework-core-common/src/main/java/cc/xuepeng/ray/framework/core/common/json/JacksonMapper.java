package cc.xuepeng.ray.framework.core.common.json;

import cc.xuepeng.ray.framework.core.common.consts.DateTimeConst;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 创建Jackson的映射类
 * 使用枚举单例模式，创建OBJECT_MAPPER对象
 *
 * @author xuepeng
 */
public class JacksonMapper {

    /**
     * OBJECT_MAPPER对象
     */
    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        // 设置操作系统默认时区
        OBJECT_MAPPER.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        // 时间值正反序列化的格式化方式
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat(DateTimeConst.YYYY_MM_DD_HH_MM_SS, Locale.CHINA));
        // 允许解析Java/C/c++风格的注释风格注解
        OBJECT_MAPPER.configure(JsonReadFeature.ALLOW_JAVA_COMMENTS.mappedFeature(), Boolean.TRUE);
        // 允许使用不带引号的字段名的特性（Javascript允许，但JSON规范不允许）
        OBJECT_MAPPER.configure(JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES.mappedFeature(), Boolean.TRUE);
        // 否允许使用YAML注释的特性，这些注释以“#”开头，并一直持续到行尾
        OBJECT_MAPPER.configure(JsonReadFeature.ALLOW_YAML_COMMENTS.mappedFeature(), Boolean.TRUE);
        // 允许使用单引号（撇号，字符'\ "）来引用字符串（名称和字符串值）的特性
        OBJECT_MAPPER.configure(JsonReadFeature.ALLOW_SINGLE_QUOTES.mappedFeature(), Boolean.TRUE);
        // 允许使用不带引号的字段名的特性（Javascript允许，但JSON规范不允许）
        OBJECT_MAPPER.configure(JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES.mappedFeature(), Boolean.TRUE);
        // 允许JSON字符串包含未转义的控制字符（值小于32的ASCII字符，包括制表符和换行符）的特性
        OBJECT_MAPPER.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), Boolean.TRUE);
        // 允许在最终值（在Array中）或成员（在Object中）后面尾随单个逗号的特性
        OBJECT_MAPPER.configure(JsonReadFeature.ALLOW_TRAILING_COMMA.mappedFeature(), Boolean.TRUE);
        // 序列化时，日期不会转换为时间戳
        OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // 序列化时，java.util.Dates（和子类型）用作java.util.Map键被序列化为文本值（ISO-8601）
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, Boolean.FALSE);
        // 反序列化时，遇到未知属性时，不会引起结果序列化失败
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
    }

    /**
     * 构造函数
     */
    private JacksonMapper() {
    }

    /**
     * @return 获取单例的OBJECT_MAPPER对象
     */
    public static ObjectMapper getInstance() {
        return OBJECT_MAPPER;
    }

}
