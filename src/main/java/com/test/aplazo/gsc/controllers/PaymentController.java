package com.test.aplazo.gsc.controllers;

import com.test.aplazo.gsc.controllers.models.ErrorResponse;
import com.test.aplazo.gsc.controllers.models.ParcelPaymentResponse;
import com.test.aplazo.gsc.controllers.models.PaymentRequest;
import com.test.aplazo.gsc.models.ParcelPayment;
import com.test.aplazo.gsc.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/calculate")
    @ResponseStatus(HttpStatus.OK)
    public List<ParcelPaymentResponse> calculate(@Valid @RequestBody PaymentRequest request) throws Throwable {
        return this.paymentService.calculate(request.toModel())
            .stream().map(ParcelPayment::toResponse).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationExceptions(
        MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), errors);
    }

}
