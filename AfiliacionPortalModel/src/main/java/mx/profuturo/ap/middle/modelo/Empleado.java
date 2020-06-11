package mx.profuturo.ap.middle.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    private String apellidoMaterno;
    private String apellidoPaterno;
    private String nombre;
    private String claveConsar;
    private String curp;
    private String fechaAltaConsar;
    private String numeroEmpleado;
    private String userId;
    private String centroCosto;
    private String email;

}
