package cc.xuepeng.ray.framework.core.common.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * 文件类型的枚举
 *
 * @author xuepeng
 */
@ToString
@Getter
@AllArgsConstructor
public enum FileType {

    CSV(StringUtils.EMPTY, "csv"),

    XLS(StringUtils.EMPTY, "xls"),

    XLSX(StringUtils.EMPTY, "xlsx"),

    DS3(StringUtils.EMPTY, "3ds"),

    AVI("41564920", "avi"),

    BABYLON(StringUtils.EMPTY, "babylon"),

    BLEND(StringUtils.EMPTY, "blend"),

    BMP("424D3E00", "bmp"),

    BR(StringUtils.EMPTY, "br"),

    CSS("40636861", "css"),

    DAE(StringUtils.EMPTY, "dae"),

    DATA(StringUtils.EMPTY, "data"),

    EOT(StringUtils.EMPTY, "eot"),

    FBX(StringUtils.EMPTY, "fbx"),

    GIF("47494638", "gif"),

    GLTF(StringUtils.EMPTY, "gltf"),

    GLB(StringUtils.EMPTY, "glb"),

    JPEG("FFD8FFE0", "jpeg"),

    JPG("FFD8FFE0", "jpg"),

    JS("76617220", "js"),

    JSON(StringUtils.EMPTY, "json"),

    LESS(StringUtils.EMPTY, "less"),

    MEM(StringUtils.EMPTY, "mem"),

    MAX(StringUtils.EMPTY, "max"),

    MA(StringUtils.EMPTY, "ma"),

    MB(StringUtils.EMPTY, "mb"),

    MP4("00000018", "mp4"),

    OBJ(StringUtils.EMPTY, "obj"),

    OTF(StringUtils.EMPTY, "otf"),

    PNG("89504E47", "png"),

    RM("2E524D46", "rm"),

    RMVB("2E524D46", "rmvb"),

    STL(StringUtils.EMPTY, "stl"),

    TTF(StringUtils.EMPTY, "ttf"),

    UNITYWEB(StringUtils.EMPTY, "unityweb"),

    WASM(StringUtils.EMPTY, "wasm"),

    WEBP("52494646", "webp"),

    WMV("3026B275", "wmv"),

    WOFF(StringUtils.EMPTY, "woff"),

    WOFF2(StringUtils.EMPTY, "woff2"),

    SVG(StringUtils.EMPTY, "svg"),

    SWF(StringUtils.EMPTY, "swf"),

    X3D(StringUtils.EMPTY, "x3d"),

    ZIP(StringUtils.EMPTY, "zip"),

    PSD("38425053", "psd"),

    WEBM("5745424D", "webm");

    /**
     * 根据文件后缀名获取字节码
     *
     * @param extName 后缀名
     * @return 字节码
     */
    public static FileType getCodeByDesc(final String extName) {
        for (FileType e : values()) {
            if (StringUtils.equals(e.extName, extName)) {
                return e;
            }
        }
        return null;
    }

    /**
     * 文件编号
     */
    private final String code;

    /**
     * 文件后缀
     */
    private final String extName;

}
