package enums;

public enum StatusCode {
    SUCCESS(200),
    CREATED(201),
    UNAUTHORIZED(401),
    BAD_REQUEST(400),
    NOT_FOUND(404);

    private final int value;

    StatusCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}