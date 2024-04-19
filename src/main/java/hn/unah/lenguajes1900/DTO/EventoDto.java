package hn.unah.lenguajes1900.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventoDto {

    private int disponible;
    private LocalDate fechaEvento;
    private LocalTime horaInicio;
    private String idioma;
    private String formato;
}
