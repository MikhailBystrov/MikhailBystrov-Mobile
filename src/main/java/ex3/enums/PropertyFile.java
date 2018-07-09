package ex3.enums;

public enum PropertyFile {
    NATIVE("native.properties"),
    WEB("web.properties");

    public String value;

    PropertyFile(String propertyName) {
        this.value = "src\\main\\resources\\" + propertyName;
    }
}
