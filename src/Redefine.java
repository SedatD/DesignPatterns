package tr.com.oyak.muhasebe.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class Redefine extends Object {

//	public String KDALAN = "40";
//	public Redefine KODI1 = new Redefine(this, "KDALAN", "KODI1", 0, 2);
//	public Redefine KODI2 = new Redefine(this, "KDALAN", "KODI2", 2, 4);
//	public Redefine PARA = new Redefine(this, "KDALAN", "PARA", 4, 22);
//	public Redefine PARA2 = new Redefine(this, "KDALAN", "PARA2", 22, 40);
//	
//	KODI1.setValueString("5");
//	String valueString = KODI1.getValueString();
//	KODI2.setValueString("");
//	String valueString2 = KODI2.getValueString();
//	PARA.setValueBigDecimal(new BigDecimal(44));
//	BigDecimal valueBigDecimal = PARA.getValueBigDecimal();

	private Object redefineVariablesOwnerProgram;
	private String redefineName;
	private String redefineVariableName;
	private int startIndex;
	private int endIndex;
	private int totalLenght = 0;

	private Exception exceptionPublic = new Exception("REDEFINE HATASI !!!!!");

	// PARA için redefine kullanılacaksa ondalık noktası için fazladan 1 uzunluk
	// vermek gerekiyor !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public Redefine(Object redefineVariablesOwnerProgram, String redefineName, int startIndex, int endIndex) {
		this.redefineVariablesOwnerProgram = redefineVariablesOwnerProgram;
		this.redefineName = redefineName;
		this.startIndex = startIndex;
		this.endIndex = endIndex;

		initRedifineLenght();
	}

	// redefine variable olarak kullanılan bi input ise bu constructor kullanılır
	// bunun için kullanılan field copy parameters yanına konulması lazım
	public Redefine(Object redefineVariablesOwnerProgram, String redefineName, String redefineVariableName, int startIndex, int endIndex) {
		this.redefineVariablesOwnerProgram = redefineVariablesOwnerProgram;
		this.redefineName = redefineName;
		this.redefineVariableName = redefineVariableName;
		this.startIndex = startIndex;
		this.endIndex = endIndex;

		initRedifineLenght();
	}

	private void initRedifineLenght() {
		try {
			String redifValue = getRedifineValue();

			if (redifValue.trim().equals("")) {
				totalLenght = redifValue.length();
				return;
			}

			try {
				totalLenght = Integer.parseInt(redifValue);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("REDEFINE TANIMLARKEN STRING İÇİNDE UZUNLUĞU GİRİLMELİ !!!!!");
			}

			redifValue = "";
			while (redifValue.length() < totalLenght) {
				redifValue = redifValue + " ";
			}

			Field field = redefineVariablesOwnerProgram.getClass().getField(redefineName);
			field.setAccessible(true);
			field.set(redefineVariablesOwnerProgram, redifValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getRedifineValue() throws Exception {
		try {
			Field field = redefineVariablesOwnerProgram.getClass().getField(redefineName);
			field.setAccessible(true);
			return field.get(redefineVariablesOwnerProgram).toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw exceptionPublic;
		}
	}

	// degeri trimli verir
	public String getValueString() throws Exception {
		try {
			String redifValue = getRedifineValue();
			try {
				return redifValue.substring(startIndex, endIndex).trim();
			} catch (Exception e) {
				while (redifValue.length() < endIndex) {
					redifValue = redifValue + " ";
				}
				return redifValue.substring(startIndex, endIndex).trim();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw exceptionPublic;
		}
	}

	public void setValueString(String value) throws Exception {
		// olması gerekenden uzun gelirse hata atar
		if (value.length() > endIndex - startIndex)
			throw new Exception("REDEFINE SETLENEN DEGER GEREKENDEN UZUN !!!!!");

		// null gelirse init eder
		if (value == null || value.isEmpty() || value.trim().equals(""))
			value = " ";

		// olması gereken lenght den kısa gelirse tamamlar
		while (value.length() < endIndex - startIndex)
			value = value + " ";

		try {
			Field field = redefineVariablesOwnerProgram.getClass().getField(redefineName);
			field.setAccessible(true);

			String redifValue = getRedifineValue();
			String newRedifValue = null;

			// setlendikten sonraki redifine value bulur
			if (startIndex > 0) {
				newRedifValue = redifValue.substring(0, startIndex);
				newRedifValue = newRedifValue + value;
				if (endIndex < redifValue.length()) {
					newRedifValue = newRedifValue + redifValue.substring(endIndex);
				}
			} else if (startIndex == 0) {
				newRedifValue = value;
				if (endIndex < redifValue.length()) {
					newRedifValue = newRedifValue + redifValue.substring(endIndex);
				}
			}

			// setler
			field.set(redefineVariablesOwnerProgram, newRedifValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw exceptionPublic;
		}
	}

	public BigDecimal getValueBigDecimal() throws Exception {
		String value = getValueString();
		if (value.equals(""))
			return FCU.resetBigDecimal(2);
		return new BigDecimal(value.replaceAll(",", ""));
	}

	public void setValueBigDecimal(BigDecimal val) throws Exception {
		setValueString(val.toPlainString().replaceAll(",", ""));
	}

	public int getValueInt() throws Exception {
		String value = getValueString();
		if (value.equals(""))
			return 0;
		return Integer.parseInt(value);
	}

	public void setValueInt(int val) throws Exception {
		setValueString(String.valueOf(val));
	}

	public void setPlain(Redefine redif) throws Exception {
		setValueString(redif.getValueString());
	}

	public String getRedefineVariableName() {
		return redefineVariableName;
	}

}
