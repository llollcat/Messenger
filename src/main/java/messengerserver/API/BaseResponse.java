package messengerserver.API;

public class BaseResponse {

    private final String status;
    private final Integer code;
    private final String token;

    public BaseResponse(String status, Integer code, String token) {
        this.status = status;
        this.code = code;
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public Integer getCode() {
        return code;
    }
}