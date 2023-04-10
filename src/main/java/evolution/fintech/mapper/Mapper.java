package evolution.fintech.mapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Khonimov Ulugbek
 * Date: 10.04.2023  02:34
 */
public class Mapper {
    private static final Map<Long, String> mapStep = new HashMap<>();
    private static final Map<Long, String> mapLang = new HashMap<>();
    private static final Map<Long, Integer> mapMessageId = new HashMap<>();


    public static void setStep(Long chatId, String step) {
        mapStep.put(chatId, step);
    }

    public static String getStep(Long chatId) {
        return mapStep.get(chatId);
    }

    public static void setLang(Long chatId, String step) {
        mapLang.put(chatId, step);
    }

    public static String getLang(Long chatId) {
        return mapLang.get(chatId);
    }
    public static void setMessageId(Long chatId, Integer messageId) {
        mapMessageId.put(chatId, messageId);
    }
    public Integer getMessageId(Long chatId) {
        return mapMessageId.get(chatId);
    }

}
