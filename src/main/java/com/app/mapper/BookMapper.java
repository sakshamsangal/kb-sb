package com.app.mapper;

import com.app.model.jaxb.books.BookForm;
import com.app.model.jaxb.books.BooksForm;
import com.app.model.Student;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @BeanMapping(ignoreByDefault = true)
    BooksForm toBooksForm(Student student);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "id", target = "author")
    BookForm toBookForm(Student student);

    default List<BookForm> toListBookForm(Student student) {
        if (student == null) return Collections.emptyList();
        return List.of(INSTANCE.toBookForm(student));
    }

}