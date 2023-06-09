package evolution.fintech.sender;

import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

import java.util.List;

public interface GeneralSender {
    Long getChatId();

    default Long getFromChatId() {
        return null;
    }


    default String getText() {
        return null;
    }

    default String getParseMode() {
        return ParseMode.MARKDOWN;
    }

    default ReplyKeyboard getReply() {
        return null;
    }

    default Integer getMessageId() {
        return null;
    }

    default Integer getReplyMessageId() {
        return null;
    }

    MessageType getType();

    default String getCaption() {
        return null;
    }

    default InputFile getInputFile() {
        return null;
    }

    default Double getLatitude() {
        return null;
    }

    default Double getLongitude() {
        return null;
    }

    default String getFirstName() {
        return null;
    }

    default String getLastName() {
        return null;
    }

    default String getPhoneNumber() {
        return null;
    }

    default boolean getDisableWebPagePreview() {

        return false;
    }
    default List<InputMedia> getMedias() {
        return null;
    }
    default String getMediaGroupId() {
        return null;
    }

    default List<Integer> getMessagesId(){
        return null;
    }

}
