package problemes.mascotes;

import java.util.Objects;

public class ChipImpl implements Chip {
	
	private static long id=1;
	private Hogar hogar;
	
	public Long getId() {
		return id;
	}
	
	public Hogar getHogar() {
		return hogar;
	}
	
	@Override
	public String toString() {
		return "ChipImpl [id=" + id + ", hogar=" + hogar + "]";
	}
	public ChipImpl(long contador, Hogar hogar) {
		super();
		ChipImpl.id = contador;
		this.hogar = hogar;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChipImpl other = (ChipImpl) obj;
		if (hogar == null) {
			if (other.hogar != null)
				return false;
		} else if (!hogar.equals(other.hogar))
			return false;
		return true;
	}
	
	

	
	

}
