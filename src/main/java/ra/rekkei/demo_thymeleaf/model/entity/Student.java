package ra.rekkei.demo_thymeleaf.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stuId;
    @Column(name = "full_name",length = 50)
    @NotBlank(message = "Full name is empty")
    private String fullName;
    @Column(name = "gender")
    @NotNull(message = "Gender is null")
    private Boolean gender;
    @Column(name = "birthday")
    @NotNull(message = "Birthday is null")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Past(message = "Birthday is not valid")
    private Date birthday;
    @Column(name = "address", length = 200)
    @NotBlank(message = "Address is empty")
    private String address;
    @Column(name = "class_name",length = 100)
    @NotBlank(message = "Class name is empty")
    private String className;
    @Column(name = "avatar")
    private String avatar;
}
