package ru.example.entity;

/**
 *
 * @author Philipp
 */
public enum EnCode {

    /**
     *
     */
    OK(1, "00.Result.OK", "Число найдено"),

    /**
     *
     */
    NOT_FOUND(2, "01.Result.NotFound", "Число не найдено"),

    /**
     *
     */
    ERROR(3, "02.Result.Error", "При выполнении программы возникла ошибка");

    int id;

    String code, description;

    private EnCode(int id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

}
