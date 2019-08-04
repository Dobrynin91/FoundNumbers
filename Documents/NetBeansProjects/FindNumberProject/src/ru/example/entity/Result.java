package ru.example.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Philipp
 */
@XmlRootElement(name = "result")
public class Result implements Serializable {

    private String code;
    private List<String> fileName = new ArrayList<>();
    private String error;

    /**
     *
     */
    public Result() {
    }

    /**
     *
     * @param code
     * @param fileName
     * @param error
     */
    public Result(String code, List<String> fileName, String error) {
        this.code = code;
        this.fileName = fileName;
        this.error = error;
    }

    public Result(String error) {
        this.error = error;
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
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public List<String> getFileName() {
        return fileName;
    }

    /**
     *
     * @param fileName
     */
    public void setFileName(List<String> fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @return
     */
    public String getError() {
        return error;
    }

    /**
     *
     * @param error
     */
    public void setError(String error) {
        this.error = error;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.code);
        hash = 17 * hash + Objects.hashCode(this.fileName);
        hash = 17 * hash + Objects.hashCode(this.error);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Result other = (Result) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.error, other.error)) {
            return false;
        }
        if (!Objects.equals(this.fileName, other.fileName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Result{" + "code=" + code + ", fileName=" + fileName + ", error=" + error + '}';
    }

}
