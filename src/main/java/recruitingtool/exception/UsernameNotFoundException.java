package recruitingtool.exception;

import java.util.Arrays;
import java.util.Objects;

public class UsernameNotFoundException extends RuntimeException {
    private String messageKey;
    private String[] arguments;

    private UsernameNotFoundException() {
    }

    public UsernameNotFoundException(String messageKey, Throwable throwable, String... arguments) {
        super(messageKey, throwable);
        this.messageKey = messageKey;
        this.arguments = arguments == null ? new String[0] : arguments;
    }

    public UsernameNotFoundException(String messageKey, String... arguments) {
        super(messageKey);
        this.messageKey = messageKey;
        this.arguments = arguments == null ? new String[0] : arguments;
    }

    public static UsernameNotFoundException forMessageKey(String messageKey) {
        return new UsernameNotFoundException(messageKey);
    }

    public static UsernameNotFoundException forMessageKey(String messageKey, Throwable throwable) {
        return new UsernameNotFoundException(messageKey, throwable);
    }

    public static UsernameNotFoundException forMessageKey(String messageKey, String... arguments) {
        return new UsernameNotFoundException(messageKey, arguments);
    }

    public static UsernameNotFoundException forMessageKey(
            String messageKey, Throwable throwable, String... arguments) {
        return new UsernameNotFoundException(messageKey, throwable, arguments);
    }

    public String getMessageKey() {
        return messageKey;
    }

    public String[] getArguments() {
        return arguments;
    }

    public boolean hasMessageKey(String messageKey) {
        return Objects.equals(this.messageKey, messageKey);
    }

    @Override
    public String toString() {
        return super.toString() + ", arguments=" + Arrays.toString(arguments);
    }
}
