package BadEjer;

public class LineObj {
    private String nomLoc;
    private String direcc;
    private String codPos;

    private String ciudad;
    private String clienMensual;
    private String tfn;
    private String numero_empleados;
    private String numero_platos_menu;

    public LineObj( ) {
    }

    public LineObj(String nomLoc, String direcc, String codPos, String ciudad, String clienMensual, String tfn, String numero_empleados, String numero_platos_menu) {
        this.nomLoc = nomLoc;
        this.direcc = direcc;
        this.codPos = codPos;
        this.ciudad = ciudad;
        this.clienMensual = clienMensual;
        this.tfn = tfn;
        this.numero_empleados = numero_empleados;
        this.numero_platos_menu = numero_platos_menu;
    }

    @Override
    public String toString() {
        return "BadEjer.LineObj{" +
                "nomLoc='" + nomLoc + '\'' +
                ", direcc='" + direcc + '\'' +
                ", codPos='" + codPos + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", clienMensual='" + clienMensual + '\'' +
                ", tfn='" + tfn + '\'' +
                ", numero_empleados='" + numero_empleados + '\'' +
                ", numero_platos_menu='" + numero_platos_menu + '\'' +
                '}';
    }

    public String getNomLoc() {
        return nomLoc;
    }

    public void setNomLoc(String nomLoc) {
        this.nomLoc = nomLoc;
    }

    public String getDirecc() {
        return direcc;
    }

    public void setDirecc(String direcc) {
        this.direcc = direcc;
    }

    public String getCodPos() {
        return codPos;
    }

    public void setCodPos(String codPos) {
        this.codPos = codPos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getClienMensual() {
        return clienMensual;
    }

    public void setClienMensual(String clienMensual) {
        this.clienMensual = clienMensual;
    }

    public String getTfn() {
        return tfn;
    }

    public void setTfn(String tfn) {
        this.tfn = tfn;
    }

    public String getNumero_empleados() {
        return numero_empleados;
    }

    public void setNumero_empleados(String numero_empleados) {
        this.numero_empleados = numero_empleados;
    }

    public String getNumero_platos_menu() {
        return numero_platos_menu;
    }

    public void setNumero_platos_menu(String numero_platos_menu) {
        this.numero_platos_menu = numero_platos_menu;
    }
}
