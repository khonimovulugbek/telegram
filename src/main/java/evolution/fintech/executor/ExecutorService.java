package evolution.fintech.executor;


import evolution.fintech.sender.GeneralSender;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Slf4j
public class ExecutorService {

    public static SendMessage send(GeneralSender sender) {
        SendMessage send = SendMessage
                .builder()
                .chatId(sender.getChatId())
                .text(sender.getText())
                .parseMode(sender.getParseMode() == null ? ParseMode.MARKDOWN : sender.getParseMode())
                .disableWebPagePreview(sender.getDisableWebPagePreview())
                .build();
        if (sender.getReply() != null) send.setReplyMarkup(sender.getReply());
        if (isExistReplyMessage(sender)) send.setReplyToMessageId(sender.getReplyMessageId());
        return send;
    }

    public static EditMessageText edit(GeneralSender sender) {
        EditMessageText send = EditMessageText
                .builder()
                .chatId(sender.getChatId())
                .text(sender.getText())
                .messageId(sender.getMessageId())
                .parseMode(sender.getParseMode() == null ? ParseMode.MARKDOWN : sender.getParseMode())
                .build();
        if (isExistKeyboard(sender)) {
            InlineKeyboardMarkup reply = (InlineKeyboardMarkup) sender.getReply();
            send.setReplyMarkup(reply);
        }
        return send;
    }

    public static SendPhoto sendPhoto(GeneralSender sender) {

        SendPhoto send = SendPhoto
                .builder()
                .chatId(sender.getChatId())
                .parseMode(sender.getParseMode() == null ? ParseMode.MARKDOWN : sender.getParseMode())
                .photo(sender.getInputFile())
                .caption(sender.getCaption())
                .build();
        if (isExistKeyboard(sender)) send.setReplyMarkup(sender.getReply());
        if (isExistReplyMessage(sender)) send.setReplyToMessageId(sender.getReplyMessageId());
        return send;
    }

    public static SendLocation sendLocation(GeneralSender sender) {
        SendLocation send = SendLocation.builder()
                .chatId(sender.getChatId())
                .latitude(sender.getLatitude())
                .longitude(sender.getLongitude())
                .build();
        if (isExistKeyboard(sender)) send.setReplyMarkup(sender.getReply());
        if (isExistReplyMessage(sender)) send.setReplyToMessageId(sender.getReplyMessageId());
        return send;
    }

    public static SendContact sendContact(GeneralSender sender) {
        SendContact send = SendContact
                .builder()
                .chatId(sender.getChatId())
                .firstName(sender.getFirstName())
                .lastName(sender.getLastName())
                .phoneNumber(sender.getPhoneNumber())
                .build();
        if (isExistKeyboard(sender)) send.setReplyMarkup(sender.getReply());
        if (isExistReplyMessage(sender)) send.setReplyToMessageId(sender.getReplyMessageId());
        return send;
    }

    public static ForwardMessage forward(GeneralSender sender) {

        return ForwardMessage
                .builder()
                .chatId(sender.getChatId())
                .fromChatId(sender.getFromChatId())
                .messageId(sender.getMessageId())
                .build();
    }

    public static ForwardMessage forward(GeneralSender sender, Integer messageId) {

        return ForwardMessage
                .builder()
                .chatId(sender.getChatId())
                .fromChatId(sender.getFromChatId())
                .messageId(messageId)
                .build();
    }

    public static SendMediaGroup sendMediaGroup(GeneralSender sender) {
        return SendMediaGroup
                .builder()
                .chatId(sender.getChatId())
                .medias(sender.getMedias())
                .build();
    }

    private static boolean isExistReplyMessage(GeneralSender sender) {
        return sender.getMessageId() != null;
    }

    private static boolean isExistKeyboard(GeneralSender sender) {
        return sender.getReply() != null;
    }

    public static SendDocument sendDocument(GeneralSender sender) {
        SendDocument send = SendDocument
                .builder()
                .chatId(sender.getChatId())
                .parseMode(sender.getParseMode() == null ? ParseMode.MARKDOWN : sender.getParseMode())
                .document(sender.getInputFile())
                .caption(sender.getCaption())
                .build();
        if (isExistKeyboard(sender)) send.setReplyMarkup(sender.getReply());
        if (isExistReplyMessage(sender)) send.setReplyToMessageId(sender.getReplyMessageId());
        return send;
    }
}
