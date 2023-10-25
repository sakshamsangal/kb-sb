package com.app.model.swagger;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * Response from getDocumentStatusAPI
 */

@Schema(name = "Student", description = "Response from getDocumentStatusAPI")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Student implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  private String firstName;

  private String lastName;

  /**
   * Default constructor
   * @deprecated Use {@link Student#Student(String)}
   */
  @Deprecated
  public Student() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Student(String id) {
    this.id = id;
  }

  public Student id(String id) {
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

  public Student firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * my description
   * @return firstName
  */
  @Pattern(regexp = "^(?!\\s*$).+") 
  @Schema(name = "firstName", example = "Sample123", description = "my description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Student lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * my description
   * @return lastName
  */
  
  @Schema(name = "lastName", example = "Sangal", description = "my description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return Objects.equals(this.id, student.id) &&
        Objects.equals(this.firstName, student.firstName) &&
        Objects.equals(this.lastName, student.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Student {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
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

