package mx.profuturo.ap.middle.modelo.rqt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.profuturo.ap.middle.modelo.in.ActualizaCodaceIn;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActualizaCodaceRqt {

    private ActualizaCodaceIn rqt;

}
