package cc.xuepeng.ray.framework.core.common.util;

import cc.xuepeng.ray.framework.core.common.consts.DateTimeConst;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * 日期时间工具类
 *
 * @author xuepeng
 */
public class DateTimeUtil {

    public static final ThreadLocal<SimpleDateFormat> threadLocalDateFormat = ThreadLocal.withInitial(
            () -> new SimpleDateFormat(DateTimeConst.YYYY_MM_DD_HH_MM_SS, Locale.getDefault())
    );

    public static final DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofPattern(DateTimeConst.YYYY_MM_DD_HH_MM_SS);


    /**
     * 构造函数
     */
    private DateTimeUtil() {
    }

    /**
     * @return 使用系统默认时区，获取从现在到明天的秒数
     */
    public static long getSecondFromNowToTomorrow() {
        return getSecondFromNowToTomorrow(OffsetDateTime.now().getOffset());
    }

    /**
     * 自定义时区，获取从现在到明天的秒数
     *
     * @param zoneOffset 时区
     * @return 从现在到明天的秒数
     */
    public static long getSecondFromNowToTomorrow(final ZoneOffset zoneOffset) {
        final long add = 1L;
        final long now = LocalDateTime.now().toEpochSecond(zoneOffset);
        final long next = LocalDate.now().plusDays(add).atStartOfDay().toEpochSecond(zoneOffset);
        return next - now;
    }

    /**
     * @return 使用系统默认时区，获取从现在到明天的时区
     */
    public static Duration getDurationToTomorrow() {
        return getDurationToTomorrow(ZoneId.systemDefault());
    }

    /**
     * 自定义时区，获取从现在到明天的时间区间
     *
     * @param zoneId 时区
     * @return 从现在到明天的秒数
     */
    public static Duration getDurationToTomorrow(final ZoneId zoneId) {
        final long add = 1L;
        final LocalDateTime now = LocalDateTime.now(zoneId);
        final LocalDateTime nextDay = LocalDate.now(zoneId)
                .plusDays(add)
                .atStartOfDay();
        // 距明天0点有多少秒
        return Duration.between(now, nextDay);
    }

    /**
     * @return 格式化日期时间
     */
    public static String formatBySimpleDateFormat(final Date date, final String... pattern) {
        SimpleDateFormat simpleDateFormat = threadLocalDateFormat.get();
        if (pattern.length > 0) {
            simpleDateFormat.applyPattern(pattern[0]);
        }
        return simpleDateFormat.format(date);
    }

    /**
     * @return 使用系统默认时区，格式化日期时间
     */
    public static String formatBySimpleDateFormat(final LocalDateTime localDateTime, final String... pattern) {
        if (pattern.length > 0) {
            return DateTimeFormatter.ofPattern(pattern[0]).withZone(ZoneId.systemDefault()).format(localDateTime);
        }
        return dateTimeFormatter.format(localDateTime);
    }

}
