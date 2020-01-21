package skp.billionAttempts.config;

public enum EndPoints {
    ADMIN_ENDPOINTS("/api/admin/**"), AUTH_ENDPOINTS("/api/auth/**"), TEACHER_ENDPOINT("api/teacher/**");

    private String urlPattern;

    EndPoints(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public String getUrlPattern() {
        return urlPattern;
    }
}
