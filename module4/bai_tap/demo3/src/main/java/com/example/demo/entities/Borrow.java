package com.example.demo.entities;

import com.example.demo.dto.BorrowingDto;
import com.example.demo.validator.ReturnDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Borrow")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Borrow {
    @Id
    @GeneratedValue(generator = "generator_borrow_id")
    @GenericGenerator(name = "generator_borrow_id", strategy = "com.example.demo.generator.GeneratorBorrowId")
    String id = "MS-0000";

    @Column(name = "status", columnDefinition = "bit default 1")
    boolean status = true;

    @Column(name = "date_in")
    Date dateIn = Date.valueOf(LocalDate.now());

    @ReturnDate
    @Column(name = "date_out")
    Date dateOut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false, foreignKey = @ForeignKey(name = "fk_book_borrow"))
    private Book book;

//    @NotNull(message = "Not null")
//    @NotBlank(message = "Not blank")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false, foreignKey = @ForeignKey(name = "fk_student_borrow"))
    private Student student;

}
