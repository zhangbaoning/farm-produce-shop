package utils;

import java.util.UUID;

/**
 * Created by zhangbaoning on 2017/5/24.
 */
public class UUIDUtils {
    public static String getUUID(){
        //生成随机数，并将-去掉
        return UUID.randomUUID().toString().replace("-","");
    }
}
