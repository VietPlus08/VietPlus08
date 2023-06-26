package com.example.demo.dto;

import com.example.demo.entities.Borrow;
import com.example.demo.validator.ReturnDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BorrowingDto {
    String id;
    String bookId;
    String bookName;
    String author;
    @NotNull(message = "Not null")
    @NotBlank(message = "Not blank")
    String studentId;
    String studentName;
    String className;
    Date dateIn;
    @ReturnDate
    Date dateOut;

    public BorrowingDto(Borrow borrow) {
        this.id = borrow.getId();
        if (borrow.getBook() != null){
            this.bookId = borrow.getBook().getId();
            this.bookName = borrow.getBook().getName();
            this.author = borrow.getBook().getAuthor();
        }
        if (borrow.getStudent() != null){
            this.studentId = borrow.getStudent().getId();
            this.studentName = borrow.getStudent().getName();
            this.className = borrow.getStudent().getClassName();
        }
        this.dateIn = borrow.getDateIn();
        this.dateOut = borrow.getDateOut();
    }
}
