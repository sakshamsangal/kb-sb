package com.app.controller;

import com.app.model.swagger.ApplicationResponse;
import com.app.model.swagger.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;

public interface StudentControllerApi {
    /**
     * GET /{id}/status
     * This API will be used to retrive the document processing status.
     *
     * @return A successful response from the API (status code 200)
     * or Bad Request (status code 400)
     * or Forbidden (status code 403)
     * or Resource not found (status code 404)
     * or Internal Server Error (status code 500)
     */
    @Operation(
            operationId = "idStatusGet",
            description = "This API will be used to retrieve the document processing status.",
            tags = {"get-document-status"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "A successful response from the API", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationResponse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationResponse.class))
                    }),
                    @ApiResponse(responseCode = "403", description = "Forbidden", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationResponse.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Resource not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationResponse.class))
                    })
            },
            security = {
                    @SecurityRequirement(name = "bearer-key")
            }
    )
    ResponseEntity<ApplicationResponse> addStudent(Student stud);
}

