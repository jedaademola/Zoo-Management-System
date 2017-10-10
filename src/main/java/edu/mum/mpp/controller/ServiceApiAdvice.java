package edu.mum.mpp.controller;


import edu.mum.mpp.exceptions.*;
import edu.mum.mpp.model.Response;
import edu.mum.mpp.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice(annotations = RestController.class, basePackages = "edu.mum.mpp.controller")
@ResponseBody
public class ServiceApiAdvice {


    private final static Logger logger = LoggerFactory.getLogger(ServiceApiAdvice.class);


    @ExceptionHandler(LockedException.class)
    @ResponseStatus(value = HttpStatus.LOCKED)
    @ResponseBody
    public Response handleLockedException(LockedException e) {
        Response response = new Response();
        response.setCode(e.getCode());
        response.setDescription(e.getMessage());

        logger.error(e.toString());
        LoggerUtil.logError(logger, e);
        return response;
    }

    @ExceptionHandler(UserLoginException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Response handleLoginException(UserLoginException e) {
        Response response = new Response();
        response.setCode(e.getCode());
        response.setDescription(e.getMessage());

        logger.error(e.toString());
        LoggerUtil.logError(logger, e);
        return response;
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleServletRequestBindingException(ServletRequestBindingException e) {
        Response response = new Response();
        response.setCode("10011");
        response.setDescription("Invalid Credentials");

        logger.error(e.toString());
        LoggerUtil.logError(logger, e);
        return response;
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ResponseBody
    public Response handleCreateUserException(ConflictException e) {
        Response response = new Response();
        response.setCode(e.getCode());
        response.setDescription(e.getMessage());

        logger.error(e.toString());
        LoggerUtil.logError(logger, e);
        return response;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public Response handleNotFoundException(NotFoundException ex) {
        Response response = new Response();
        response.setCode(ex.getCode());
        response.setDescription(ex.getMessage());

        logger.error(ex.toString());
        LoggerUtil.logError(logger, ex);
        return response;
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleNotFoundException(BadRequestException e) {
        Response response = new Response();
        response.setCode(e.getCode());
        response.setDescription(e.getMessage());

        logger.error(e.toString());
        LoggerUtil.logError(logger, e);
        return response;
    }


    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Response handleUnauthorizedException(UnauthorizedException e) {
        Response response = new Response();
        response.setCode(e.getCode());
        response.setDescription(e.getMessage());

        logger.error(e.toString());
        LoggerUtil.logError(logger, e);
        return response;
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ResponseBody
    public Response handleSecurityAccessDenied() {
        Response response = new Response();
        response.setCode("10012");
        response.setDescription("Security: Access Denied");

        logger.error("Access violation: Access Denied Exception");


        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Response handleException(Exception e) {
        Response response = new Response();
        response.setCode("9999");
        response.setDescription("System Error Occurred. Contact System Administrator.");

        logger.error(e.toString());
        LoggerUtil.logError(logger, e);
        return response;
    }

    @ExceptionHandler(FailedRequestException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ResponseBody
    public Response handleFailedRequestException(FailedRequestException e) {
        Response response = new Response();
        response.setCode(e.getCode());
        response.setDescription(e.getMessage());

        logger.error(e.toString());
        LoggerUtil.logError(logger, e);
        return response;
    }

    /*
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
    @ResponseBody
    public Response handleDataInegrityBindingException(DataIntegrityViolationException e) {
        Response response = new Response();
        response.setCode("10011");
        response.setDescription("ID in context not valid");

        logger.error(e.toString());
        LoggerUtil.logError(logger, e);
        return response;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ResponseBody
    public Response handleDuplicateKeyException(DataIntegrityViolationException e) {
        Response response = new Response();
        response.setCode("10012");
        response.setDescription("Duplicate Value not allowed");


        return response;
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleUreadableException(HttpMessageNotReadableException e) {

        Response response = new Response();
        response.setCode("10013");
        response.setDescription(e.getMessage());

        logger.error(e.toString());
        LoggerUtil.logError(logger, e);
        return response;
    }



    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Response handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        Response response = new Response();
        response.setCode(CustomResponseCode.INVALID_REQUEST);
        //  response.setDescription(e.getLocalizedMessage());

        if (e.getCause() != null) {
            String message = e.getCause().getMessage();
            if (e.getCause() instanceof JsonMappingException) {
                String[] arr = message.split("\\(");
                if (arr.length > 0) {
                    String temp = arr[0];
                    String[] arr2 = message.split("\\[");
                    if (arr2.length > 1) {
                        message = temp + " (fieldName: [" + arr2[1];
                    } else {
                        message = temp;
                    }
                }
            }

            if (e.getCause() instanceof JsonParseException) {
                String[] arr = message.split("at");
                if (arr.length > 0) {
                    String temp = arr[0];
                    JsonParseException jpe = (JsonParseException) e.getCause();
                    message = temp + " [line: " + jpe.getLocation().getLineNr() + ", column: " + jpe.getLocation().getColumnNr() + "]";
                }
            }

            response.setDescription(message);
        }


        logger.error(e.toString());
        LoggerUtil.logError(logger, e);
        return response;

    }
                */
}
