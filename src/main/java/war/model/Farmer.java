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


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Rolnicy")
public class Farmer extends BaseEntity {

@NotBlank
    @Size(max = 255)
    @Column(unique = true, nullable = false)
    private String login;

    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String wojewodztwo;

    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String uprawa;

    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private double hektary;

    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private int dzialka;


}
