package com.app.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * Response from getDocumentStatusAPI
 */

@Schema(name = "ApplicationResponse", description = "Response from getDocumentStatusAPI")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApplicationResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  /**
   * Default constructor
   * @deprecated Use {@link ApplicationResponse#ApplicationResponse(String)}
   */
  @Deprecated
  public ApplicationResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ApplicationResponse(String id) {
    this.id = id;
  }

  public ApplicationResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * my description
   * @return id
  */
  @NotNull @Pattern(regexp = "^(?!\\s*$).+") 
  @Schema(name = "id", example = "tx123", description = "my description", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplicationResponse applicationResponse = (ApplicationResponse) o;
    return Objects.equals(this.id, applicationResponse.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

