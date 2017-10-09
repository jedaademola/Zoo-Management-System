package edu.mum.mpp.model;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by Lukman.Arogundade on 1/20/2016.
 */
public class ResponseError {
    @ApiModelProperty(value = "", required = true)
    private String code;
    @ApiModelProperty(value = "", required = true)
    private String description;
    private List<Error> errors;

    public ResponseError() {
    }

    public ResponseError(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the errors
     */
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * @param errors the errors to set
     */
    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
