package war.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.PropertyMetadata;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pszczelarze")
public class Beekeeper extends BaseEntity {

  //  @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String login;

  @Column(nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date startDate;

  @Column(nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date endDate;

  //  @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String wojewodztwo;

  //  @NotBlank
   // @Size(max = 255)
    @Column(nullable = false)
    private Integer ule;

  //  @NotBlank
  //  @Size(max = 255)
    @Column(nullable = false)
    private Integer dzialka;

    @Column
  @Size(max = 2000)
  private String mapa;


}
