package hibernate_beans;
// Generated 2017-4-28 5:44:07 by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ClientAddressId generated by hbm2java
 */
@Embeddable
public class ClientAddressId implements java.io.Serializable {

	private int idAddress;
	private int idClient;

	public ClientAddressId() {
	}

	public ClientAddressId(int idAddress, int idClient) {
		this.idAddress = idAddress;
		this.idClient = idClient;
	}

	@Column(name = "id_address", nullable = false)
	public int getIdAddress() {
		return this.idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	@Column(name = "id_client", nullable = false)
	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ClientAddressId))
			return false;
		ClientAddressId castOther = (ClientAddressId) other;

		return (this.getIdAddress() == castOther.getIdAddress()) && (this.getIdClient() == castOther.getIdClient());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdAddress();
		result = 37 * result + this.getIdClient();
		return result;
	}

}
