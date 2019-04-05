public class EnumConstantSignature {
	char[] typeName;
	char[] constName;
public EnumConstantSignature(char[] typeName, char[] constName) {
	this.typeName = typeName;
	this.constName = constName;
}

public char[] getTypeName() {
	return this.typeName;
}

public char[] getEnumConstantName() {
	return this.constName;
}
public String toString() {
	StringBuffer buffer = new StringBuffer();
	buffer.append(this.typeName);
	buffer.append('.');
	buffer.append(this.constName);
	return buffer.toString();
}
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + CharOperation.hashCode(this.constName);
	result = prime * result + CharOperation.hashCode(this.typeName);
	return result;
}
public boolean equals(Object obj) {
	if (this == obj) {
		return true;
	}
	if (obj == null) {
		return false;
	}
	if (getClass() != obj.getClass()) {
		return false;
	}
	EnumConstantSignature other = (EnumConstantSignature) obj;
	if (!Arrays.equals(this.constName, other.constName)) {
		return false;
	}
	return Arrays.equals(this.typeName, other.typeName);
}
}