package modelo;

public class CitaMedica {
	private String codigo;
	private String motivo;
	private double costo;
	
	public CitaMedica(String codigo, String motivo, double costo) {
		this.codigo = codigo;
		this.motivo = motivo;
		this.costo = costo;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public double getCosto() {
		return costo;
	}
	
	public String getMotivo() {
		return motivo;
	}

	@Override
	public String toString() {
		return "CitaMedica [codigo=" + codigo + ", motivo=" + motivo + ", costo=" + costo + "]";
	}
	
	
	
}
