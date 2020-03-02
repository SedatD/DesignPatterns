package tr.com.vbt.backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;

import tr.com.oyak.muhasebe.util.FCU;

public class splitSelect {
	private static String dosyaAdi;
	private static StringBuilder selectString;
	private static boolean ekle = false;
	static ArrayList<String> ignore = new ArrayList<String>();
	static ArrayList<String> ignoreMap = new ArrayList<String>();
	private static ArrayList<String> select = new ArrayList<String>();
	private static ArrayList<String> classContent = new ArrayList<String>();;
	private static ArrayList<String> HataliKod5 = new ArrayList<String>();;
	private static ArrayList<String> result = new ArrayList<String>();;
	private static ArrayList<String> rpg = new ArrayList<String>();;
	private static ArrayList<String> motor = new ArrayList<String>();;
	private static ArrayList<String> motorfinds = new ArrayList<String>();;
	private static ArrayList<String> writes = new ArrayList<String>();;
	private static ArrayList<String> callnatparameters = new ArrayList<String>();;
	private static ArrayList<String> paramlist = new ArrayList<String>();;
	private static ArrayList<String> degiskenler = new ArrayList<String>();;
	private static ArrayList<String> pfs = new ArrayList<String>();;
	static HashSet<String> fetchList = new HashSet<>();
	static ArrayList<String> autowi̇redli̇st = new ArrayList<>();
	static ArrayList<String> service = new ArrayList<>();
	static ArrayList<String> serviceImpl = new ArrayList<>();
	Map<String, List<String>> hatali = new HashMap<String, List<String>>();

	static HashSet<String> fetchReturnList = new HashSet<>();
	static HashMap<String, String> pojoList = new HashMap<String, String>();
	static HashMap<String, String> variablelist = new HashMap<String, String>();

	private static JFileChooser chooser;
	private static boolean firstOperation = false;
	private static boolean getAutoInputekle = true;
	private static boolean ekleniyor = true;
	private static boolean start = true;
	private static boolean change = false;
	private static int index;
	private static String var;
	private static int hatalikodsayac = 0;
	private static String methodadi;
	private static String degisken;
	private static String satirsayisi1;
	private static boolean firstRfound;
	private static boolean THRW;
	private static String string;
	private static int method_j;
	private static int paranzKapaSayac;
	private static ArrayList<String> condition;
	private static String duzstring = "";
	private static String ykordinat;
	private static String string___ = "";
	private static String after = "";
	private static boolean mFlag = false;
	private static boolean pf;
	static String parameter = " ";
	private static HashMap<String, ArrayList<String>> servicesBody;
	private static HashMap<String, ArrayList<String>> servicesImplBody;

	public static void main(String[] args) {

		ignore.add("ANAFAIZ");
		ignore.add("ANAPARA");

		ignoreMap.add("IDGMS002");
		ignoreMap.add("IDGMSEHR");

		String saveDir = "";
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("MB-Local-Global");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

			// readrpg();
			// start(chooser.getSelectedFile().listFiles());
			// muhCasebe(chooser.getSelectedFile().listFiles());
			// dsfile(chooser.getSelectedFile().listFiles());
			// convertfile(chooser.getSelectedFile().listFiles());
			// generateService(chooser.getSelectedFile().listFiles());
			// keyfind(chooser.getSelectedFile().listFiles());
			changeCommand(chooser.getSelectedFile().listFiles());
			// javauret(chooser.getSelectedFile().listFiles());
			// createsql(chooser.getSelectedFile().listFiles());
			// convertfile(chooser.getSelectedFile().listFiles());
			// rpg_KOD_ SUZ(chooser.getSelectedFile().listFiles());
		} else {
			System.out.println("No Selection ");
		}
		// firstOperation=false;
		// start(chooser);

	}

	private static void changeCommand(File[] listFiles) {
		
		 servicesBody = new HashMap<String, ArrayList<String>>();
	 servicesImplBody = new HashMap<String, ArrayList<String>>();

	 servicesBody.put("Arahesap"                          , new ArrayList<>());
	 servicesBody.put("Arahesp3"                          , new ArrayList<>());
	 servicesBody.put("Arahespf"                          , new ArrayList<>());
	 servicesBody.put("Aylikmek"                          , new ArrayList<>());
	 servicesBody.put("Aylikmiz"                          , new ArrayList<>());
	 servicesBody.put("Aylikmze"                          , new ArrayList<>());
	 servicesBody.put("Blgtippf"                          , new ArrayList<>());
	 servicesBody.put("Blgtnmpf"                          , new ArrayList<>());
	 servicesBody.put("Cekmuh"                            , new ArrayList<>());
	 servicesBody.put("Cheskodf"                          , new ArrayList<>());
	 servicesBody.put("Conhespf"                          , new ArrayList<>());
	 servicesBody.put("Defterpf"                          , new ArrayList<>());
	 servicesBody.put("Dekont"                            , new ArrayList<>());
	 servicesBody.put("Duzmas"                            , new ArrayList<>());
	 servicesBody.put("Ehes94"                            , new ArrayList<>());
	 servicesBody.put("Emhespf"                           , new ArrayList<>());
	 servicesBody.put("Fiskesen"                          , new ArrayList<>());
	 servicesBody.put("Gecikme"                           , new ArrayList<>());
	 servicesBody.put("Gunmizan"                          , new ArrayList<>());
	 servicesBody.put("Hes3pf"                            , new ArrayList<>());
	 servicesBody.put("Hesfzpf"                           , new ArrayList<>());
	 servicesBody.put("Hespf"                             , new ArrayList<>());
	 servicesBody.put("Ikrazc1"                           , new ArrayList<>());
	 servicesBody.put("Kimlikpf"                          , new ArrayList<>());
	 servicesBody.put("Malkredi"                          , new ArrayList<>());
	 servicesBody.put("Master"                            , new ArrayList<>());
	 servicesBody.put("Mesken"                            , new ArrayList<>());
	 servicesBody.put("Muavinpl"                          , new ArrayList<>());
	 servicesBody.put("Muavinp"                           , new ArrayList<>());
	 servicesBody.put("Muh1kasa"                          , new ArrayList<>());
	 servicesBody.put("Muh2kasa"                          , new ArrayList<>());
	 servicesBody.put("Muhanara"                          , new ArrayList<>());
	 servicesBody.put("Muhana"                            , new ArrayList<>());
	 servicesBody.put("Muhfkkhs"                          , new ArrayList<>());
	 servicesBody.put("Muhfveri"                          , new ArrayList<>());
	 servicesBody.put("Muhmiz"                            , new ArrayList<>());
	 servicesBody.put("Mvhes1"                            , new ArrayList<>());
	 servicesBody.put("Mvhes"                             , new ArrayList<>());
	 servicesBody.put("Sonmizan"                          , new ArrayList<>());
	 servicesBody.put("Tahsilat"                          , new ArrayList<>());
	 servicesBody.put("Tediye"                            , new ArrayList<>());
	 servicesBody.put("Valorpf"                           , new ArrayList<>());
	 servicesBody.put("Yhes94"                            , new ArrayList<>());
	 servicesBody.put("Zmiztemp"                          , new ArrayList<>());		
	 servicesImplBody.put("Arahesap"                          , new ArrayList<>());
	 servicesImplBody.put("Arahesp3"                          , new ArrayList<>());
	 servicesImplBody.put("Arahespf"                          , new ArrayList<>());
	 servicesImplBody.put("Aylikmek"                          , new ArrayList<>());
	 servicesImplBody.put("Aylikmiz"                          , new ArrayList<>());
	 servicesImplBody.put("Aylikmze"                          , new ArrayList<>());
	 servicesImplBody.put("Blgtippf"                          , new ArrayList<>());
	 servicesImplBody.put("Blgtnmpf"                          , new ArrayList<>());
	 servicesImplBody.put("Cekmuh"                            , new ArrayList<>());
	 servicesImplBody.put("Cheskodf"                          , new ArrayList<>());
	 servicesImplBody.put("Conhespf"                          , new ArrayList<>());
	 servicesImplBody.put("Defterpf"                          , new ArrayList<>());
	 servicesImplBody.put("Dekont"                            , new ArrayList<>());
	 servicesImplBody.put("Duzmas"                            , new ArrayList<>());
	 servicesImplBody.put("Ehes94"                            , new ArrayList<>());
	 servicesImplBody.put("Emhespf"                           , new ArrayList<>());
	 servicesImplBody.put("Fiskesen"                          , new ArrayList<>());
	 servicesImplBody.put("Gecikme"                           , new ArrayList<>());
	 servicesImplBody.put("Gunmizan"                          , new ArrayList<>());
	 servicesImplBody.put("Hes3pf"                            , new ArrayList<>());
	 servicesImplBody.put("Hesfzpf"                           , new ArrayList<>());
	 servicesImplBody.put("Hespf"                             , new ArrayList<>());
	 servicesImplBody.put("Ikrazc1"                           , new ArrayList<>());
	 servicesImplBody.put("Kimlikpf"                          , new ArrayList<>());
	 servicesImplBody.put("Malkredi"                          , new ArrayList<>());
	 servicesImplBody.put("Master"                            , new ArrayList<>());
	 servicesImplBody.put("Mesken"                            , new ArrayList<>());
	 servicesImplBody.put("Muavinpl"                          , new ArrayList<>());
	 servicesImplBody.put("Muavinp"                           , new ArrayList<>());
	 servicesImplBody.put("Muh1kasa"                          , new ArrayList<>());
	 servicesImplBody.put("Muh2kasa"                          , new ArrayList<>());
	 servicesImplBody.put("Muhanara"                          , new ArrayList<>());
	 servicesImplBody.put("Muhana"                            , new ArrayList<>());
	 servicesImplBody.put("Muhfkkhs"                          , new ArrayList<>());
	 servicesImplBody.put("Muhfveri"                          , new ArrayList<>());
	 servicesImplBody.put("Muhmiz"                            , new ArrayList<>());
	 servicesImplBody.put("Mvhes1"                            , new ArrayList<>());
	 servicesImplBody.put("Mvhes"                             , new ArrayList<>());
	 servicesImplBody.put("Sonmizan"                          , new ArrayList<>());
	 servicesImplBody.put("Tahsilat"                          , new ArrayList<>());
	 servicesImplBody.put("Tediye"                            , new ArrayList<>());
	 servicesImplBody.put("Valorpf"                           , new ArrayList<>());
	 servicesImplBody.put("Yhes94"                            , new ArrayList<>());
	 servicesImplBody.put("Zmiztemp"                          , new ArrayList<>());
		for (File file : listFiles) {
			change(file);
		}
	}

	private static void change(File file) {

		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";

			HashMap<String, ArrayList<String>> entityList = new HashMap<String, ArrayList<String>>();
			ArrayList<String> javadoc = new ArrayList<String>();
			String prevEntityName = "";
			classContent = new ArrayList<String>();
			variablelist = new HashMap<String, String>();

			while ((line = br.readLine()) != null) {
				classContent.add(line);
			}
			String array_element2 = null;
			int autowiredLine = 0;
			autowi̇redli̇st = new ArrayList<>();
			;
			for (int i = 0; i < classContent.size(); i++) {
				String array_element = classContent.get(i);
				if (array_element.contains("import tr.com.oyak.muhasebe.entity") ) {
					array_element = "import tr.com.oyak.muhasebe.entity.*; import tr.com.oyak.muhasebe.service.*; import org.springframework.beans.factory.annotation.Autowired;\r\n" + 
							"";
					javadoc.add(array_element);
					continue;
				}
				if (array_element.contains("AbstractCommand") && array_element.contains("public")) {
					array_element2 = array_element.split(" ")[2];
					javadoc.add(array_element);
					javadoc.add("");
					javadoc.add("");
					javadoc.add("");
					
					autowiredLine = i + 2;
					continue;
				}
				if (array_element.trim().startsWith("public") || array_element.trim().startsWith("private")) {
					String variable_tip = array_element.split(" ")[1];
					String variable_name = array_element.split(" ")[2].replaceAll(";", "");
					variablelist.put(variable_name, variable_tip);
				}
				String fieldName = null;
				String methodname = null;
				try {
					String split = array_element.split("_")[1];
					fieldName = getFieldName(split);
					methodname = array_element.split("Queries")[1].split(",")[0];
				} catch (Exception e) {
				}
				if (array_element.trim().startsWith("sql_param =")) {

					paramlist.add(array_element);
					javadoc.add( array_element);

					continue;
				}
				if (array_element.trim().startsWith("sql_param")) {
					String sql_param_param_name = array_element.split(" ")[1].replaceAll("\\);", "");
					String sql_param_param_tip = variablelist.get(sql_param_param_name);// sql_param_param_name="HESI"
					if (parameter.trim().equals("")) {
						parameter += sql_param_param_tip + " " + sql_param_param_name;

					} else {
						parameter += ", " + sql_param_param_tip + " " + sql_param_param_name;

					}
					paramlist.add(array_element);
					javadoc.add( array_element);
					continue;
				}

				if (array_element.contains("_LIST") && array_element.contains("entityManager")) {
					if (!autowi̇redli̇st.contains(fieldName))
						autowi̇redli̇st.add(fieldName);

					javadoc.add("ArrayList<" + fieldName + "> " + fieldName + "List =(ArrayList<" + fieldName + ">)" + " " + fieldName + "Service" + methodname + "(sql_param);");

					updateservice(fieldName, methodname, paramlist, parameter);
					updateserviceImpl(fieldName, methodname, paramlist, parameter);

					continue;

				} else if (array_element.contains("_OBJ") && array_element.contains("entityManager")) {
					if (!autowi̇redli̇st.contains(fieldName))
						autowi̇redli̇st.add(fieldName);

					javadoc.add(fieldName + " " + fieldName + "=(" + fieldName + ")" + " " + fieldName + "Service" + methodname + "(sql_param);");
					updateservice(fieldName, methodname, paramlist, parameter);
					updateserviceImpl(fieldName, methodname, paramlist, parameter);

					continue;

				} else if (array_element.contains("_UPDATE") && array_element.contains("entityManager")) {
					if (!autowi̇redli̇st.contains(fieldName))
						autowi̇redli̇st.add(fieldName);

					javadoc.add(fieldName + "Service" + methodname + "(sql_param);");
					updateservice(fieldName, methodname, paramlist, parameter);
					updateserviceImpl(fieldName, methodname, paramlist, parameter);

					continue;

				} else if (array_element.contains("_INSERT") && array_element.contains("entityManager")) {
					if (!autowi̇redli̇st.contains(fieldName))
						autowi̇redli̇st.add(fieldName);

					javadoc.add(fieldName + "Service" + methodname + "(sql_param);");
					updateservice(fieldName, methodname, paramlist, parameter);
					updateserviceImpl(fieldName, methodname, paramlist, parameter);

					continue;

				} else if (array_element.contains("_TRUNCATE") && array_element.contains("entityManager")) {

					javadoc.add(fieldName + "Service" + methodname + "(sql_param);");
					if (!autowi̇redli̇st.contains(fieldName))
						autowi̇redli̇st.add(fieldName);
					updateservice(fieldName, methodname, paramlist, parameter);
					updateserviceImpl(fieldName, methodname, paramlist, parameter);

					continue;

				} else {
					javadoc.add(array_element);
				}

			}
			for (String string : autowi̇redli̇st) {
				javadoc.add(autowiredLine, string + "Service " + string + "Service;");
				javadoc.add(autowiredLine, "@Autowired");

			}
			System.out.println(autowi̇redli̇st);
			autowi̇redli̇st = new ArrayList<>();

			write(javadoc, array_element2 + "");
			// generateServiceImpl(entityList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		br = new BufferedReader(fr);

	}

	private static void addbodyservis(String fieldName, String methodname, String array_element) {
		// TODO Auto-generated method stub
		
	}

	private static void updateservice(String className, String methodname, ArrayList<String> paramlist2, String parameter2) {
		pojoList = new HashMap<String, String>();
		BufferedReader br = null;
		FileReader fr = null;
		if (true)
			return;
		try {
			ArrayList<String> servicedoc = new ArrayList<String>();
			File file = new File("C:\\OYAK_RPG_PROJESI\\OYAK_RPG\\Development\\muhasebe\\src\\main\\java\\tr\\com\\oyak\\muhasebe\\service\\" + className + "Service.java");
			// fr = new
			// FileReader("C:\\CobolPorterWorkspace2\\CobolPorter\\CobolPorter\\MB\\HataliKod5.txt");
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = br.readLine();
			rpg = new ArrayList<String>();
			;
			while ((line = br.readLine()) != null) {// public List<Tafaiz>
				rpg.add(line);

			}
			System.out.println(methodname);
			methodname = methodname.trim().substring(1, methodname.trim().length());
			System.out.println(methodname);

			for (int i = 0; i < rpg.size(); i++) {
				String codeLine = rpg.get(i);
				if (codeLine.contains(methodname + "(Map<String, String> map);")) {
					codeLine = codeLine.replaceAll("Map<String, String> map", parameter2);
					servicedoc.add(codeLine);
					// for (int j = 0; j < paramlist2.size(); j++) {
					// String params = paramlist2.get(j);
					// servicedoc.add(params);
					//
					// }
					continue;
				}
				servicedoc.add(codeLine);

			}
			write(servicedoc, className + "Service", "C:\\OYAK_RPG_PROJESI\\OYAK_RPG\\Development\\muhasebe\\src\\main\\java\\tr\\com\\oyak\\muhasebe\\service\\" + className + "Service.java");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void updateserviceImpl(String className, String methodname, ArrayList<String> paramlist2, String parameter2) {

		pojoList = new HashMap<String, String>();
		BufferedReader br = null;
		FileReader fr = null;
		paramlist = new ArrayList<String>();
		parameter = " ";
		if (true)
			return;
		try {
			ArrayList<String> servicedoc = new ArrayList<String>();
			File file = new File("C:\\OYAK_RPG_PROJESI\\OYAK_RPG\\Development\\muhasebe\\src\\main\\java\\tr\\com\\oyak\\muhasebe\\service\\impl\\" + className + "ServiceImpl.java");
			// fr = new
			// FileReader("C:\\CobolPorterWorkspace2\\CobolPorter\\CobolPorter\\MB\\HataliKod5.txt");
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = br.readLine();
			rpg = new ArrayList<String>();
			;
			while ((line = br.readLine()) != null) {// public List<Tafaiz>
				rpg.add(line);

			}
			methodname = methodname.trim().substring(1, methodname.trim().length());
			for (int i = 0; i < rpg.size(); i++) {
				String codeLine = rpg.get(i);
				if (codeLine.contains(methodname + "(Map<String, String> map)")) {
					codeLine = codeLine.replaceAll("Map<String, String> map", parameter2);
					servicedoc.add(codeLine);
					for (int j = 0; j < paramlist2.size(); j++) {
						String params = paramlist2.get(j);
						servicedoc.add(params);

					}
					continue;
				}
				servicedoc.add(codeLine);

			}
			write(servicedoc, className + "Service",
					"C:\\OYAK_RPG_PROJESI\\OYAK_RPG\\Development\\muhasebe\\src\\main\\java\\tr\\com\\oyak\\muhasebe\\service\\impl\\" + className + "ServiceImpl.java");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void keyfind(File[] listFiles) {
		for (File file : listFiles) {
			keyy(file);
		}

	}

	private static void keyy(File file) {
		pf = false;
		pfs = new ArrayList<>();
		result = new ArrayList<>();

		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";

			boolean prtFlag = false;
			while ((line = br.readLine()) != null) {

				if (line.contains("Type: PF")) {
					pf = true;
				}
				if (line.contains("SKIP") || line.contains("SPACE")) {
					continue;
				}

				result.add(line);

				if (line.trim().startsWith("MEMBER")) {
					dosyaAdi = line.replace("MEMBER", "").replaceAll("\\.", "").trim();

				}

			}
			if (!pf) {
				return;
			}

			for (int i = 0; i < result.size(); i++) {
				String satir = result.get(i);
				String Key = FCU.substring(satir, 24, 25);
				if (Key.trim().equals("K")) {
					pfs.add(FCU.substring(satir, 25, 35));
				}
			}
			if (pfs.size() == 0) {
				System.out.println(dosyaAdi + "->	Key bulunamadı.	");
			} else {
				// System.out.println(dosyaAdi +"-> "+pfs);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println(dosyaAdi);

		br = new BufferedReader(fr);

	}

	private static void prfile(File[] listFiles) {
		for (File file : listFiles) {
			prtfileuret(file);
		}
	}

	private static void prtfileuret(File file) {
		// TODO Auto-generated method stub

	}

	private static void createsql(File[] listFiles) {
		for (File file : listFiles) {
			create(file);
		}
	}

	private static void create(File file) {

		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			int i = 0;
			String line = "";
			result = new ArrayList<>();
			dosyaAdi = file.getName();
			result.add("INSERT INTO XUHL1Y." + dosyaAdi + "	values");
			while ((line = br.readLine()) != null) {// public List<Tafaiz>
				line = "(" + line.replaceAll("\"", "'") + "),";
				result.add(line);
			}

			System.out.println(dosyaAdi);
			write(result, dosyaAdi);

		} catch (Exception e) {
			e.printStackTrace();
		}
		br = new BufferedReader(fr);

	}

	private static void dsfile(File[] listFiles) {
		for (File file : listFiles) {
			converDsFile(file);
		}
	}

	private static void convertfile(File[] listFiles) {
		for (File file : listFiles) {
			converPRTFFile(file);
		}
	}

	private static void generateService(File[] listFiles) {
		for (File file : listFiles) {
			generateService(file);
		}
	}

	private static void generateService(File file) {

		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";

			HashMap<String, ArrayList<String>> entityList = new HashMap<String, ArrayList<String>>();
			ArrayList<String> javadoc = new ArrayList<String>();
			String prevEntityName = "";
			while ((line = br.readLine()) != null) {

				if (!line.contains("String SQL_")) {
					continue;
				}

				String[] split = line.split("_");
				String entityName = split[1].toUpperCase();
				entityName = getFieldName(entityName);
				if (entityName.contains("=")) {
					entityName = entityName.split("=")[0];
					entityName = getFieldName(entityName);
				}

				split = line.split("String ");
				String[] split2 = split[1].split("=");
				String sqlTitle = split2[0];

				ArrayList<String> arrayList = entityList.get(entityName);
				if (arrayList == null) {
					arrayList = new ArrayList<>();
				}
				arrayList.add(sqlTitle);

				entityList.put(entityName, arrayList);

			}

			generateService(entityList);
			// generateServiceImpl(entityList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		br = new BufferedReader(fr);

	}

	private static void generateService(HashMap<String, ArrayList<String>> entityList) {
		String line;
		ArrayList<String> javadoc;
		Iterator it = entityList.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();

			String entityName = (String) pair.getKey();

			ArrayList<String> asd = (ArrayList<String>) pair.getValue();

			javadoc = new ArrayList<String>();
			javadoc.add("package tr.com.oyak.muhasebe.service;");
			javadoc.add("");
			javadoc.add("import java.util.ArrayList;");
			javadoc.add("import java.util.Map;");
			javadoc.add("");
			javadoc.add("import tr.com.oyak.muhasebe.entity." + entityName + ";");
			javadoc.add("");
			javadoc.add("public interface " + entityName + "Service {");
			javadoc.add("");
			for (String sqlTitle : asd) {
				System.out.println(pair.getKey());

				line = sqlTitle;

				if (line.contains("_LIST")) {
					javadoc.add("	public ArrayList<" + entityName + "> " + sqlTitle + "(Map<String, String> map);");
				} else if (line.contains("_OBJ")) {
					javadoc.add("	public " + entityName + " " + sqlTitle + "(Map<String, String> map);");
				} else if (line.contains("_UPDATE")) {
					javadoc.add("	public void " + sqlTitle + "(Map<String, String> map);");
				} else if (line.contains("_INSERT")) {
					javadoc.add("	public void " + sqlTitle + "(Map<String, String> map);");
				} else if (line.contains("_TRUNCATE")) {
					javadoc.add("	public void " + sqlTitle + "(Map<String, String> map);");
				} else {
					javadoc.add("	public " + entityName + " " + sqlTitle + "(Map<String, String> map);");
				}

				javadoc.add("");

			}
			javadoc.add("}");

			write(javadoc, entityName + "Service");

		}
	}

	private static void generateServiceImpl(HashMap<String, ArrayList<String>> entityList) {
		String line;
		ArrayList<String> javadoc;
		Iterator it = entityList.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();

			String entityName = (String) pair.getKey();

			ArrayList<String> asd = (ArrayList<String>) pair.getValue();

			javadoc = new ArrayList<String>();
			javadoc.add("package tr.com.oyak.muhasebe.service.impl;");
			javadoc.add("");
			javadoc.add("import java.util.ArrayList;");
			javadoc.add("import java.util.Map;");
			javadoc.add("");
			javadoc.add("import javax.persistence.EntityManager;");
			javadoc.add("import javax.persistence.PersistenceContext;");
			javadoc.add("");
			javadoc.add("import org.springframework.beans.factory.annotation.Autowired;");
			javadoc.add("import org.springframework.stereotype.Service;");
			javadoc.add("import org.springframework.transaction.PlatformTransactionManager;");
			javadoc.add("");
			javadoc.add("import tr.com.oyak.muhasebe.base.AbstractImpl;");
			javadoc.add("import tr.com.oyak.muhasebe.entity." + getFieldName(entityName) + ";");
			javadoc.add("import tr.com.oyak.muhasebe.service." + entityName + "Service;");
			javadoc.add("import tr.com.oyak.muhasebe.util.Queries;");
			javadoc.add("");
			javadoc.add("@Service");
			javadoc.add("public class " + entityName + "ServiceImpl extends AbstractImpl implements " + getFieldName(entityName) + "Service {");
			javadoc.add("");
			javadoc.add("@PersistenceContext");
			javadoc.add("public EntityManager entityManager;");
			javadoc.add("");
			javadoc.add("@Autowired");
			javadoc.add("public PlatformTransactionManager platformTransactionManager;");
			javadoc.add("");
			for (String sqlTitle : asd) {
				System.out.println(pair.getKey());

				line = sqlTitle;

				javadoc.add("	@Override");

				if (line.contains("_LIST")) {
					javadoc.add("	public ArrayList<" + getFieldName(entityName) + "> " + sqlTitle + "(Map<String, String> map) {");
					javadoc.add(
							"		return (ArrayList<" + getFieldName(entityName) + ">) getQueryResultList(entityManager, Queries." + sqlTitle + ", map, " + getFieldName(entityName) + ".class);");
				} else if (line.contains("_OBJ")) {
					javadoc.add("	public " + getFieldName(entityName) + " " + sqlTitle + "(Map<String, String> map) {");
					javadoc.add("		return (" + getFieldName(entityName) + ") getQueryResult(entityManager, Queries." + sqlTitle + ", map, " + getFieldName(entityName) + ".class);");
				} else if (line.contains("_UPDATE")) {
					javadoc.add("	public void " + sqlTitle + "(Map<String, String> map) {");
					javadoc.add("		updateQuery(entityManager, platformTransactionManager, Queries." + sqlTitle + ", map);");
				} else if (line.contains("_INSERT")) {
					javadoc.add("	public void " + sqlTitle + "(Map<String, String> map) {");
					javadoc.add("		insertQuery(entityManager, platformTransactionManager, Queries." + sqlTitle + ", map);");
				} else if (line.contains("_TRUNCATE")) {
					javadoc.add("	public void " + sqlTitle + "(Map<String, String> map) {");
					javadoc.add("		truncateQuery(entityManager, platformTransactionManager, Queries." + sqlTitle + ");");
				} else {
					javadoc.add("	public " + entityName + " " + sqlTitle + "(Map<String, String> map) {");
					javadoc.add("		return (" + getFieldName(entityName) + ") getQueryResult(entityManager, Queries." + sqlTitle + ", map, " + getFieldName(entityName) + ".class);");
				}

				javadoc.add("	}");

				javadoc.add("");

			}

			javadoc.add("}");

			write(javadoc, entityName + "ServiceImpl");

		}
	}

	private static String getFieldName(String entityName) {
		return entityName.trim().substring(0, 1).toUpperCase() + entityName.trim().substring(1, entityName.trim().length()).toLowerCase();
	}

	private static void converPRTFFile(File file) {

		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";
			duzstring = "";
			result = new ArrayList<>();
			ArrayList<String> javadoc = new ArrayList<String>();
			HashMap<String, String> deisken = new HashMap<>();

			javadoc.add("package tr.com.oyak.muh.print;");
			javadoc.add("");
			javadoc.add("import java.math.BigDecimal;");
			javadoc.add("");
			javadoc.add("import tr.com.oyak.muh.PrinterDesign;");
			javadoc.add("import tr.com.oyak.muh.utils.FCU;");
			javadoc.add("");

			boolean prtFlag = false;
			while ((line = br.readLine()) != null) {

				if (line.contains("Type:") && !line.contains("Type: PRTF")) {
					return;
				}

				if (line.contains("SKIP") || line.contains("SPACE")) {
					prtFlag = true;
				}

				result.add(line);

				if (line.trim().startsWith("MEMBER")) {
					dosyaAdi = line.replace("MEMBER", "").replaceAll("\\.", "").trim();

				}

			}

			if (!prtFlag)
				return;

			javadoc.add("public class " + dosyaAdi + " extends PrinterDesign {");
			javadoc.add("");
			try {
				firstRfound = false;
				for (int j = 0; j < result.size(); j++) {

					string = result.get(j);

					// if (string.length() < 50) {
					// continue;
					// }

					String yildiz = string.substring(14, 15);
					if (!yildiz.trim().equals("")) {
						continue;
					}

					String r = "";
					try {
						r = string.substring(24, 25);
					} catch (Exception e) {
						System.out.println("r bulamadı");
						continue;
					}

					if ((firstRfound && r.equals("R")) || string.contains("E N D  O F  S O U R C E")) { // 2.r
						// deisken;
						// method_j=10
						if (!after.equals(""))
							javadoc.add(after);
						javadoc.add("	}");
						after = "";
						String method = javadoc.get(method_j - 1);
						String PARAMETRE = "";
						Iterator it = deisken.entrySet().iterator();
						while (it.hasNext()) {
							Map.Entry pair = (Map.Entry) it.next();
							PARAMETRE += (String) pair.getValue() + " ,";

							it.remove(); // avoids a ConcurrentModificationException
						}
						if (!PARAMETRE.equals("")) {
							PARAMETRE = PARAMETRE.substring(0, PARAMETRE.length() - 1);
							method = method.replaceAll("PARAMETRE", PARAMETRE);
							javadoc.set(method_j - 1, method);
						}

						deisken = new HashMap<>();
					}

					if (string.contains("E N D  O F  S O U R C E")) {
						break;
					}
					if (string.substring(15, 45).trim().equals("") && string.contains("EDTWRD")) {
						continue;
					}
					if (r.equals("R")) {
						mFlag = true;
						THRW = false;
						firstRfound = true;
						if (string.length() < 33) {
							string = string + "                                  ";
						}
						methodadi = string.substring(26, 34);
						javadoc.add("	public void " + methodadi + "(PARAMETRE) {");
						method_j = javadoc.size();
						javadoc.add("");
					}

					if (string.contains("SKIPA") || string.contains("SPACEA")) {
						// record altındaysa recordun biiit gi yere yoksa aynı yere.
						if (mFlag) {
							String substring = FCU.substring(string, 52, 100);
							after += "		" + substring.trim().replace("0", "") + " ;";

						} else {
							String substring = FCU.substring(string, 52, 100);
							javadoc.add("		" + substring.trim().replace("0", "") + " ;");
						}

					}

					if (string.contains("SKIPB") || string.contains("SPACEB")) {
						String substring = FCU.substring(string, 52, 100);
						javadoc.add(javadoc.size() - 1, "		" + substring.trim().replace("0", "") + " ;");
						// bir yukari;

					}
					mFlag = false;
					if (r.equals("R")) {
						continue;
					}
					if (string.contains("PAGNBR")) {// PAGNBR
						if (!string___.trim().equals("")) {
							javadoc.add("		text(\"" + string___ + "\", " + "-1" + " , x_kor , " + ykordinat + ");");
							// degisken int sola yanasık
							string___ = "";
						}
						String sutunsayisi = string.substring(49, 52);
						if (sutunsayisi.contains("+")) {
							ykordinat = "y_kor" + sutunsayisi;
						} else {
							ykordinat = sutunsayisi;
						}
						javadoc.add("		text(PAGNBR(), " + "-1" + " , x_kor , " + ykordinat + ");");

					}
					if (string.contains("EDTCDE")) {
						String substring = FCU.substring(string, 52, 100).split("EDTCDE")[1];

						javadoc.add("		EDTCDE" + substring.trim().replace("0", "").replace("(", "(\"").replace(")", "\")") + " ;");

					}

					if (string.contains("TIME")) {
						String sutunsayisi = string.substring(49, 52);
						if (sutunsayisi.contains("+")) {
							ykordinat = "y_kor" + sutunsayisi;
						} else {
							ykordinat = sutunsayisi;
						}
						String substring = string.substring(52, 100);
						javadoc.add("		text(TIME(), " + "-1" + " , x_kor , " + ykordinat + ");");
						continue;

					}

					String degisken = string.substring(26, 34);
					String degisken_uzunlugu = string.substring(39, 42);
					String degisken_ondalıgı = string.substring(44, 45);
					String current = string.substring(49, 52);
					String satiryazisi = FCU.substring(string, 52, 100);
					String neext_satiryazisi = FCU.substring(result.get(j + 1), 52, 100);
					if (!current.trim().equals("")) {
						if (current.contains("+")) {
							ykordinat = "y_kor" + current;
						} else {
							ykordinat = current;
						}
					}

					if (!degisken.trim().equals("") && degisken_ondalıgı.trim().equals("0") && neext_satiryazisi.contains("EDTCDE(Z)")) {
						javadoc.add("		text(FCU.basaBoslukEkleStr(" + degisken + "," + degisken_uzunlugu + "), " + degisken_uzunlugu + " , x_kor , " + ykordinat + ");");
						// degisken int saga yanasık
						deisken.put(degisken, "	 int " + degisken);

						continue;
					}
					if (!degisken.trim().equals("") && degisken_ondalıgı.trim().equals("0") && neext_satiryazisi.contains("EDTWRD")) {
						javadoc.add("		text(FCU.EDTWRD(FCU.basaSifirEkleStr(" + degisken + "," + degisken_uzunlugu + ")," + neext_satiryazisi.replace("EDTWRD", "").trim().replace("'", "\"")
								+ "), " + degisken_uzunlugu + " , x_kor , " + ykordinat + ");");
						// degisken int saga yanasık
						deisken.put(degisken, "	 int " + degisken);
						j++;
						continue;
					}
					if (!degisken.trim().equals("") && degisken_ondalıgı.trim().equals("0")) {
						javadoc.add("		text(" + degisken + "+\"\"," + degisken_uzunlugu + " , x_kor , " + ykordinat + ");");
						// degisken int sola yanasık
						deisken.put(degisken, "	 int " + degisken);
						continue;
					}
					if (!degisken.trim().equals("") && degisken_ondalıgı.trim().equals("")) {
						javadoc.add("		text(" + degisken + ", " + degisken_uzunlugu + " , x_kor , " + ykordinat + ");");
						// degisken int sola yanasık

						deisken.put(degisken, "	 String " + degisken);

						continue;

					}
					if (!degisken.trim().equals("") && !degisken_ondalıgı.trim().equals("") && !degisken_ondalıgı.trim().equals("0")) {
						javadoc.add("		text(FCU.tlAyarlaStr(" + degisken + "," + degisken_ondalıgı + "), " + degisken_uzunlugu + "+" + degisken_ondalıgı + " , x_kor , " + ykordinat + ");");
						// degisken para
						deisken.put(degisken, "	 BigDecimal " + degisken);
						if (neext_satiryazisi.contains("EDTWRD"))
							j++;
						continue;

					}

					if (satiryazisi.contains("'") || satiryazisi.trim().endsWith("-")) {
						String string2 = "";
						if (satiryazisi.startsWith("'"))
							string2 = satiryazisi.split("'")[1];
						else if (satiryazisi.trim().endsWith("'"))
							string2 = satiryazisi.split("'")[0];

						else
							string2 = satiryazisi;

						if (string2.trim().endsWith("-")) {
							string2 = FCU.sondanbosluksil(string2);
							string___ += string2.substring(0, string2.length() - 1);
							continue;
						} else {
							string___ += string2;

						}

						javadoc.add("		text(\"" + string___ + "\", " + "-1" + " , x_kor , " + ykordinat + ");");
						// degisken int sola yanasık
						string___ = "";
						continue;
					}

					System.out.println(string);

				}

				javadoc.add("");
				javadoc.add("}");

			} catch (Exception e) {
				System.out.println(string);
				e.printStackTrace();
			}

			System.out.println(dosyaAdi);
			write(javadoc, dosyaAdi);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(fr);

	}

	private static String stringrec() {
		return degisken;
		// TODO Auto-generated method stub

	}

	private static void converDsFile(File file) {

		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			int i = 0;
			String line = "";
			result = new ArrayList<>();
			ArrayList<String> javadoc = new ArrayList<String>();
			ArrayList<String> methodici = new ArrayList<String>();
			HashMap<String, String> deisken = new HashMap<>();

			javadoc.add("package tr.com.oyak.muh.dis.pre;");
			javadoc.add("");
			javadoc.add("import java.util.ArrayList;");
			javadoc.add("import java.util.HashMap;");
			javadoc.add("");
			javadoc.add("import tr.com.oyak.muh.model.*;");
			javadoc.add("import tr.com.oyak.muh.utils.FiledType;");
			javadoc.add("import tr.com.oyak.muh.utils.AppConstants;");
			javadoc.add("");
			while ((line = br.readLine()) != null) {// public List<Tafaiz>
													// TAFAIZ_RESULT_LIST;
				if (line.contains("Type: LF")) {
					return;
				}
				if (line.contains("Type: PF")) {
					return;
				}
				if (line.contains("Type: PRTF")) {
					return;
				}
				if (line.contains("SKIPB") || line.contains("SPACEA") || line.contains("SKIPA")) {
					return;
				}

				result.add(line);
				if (line.trim().startsWith("MEMBER")) {
					dosyaAdi = line.replace("MEMBER", "").replaceAll("\\.", "").trim();
				}
			}

			javadoc.add("public class " + dosyaAdi + " {");
			javadoc.add("");
			javadoc.add("	static VaadinFeatures vaadinFeatures=new VaadinFeatures(AppConstants.L, AppConstants.L);");
			javadoc.add("");

			try {
				firstRfound = false;
				paranzKapaSayac = 0;
				for (int j = 0; j < result.size(); j++) {
					string = result.get(j);
					if (string.length() < 20) {
						string += "                                                                                                     ";
					}
					String yildiz = string.substring(14, 15);
					if (!yildiz.trim().equals("")) {
						continue;
					}

					String r = "";
					try {
						r = string.substring(24, 25);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("r bulamadı");
					}
					if ((firstRfound && r.equals("R")) || string.contains("E N D  O F  S O U R C E")) { // 2.r
						if (THRW) {
							javadoc.add(method_j, "			if (");
							for (int k = 0; k < condition.size(); k++) {
								javadoc.add(method_j + k + 1, condition.get(k));
							}
							javadoc.add(method_j + condition.size() + 1, "			false) {");
							javadoc.add("			screenModel.setMatris(matris);");
							javadoc.add("			throw new ThrowData(screenModel);");
							javadoc.add("	}");
						}
						javadoc.add("				return matris;");

						javadoc.add("		}");

					}
					if (string.contains("E N D  O F  S O U R C E")) {// 2.r
						continue;
					}

					if (string.contains("71TIME")) {
						javadoc.add("				matris.add(new DataModel(" + 71 + ", FiledType.LABEL," + "TIME" + ", vaadinFeatures, false));");
						continue;
					}

					if (string.contains("GUN")) {
						System.out.println();
					}
					if (string.contains("CHECK")) {
						javadoc.add("			//" + string);

					}

					if (r.equals("R")) {
						condition = new ArrayList<>();

						THRW = false;
						firstRfound = true;
						if (string.length() < 33) {
							string = string + "                                  ";
						}
						methodadi = string.substring(26, 33);
						javadoc.add("	public static ArrayList<DataModel> " + methodadi + "(ScreenModel screenModel) {");
						javadoc.add("");
						javadoc.add("		ArrayList<DataModel> matris = screenModel.getMatris();");
						javadoc.add("		HashMap<String, String> paramater =  screenModel.getParamaters();");
						javadoc.add("");
						method_j = javadoc.size();
						javadoc.add("");
						javadoc.add("");
						javadoc.add("");

						continue;
					}

					if (string.length() < 46) {
						string += "                                                                    ";
					}
					if (!r.equals("R") && !string.substring(26, 35).trim().equals("") && (string.substring(45, 46).trim().equals("I"))) { // değişken
						// tanımı
						degisken = string.substring(26, 35);
						if (!string.substring(47, 49).trim().equals("")) {
							satirsayisi1 = string.substring(47, 49);
						}

						THRW = true;
						try {
							// javadoc.add(method_j, " if (");
							condition.add("				paramater.get(\"" + degisken.trim() + "\")  == null ||");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						deisken.put(degisken, "	public static String " + degisken + ";");

						String minValue = "-1";
						String maxValue = "-1";
						String inputLenght = "-1";
						boolean isNumeric = false;

						if (string.substring(42, 44).trim().contains("D") || string.substring(42, 44).trim().contains("Y")) {
							isNumeric = true;
						}

						if (!string.substring(40, 42).trim().equals("")) {
							try {
								Integer.parseInt(string.substring(40, 42).trim());
								inputLenght = string.substring(40, 42);
							} catch (Exception e) {

							}
						}

						if (string.contains("RANGE")) {
							String arasi = string.split("RANGE")[1].split("\\)")[0].replace("(", "").replaceAll("'", "");
							minValue = arasi.split(" ")[0];
							maxValue = arasi.split(" ")[1];
						}

						if (string.contains("EDTCDE(2)") || string.substring(44, 45).trim().equals("2")) {
							javadoc.add("			matris.add(new DataModel(" + satirsayisi1 + ", FiledType.TEXTFIELD, \"" + degisken.trim() + "\", vaadinFeatures, " + inputLenght + "," + "\"\""
									+ "," + isNumeric + "," + minValue + "," + maxValue + ",true));");
						} else
							javadoc.add("			matris.add(new DataModel(" + satirsayisi1 + ", FiledType.TEXTFIELD, \"" + degisken.trim() + "\", vaadinFeatures, " + inputLenght + "," + "\"\""
									+ "," + isNumeric + "," + minValue + "," + maxValue + "));");

					}
					if (!r.equals("R") && !string.substring(26, 35).trim().equals("") && (string.substring(45, 46).trim().equals("B"))) { // değişken
						// tanımı
						degisken = string.substring(26, 35);
						if (!string.substring(47, 49).trim().equals("")) {
							satirsayisi1 = string.substring(47, 49);
						}

						THRW = true;
						try {
							// javadoc.add(method_j, " if (");
							condition.add("				paramater.get(\"" + degisken.trim() + "\")  == null ||");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						deisken.put(degisken, "	public static String " + degisken + ";");

						String minValue = "-1";
						String maxValue = "-1";
						String inputLenght = "-1";
						boolean isNumeric = false;

						if (string.substring(42, 44).trim().contains("D") || string.substring(42, 44).trim().contains("Y")) {
							isNumeric = true;
						}

						if (!string.substring(40, 42).trim().equals("")) {
							try {
								Integer.parseInt(string.substring(40, 42).trim());
								inputLenght = string.substring(40, 42);
							} catch (Exception e) {

							}
						}

						if (string.contains("RANGE")) {
							String arasi = string.split("RANGE")[1].split("\\)")[0].replace("(", "").replaceAll("'", "");
							minValue = arasi.split(" ")[0];
							maxValue = arasi.split(" ")[1];
						}

						if (string.contains("EDTCDE(2)") || string.substring(44, 45).trim().equals("2")) {
							javadoc.add("			matris.add(new DataModel(" + satirsayisi1 + ", FiledType.TEXTFIELD, \"" + degisken.trim() + "\", vaadinFeatures, " + inputLenght + "," + degisken
									+ "," + isNumeric + "," + minValue + "," + maxValue + ",true));");
						} else
							javadoc.add("			matris.add(new DataModel(" + satirsayisi1 + ", FiledType.TEXTFIELD, \"" + degisken.trim() + "\", vaadinFeatures, " + inputLenght + "," + degisken
									+ "," + isNumeric + "," + minValue + "," + maxValue + "));");

					}

					if (!r.equals("R") && !string.substring(26, 35).trim().equals("") && string.substring(45, 46).trim().equals("O")) { // değişken kendisi yazılır
						degisken = string.substring(26, 35);
						if (!string.substring(47, 49).trim().equals("")) {
							satirsayisi1 = string.substring(47, 49);
						}
						boolean isBold = false;
						if (string.contains("DSPATR")) {
							isBold = true;
						}
						deisken.put(degisken, "	public static String " + degisken + ";");
						javadoc.add("				matris.add(new DataModel(" + satirsayisi1 + ", FiledType.LABEL," + degisken + ", vaadinFeatures," + isBold + "));");
					}
					if (string.substring(26, 33).trim().equals("") && !string.substring(47, 49).trim().equals("")) { // sağdaki
																														// string
						if (!string.substring(47, 49).trim().equals("")) {
							satirsayisi1 = string.substring(47, 49);
						}
						String substring = string.split("'")[1];
						if (substring.length() > 60) {
							substring = substring.substring(0, 60);
						}
						boolean isBold = false;
						if (string.contains("DSPATR(HI)")) {
							isBold = true;
						}

						if (substring.trim().endsWith("-") && result.get(j + 1).substring(26, 33).trim().equals("")) {
							String local = result.get(j + 1).substring(52).split("'")[0];
							try {
								javadoc.add("			matris.add(new DataModel(" + satirsayisi1 + ", FiledType.LABEL, \"" + substring.trim().substring(0, substring.trim().length() - 1).trim() + " "
										+ local + "\",  vaadinFeatures," + isBold + "));");
							} catch (Exception e) {
								e.printStackTrace();
							}

						} else
							javadoc.add("			matris.add(new DataModel(" + satirsayisi1 + ", FiledType.LABEL, \"" + substring + "\", vaadinFeatures," + isBold + "));");
					}

				}

				// Iterator it = deisken.entrySet().iterator();
				// while (it.hasNext()) {
				// Map.Entry pair = (Map.Entry) it.next();
				// javadoc.add(10, (String) pair.getValue());
				//
				// it.remove(); // avoids a ConcurrentModificationException
				// }

				javadoc.add("");
				javadoc.add("}");

			} catch (Exception e) {
				System.out.println(string);
				e.printStackTrace();
			}

			System.out.println(dosyaAdi);
			write(javadoc, dosyaAdi);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(fr);

	}

	private static void javauret(File[] listFiles) {
		for (int i = 0; i < listFiles.length; i++) {
			String name = listFiles[i].getName().replace(".txt", "");
			dosyauret(name);
		}

	}

	private static void dosyauret(String name) {

		ArrayList<String> javadoc = new ArrayList<>();
		javadoc.add("package tr.com.oyak.muh.cmd.pre;");
		javadoc.add("");
		javadoc.add("import java.math.BigDecimal;");
		javadoc.add("import java.util.ArrayList;");
		javadoc.add("import java.util.HashMap;");
		javadoc.add("");
		javadoc.add("import org.slf4j.Logger;");
		javadoc.add("import org.slf4j.LoggerFactory;");
		javadoc.add("");
		javadoc.add("import tr.com.oyak.muh.MuhException;");
		javadoc.add("");
		javadoc.add("import tr.com.oyak.muh.entity.*;");
		javadoc.add("import tr.com.oyak.muh.dis.pre.*;");
		javadoc.add("import tr.com.oyak.muh.printfile.*;");
		javadoc.add("import tr.com.oyak.muh.model.*;");
		javadoc.add("");
		javadoc.add("import tr.com.oyak.muh.AbstractCommand;");
		javadoc.add("import tr.com.oyak.muh.Author;");
		javadoc.add("import tr.com.oyak.muh.Command;");
		javadoc.add("import tr.com.oyak.muh.utils.AppConstants;");
		javadoc.add("import tr.com.oyak.muh.utils.CommandType;");
		javadoc.add("import tr.com.oyak.muh.utils.FiledType;");
		javadoc.add("import tr.com.oyak.muh.utils.FCU;");
		javadoc.add("import tr.com.oyak.muh.utils.Queries;");
		javadoc.add("");
		javadoc.add("public class " + name + " extends AbstractCommand implements Command {");
		javadoc.add("");
		javadoc.add("	@Author(");
		javadoc.add("	 	name = \"\",");
		javadoc.add("		date = \"\"");
		javadoc.add("			)");
		javadoc.add("");
		javadoc.add("	private static final Logger logger = LoggerFactory.getLogger(" + name + ".class);");
		javadoc.add("	private VaadinFeatures vaadinFeatures = new VaadinFeatures(AppConstants.L, AppConstants.L);");
		javadoc.add("");
		javadoc.add("	public " + name + "() {");
		javadoc.add("		super(CommandType." + name + ");");
		javadoc.add("	}");
		javadoc.add("");
		javadoc.add("	@Override");
		javadoc.add("	public Object execute(ScreenModel screenModel) throws MuhException {");
		javadoc.add("		super.execute(screenModel);");
		javadoc.add("		logger.debug(\"execute\");");
		javadoc.add("		try {");
		javadoc.add("			copyParameters(screenModel.getParamaters());");
		javadoc.add("			rpg();");
		javadoc.add("		} catch (ThrowData e) {");
		javadoc.add("			throw  e;");
		javadoc.add("		} catch (Exception e) {");
		javadoc.add("			e.printStackTrace();");
		javadoc.add("			logger.debug(e.getMessage(), e);");
		javadoc.add("			matris=	FCU.ScreenMessage(e);");
		javadoc.add("		}");
		javadoc.add("		screenModel.setMatris(matris);");
		javadoc.add("		return screenModel;");
		javadoc.add("	}");
		javadoc.add("");
		javadoc.add("	@SuppressWarnings(\"unchecked\")");
		javadoc.add("	private void rpg() {");
		javadoc.add(" 		//TODO ÇEVRİLEN KODLAR BURAYA YAZILACAK");
		javadoc.add("");
		javadoc.add("		//matris.addAll(MVNBBBEK.EKR4(screenModel));");
		javadoc.add("");
		javadoc.add("		//örnek sql");
		javadoc.add("		//sql_param = new HashMap<String, String>();");
		javadoc.add("		//sql_param.put(\"HESX\", HESX);");
		javadoc.add("		//YHES94 = (Yhes94) getQueryResult(Queries.MVNBBBB_1, sql_param, Yhes94.class);");
		javadoc.add("");
		javadoc.add("		//MUAVMH_LIST = (ArrayList<Muhana>) getQueryResultList(Queries.MVNBBBB_2, sql_param, Muhana.class);");
		javadoc.add("");
		javadoc.add("");
		javadoc.add("");
		javadoc.add("");
		javadoc.add("");
		javadoc.add("");
		javadoc.add("	}");
		javadoc.add("");
		javadoc.add("}");
		javadoc.add("");

		write(javadoc, name);
	}

	private static void write(ArrayList<String> javadoc, String string) {
		try {
			PrintWriter writer = null;
			writer = new PrintWriter(System.getProperty("user.home") + "/Desktop/output/" + string + ".java", "UTF-8");

			for (int i = 0; i < javadoc.size(); i++) {
				writer.println(javadoc.get(i));

			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void write(ArrayList<String> javadoc, String string, String Path) {
		try {
			PrintWriter writer = null;
			writer = new PrintWriter(Path);

			for (int i = 0; i < javadoc.size(); i++) {
				writer.println(javadoc.get(i));

			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void rpg(File[] listFiles) {

		try {
			for (String codeName : rpg) {

				dosyadavar(listFiles, codeName);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void readrpg() {
		pojoList = new HashMap<String, String>();
		BufferedReader br = null;
		FileReader fr = null;
		try {
			// fr = new
			// FileReader("C:\\CobolPorterWorkspace2\\CobolPorter\\CobolPorter\\MB\\HataliKod5.txt");
			fr = new FileReader("C:\\Users\\Asligul\\Desktop\\DSPF_PF_PRTF.TXT");
			br = new BufferedReader(fr);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {// public List<Tafaiz>
				rpg.add(line);

			}

			muhasebeAYIR();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static boolean dosyadavar(File[] listFiles, String line) {
		for (File file : listFiles) {
			if (line.contains(file.getName().replaceAll(".txt", ""))) {
				// System.out.println("var" + line);
				return true;
			}
		}
		System.out.println(line);

		return false;
	}

	private static void muhasebe(File[] selectedFile) {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(selectedFile[0]);
			br = new BufferedReader(fr);
			int i = 0;
			String line = "";
			while ((line = br.readLine()) != null) {// public List<Tafaiz>
													// TAFAIZ_RESULT_LIST;

				result.add(line);
				if (line.trim().startsWith("MEMBER")) {
					dosyaAdi = line.replace("MEMBER", "").replaceAll("\\.", "").trim();
				}
				if (line.contains("PAGE    1")) {
					try {
						if (result.size() < 2) {
							continue;
						}
						result.remove(result.size() - 1);
						writeToFile(result);
						result = new ArrayList<>();
						result.add(line);

					} catch (Exception e) {
						System.out.println(line);
						e.printStackTrace();
					}
				}

			}
			for (String dosyaadi : rpg) {
				System.out.println(dosyaadi);
			}

			System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
	}

	private static void muhasebeAYIR() {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			// fr = new FileReader(selectedFile[0]);
			br = new BufferedReader(fr);
			int i = 0;
			String line = "";
			while ((line = br.readLine()) != null) {// public List<Tafaiz>
				// TAFAIZ_RESULT_LIST;

				result.add(line);
				if (line.trim().startsWith("MEMBER")) {
					dosyaAdi = line.replace("MEMBER", "").replaceAll("\\.", "").trim();
				}
				if (line.contains("PAGE    1")) {
					try {
						if (result.size() < 2) {
							continue;
						}
						result.remove(result.size() - 1);
						if (dosyadavar(rpg, dosyaAdi))
							writeToFile(result);
						result = new ArrayList<>();
						result.add(line);

					} catch (Exception e) {
						System.out.println(line);
						e.printStackTrace();
					}
				}

			}
			for (String dosyaadi : rpg) {
				System.out.println(dosyaadi);
			}

			System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
	}

	private static boolean dosyadavar(ArrayList<String> rpg2, String dosyaAdi) {
		for (String program : rpg2) {
			if (program.contains(dosyaAdi.replaceAll(".txt", ""))) {
				// System.out.println("var" + program);
				rpg2.remove(program);

				return true;
			}
		}

		return false;
	}

	private static void readhata5() {
		// TODO Auto-generated method stub
		// classContent = new ArrayList<>();
		pojoList = new HashMap<String, String>();
		BufferedReader br = null;
		FileReader fr = null;
		try {
			// fr = new
			// FileReader("C:\\CobolPorterWorkspace2\\CobolPorter\\CobolPorter\\MB\\HataliKod5.txt");

			fr = new FileReader("C:\\CobolPorterWorkspace2_TCMB\\CobolPorter\\CobolPorter\\IDGIDBSWP\\src\\main\\java\\tr\\com\\mb\\web\\AbstractNaturalIsciDovizleriProgram.java");
			br = new BufferedReader(fr);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {// public List<Tafaiz>
													// TAFAIZ_RESULT_LIST;

				if (line.contains("_RESULT_LIST") && !line.trim().startsWith("//")) {
					try {
						String pojotip = line.split("<")[1].split(">")[0];
						String resullisttip = line.split("<")[1].split(">")[1].replaceAll(";", "").trim();
						pojoList.put(resullisttip, pojotip);
						// System.out.println();
					} catch (Exception e) {
						System.out.println(line);
						e.printStackTrace();
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void POJOOKU() {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		FileReader fr = null;
		try {

			fr = new FileReader("C:\\CobolPorterWorkspace2_TCMB\\CobolPorter\\CobolPorter\\IDGIDBSWP\\src\\main\\java\\tr\\com\\mb\\web\\AbstractNaturalIsciDovizleriProgram.java");
			br = new BufferedReader(fr);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void start(File[] files) {

		for (File file : files) {
			addNew(file);
		}

		// firstOperation = true;
		// index=0;
		// for (File file : files) {
		// executeCahnge(file);
		// // operatechangeStr(file);
		// //subprogramchange(file);
		//// findreinput(file);
		//
		// }
		// // for (File file : files) {
		// // operate(file);
		// //
		// // }
		// // firstOperation = false;
		// //
		// // for (File file : files) {
		// // operate(file);
		// //
		// // }
	}

	private static void addNew(File file) {
		if (file.isFile()) {
			if (file.getAbsolutePath().contains("menu")) {

				add(file);
			}
		}
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				addNew(file2);
			}
		}
	}

	private static void add(File file) {

		System.out.println(file.getName());
		classContent = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;
		int hatasirasi = 0;
		int hatasize = 0;
		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(file));

			String line;
			while ((line = br.readLine()) != null) {
				classContent.add(line);
			}

			for (int i = 0; i < classContent.size(); i++) {
				String lin = classContent.get(i);
				lin = lin.replaceAll(" ", "");
				if (lin.contains("_RESULT_LIST") && lin.contains("_RESULT_LIST.size") && lin.contains("null")) {
					lin = lin + "           " + getPojo(lin);
					classContent.set(i, lin);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------------------------------------");

		write(file.getAbsolutePath());

	}

	private static String getPojo(String lin) {// if (TMUSNO_RESULT_LIST == null
												// || TMUSNO_RESULT_LIST.size()
												// == 0) {
		String pojo = lin.split("_RESULT_LIST")[0].split("\\(")[1];

		String val = pojo + "= new  " + pojoList.get(pojo + "_RESULT_LIST") + " ();";
		// System.out.println();
		return val;
	}

	private static void executeCahnge(File file) {
		if (file.isFile()) {

			if (file.getAbsolutePath().contains("mb")) {
				Replace(file);

			}

		}
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				// System.out.print("-");
				executeCahnge(file2);
			}
		}
	}

	private static void Replace(File file) {

		classContent = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;
		int hatasirasi = 0;
		int hatasize = 0;
		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				classContent.add(line);
				line = line.replaceAll(" ", "");
				if (line.contains("IOModeType.AD_MI_,0,")) {
					hatasize++;
				}

			}
			if (hatasize == 0) {
				return;
			}
			boolean dosyaadi = false;
			for (int i = 0; i < classContent.size(); i++) {
				String lin = classContent.get(i);
				lin = lin.replaceAll(" ", "");
				if (lin.contains("IOModeType.AD_MI_,0,")) {

					var = getVar(file.getName(), hatasirasi, hatasize);
					if (var.equals("hatauyumsuz")) {
						return;
					}
					hatasirasi++;

					lin = lin.replace("IOModeType.AD_MI_,0,", "IOModeType.AD_MI_," + var + ",");
					lin = lin.replace("new", "new ");
					classContent.set(i, lin);
					System.out.println(index + "-) " + file.getName() + ":" + lin);
					index++;

					;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------------------------------------");

		write(file.getAbsolutePath());

	}

	private static String getVar(String name, int hatasirasi, int hatasize) {
		result = new ArrayList<>();
		int hata = 0;
		for (int i = 0; i < HataliKod5.size(); i++) {
			String hatacode = HataliKod5.get(i);
			String dosyadi = hatacode.substring(0, 8);
			String var = hatacode.substring(8);
			if (name.contains(dosyadi)) {
				hata++;
				result.add(var);
			}
		}
		if (hata != hatasize) {
			return "hatauyumsuz";
		}
		return result.get(hatasirasi);

	}

	private static void subprogramchange(File file) {
		if (file.isFile()) {

			if (file.getAbsolutePath().contains("mb")) {
				readinit(file);

				// read(file);
				//
				// String filename = file.getName();
				// // changesubs(file, filename);
				// changewrite(file, filename);
			}

		}
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				// System.out.print("-");
				subprogramchange(file2);
			}
		}

	}

	private static void findreinput(File file) {
		if (file.isFile()) {

			if (file.getAbsolutePath().contains("mb")) {
				findreinputwith(file);
			}

		}
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				// System.out.print("-");
				findreinput(file2);
			}
		}

	}

	private static void findreinputwith(File file) {
		classContent = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;
		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				classContent.add(line);
			}
			boolean dosyaadi = false;
			for (int i = 0; i < classContent.size(); i++) {
				String lin = classContent.get(i);
				if (lin.contains("REINPUT") && lin.contains("WITH")) {
					System.out.println(index + "-) " + file.getName() + ":" + lin);
					index++;
					System.out.println("-----------------------------------------------------------------------------");

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void readinit(File file) {
		classContent = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;
		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				classContent.add(line);
			}
			boolean dosyaadi = false;
			for (int i = 0; i < classContent.size(); i++) {
				String lin = classContent.get(i);
				String linnext = classContent.get(i + 1);
				if (line.contains("naturalProgram")) {
					break;
				}

				if (lin.contains("INIT") && linnext.contains("String")) {
					System.out.println(linnext);
					dosyaadi = true;
				}

			}
			if (dosyaadi)
				System.out.println(file.getAbsolutePath());

			System.out.println("--------------------------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void changewrite(File file, String filename) {
		// TODO Auto-generated method stub
		// System.out.println();

		for (int i = 0; i < file.getParentFile().getParentFile().listFiles()[1].listFiles().length; i++) {

			File tar = file.getParentFile().getParentFile().listFiles()[1].listFiles()[i];
			if (!filename.equals(tar.getName())) {
				continue;
			}
			classContent = new ArrayList<>();
			BufferedReader br = null;
			FileReader fr = null;
			try {

				fr = new FileReader(tar);
				br = new BufferedReader(fr);
				br = new BufferedReader(new FileReader(tar));
				String line = br.readLine();
				while ((line = br.readLine()) != null) {
					classContent.add(line);
				}
				String linedigits = "";
				if (motorfinds.size() > 0) {
					String[] srcfind = motorfinds.get(0).split("mewo123"); // [{linedigits,find}]
					int sayac = 0;
					for (int j = 0; j < classContent.size(); j++) {
						String str = classContent.get(j);

						if (str.contains("NATURAL CODE")) {
							linedigits = str.replaceAll("[^\\.0123456789]", "");
							if (!linedigits.trim().equals("") && linedigits.startsWith(srcfind[0].split("\\.")[0])) {
								while (true) {
									j++;
									str = classContent.get(j);
									if (str.contains("DAO.find")) {
										classContent.set(j, srcfind[1]);
										sayac += 1;
										if (sayac < motorfinds.size())
											srcfind = motorfinds.get(sayac).split("mewo123");
										break;
									} else
										continue;

								}

							}
						}

					}
					write(tar.getAbsolutePath());
				}

				System.out.println("--------------------------------------------------------------");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private static void changesubs(File file, String filename) {
		// System.out.println();

		for (int i = 0; i < file.getParentFile().getParentFile().listFiles()[1].listFiles().length; i++) {

			File tar = file.getParentFile().getParentFile().listFiles()[1].listFiles()[i];
			if (!filename.equals(tar.getName())) {
				continue;
			}
			classContent = new ArrayList<>();
			BufferedReader br = null;
			FileReader fr = null;
			try {

				fr = new FileReader(tar);
				br = new BufferedReader(fr);
				br = new BufferedReader(new FileReader(tar));
				String line = br.readLine();
				while ((line = br.readLine()) != null) {
					classContent.add(line);
				}
				String linedigits = "";
				if (writes.size() > 0) {
					String srcfind = writes.get(0);
					int sayac = 0;
					for (int j = 0; j < classContent.size(); j++) {
						String str = classContent.get(j);

						if (str.contains("write")) {
							for (int k = 0; k < motor.size(); k++) {
								String label = motor.get(j + k);

								if (label.contains("ScreenIOLabel")) {
									classContent.set(j + k, label);
								} else
									break;
							}
						}

					}
					write(tar.getAbsolutePath());
				}

				System.out.println("--------------------------------------------------------------");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private static void read(File file) {
		System.out.println(file.getAbsolutePath());
		motor = new ArrayList<>();
		// motorfinds = new ArrayList<>();
		writes = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;
		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			int i = 1;
			int selectStart = 0;
			while ((line = br.readLine()) != null) {

				motor.add(line);
			}

			String linedigits = "";
			for (int j = 0; j < motor.size(); j++) {
				String str = motor.get(j);
				// NATURAL CODE:61

				if (str.contains("write")) {
					writes.add(str);
					for (int k = 1; k < motor.size(); k++) {
						String label = motor.get(j + k);
						if (label.contains("ScreenIOLabel")) {
							writes.add(label);
						} else
							break;
					}

				}
				// if (str.contains("NATURAL CODE")) {
				// linedigits = str.replaceAll("[^\\.0123456789]", "");
				// }
				// if (str.contains("DAO.find")) {
				// motorfinds.add(linedigits + "mewo123" + str);
				// }

			}

			System.out.println("--------------------------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void operatechangeStr(File file) {
		if (file.isFile()) {

			changeStrArr(file);
			write(file.getAbsolutePath());

		}
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				// System.out.print("-");
				operatechangeStr(file2);
			}
		}
	}

	private static void changeStrArr(File file) {
		System.out.println(file.getAbsolutePath());
		classContent = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;
		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			int i = 1;
			int selectStart = 0;
			while ((line = br.readLine()) != null) {

				classContent.add(line);
			}
			for (int j = 0; j < classContent.size(); j++) {
				String str = classContent.get(j);
				if (str.contains("public") && str.contains("String[]") && str.contains("=") && !str.contains("{")) {
					str = str.replace("new String[", "FCU.resetStringArray(").replace("]", ")");
					classContent.set(j, str);

				}
			}

			System.out.println("--------------------------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void operate(File file) {
		if (file.isFile()) {
			if (file.getName().equals(".gitignore")) {
				return;
			}
			// System.out.println("parent " + file.getAbsolutePath());
			// findmaps(file);
			// find(file);

			if (file.getAbsolutePath().contains("map") && firstOperation) {
				setPf(file);
				write(file.getAbsolutePath());
			} else
				return;

			if (firstOperation) {

				findfetchReturn(file);
				findfetch(file);
				System.out.println(fetchList);
				System.out.println(fetchReturnList);

			}
			if (!firstOperation) {
				if (!file.getAbsolutePath().contains("target") && fetchList.contains(file.getName().replaceAll("Impl.java", ""))) {
					System.out.println(file.getName() + "----fetch ile cagrılıyor işlem basladı");
					changeFeth(file);
					storefetch(file.getAbsolutePath());
				}
				if (!file.getAbsolutePath().contains("target") && fetchReturnList.contains(file.getName().replaceAll("Impl.java", ""))) {
					System.out.println(file.getName() + "----fetchreturn ile cagrılıyor işlem basladı");
					if (file.getName().equals("IDGP1448Impl.java")) {
						// System.out.println();
					}
					changeFethreturn(file);
					addCallNat();
					storeFetchreturn(file.getAbsolutePath());
				}
			}
			// if (!ignore.contains(dosyaAdi))
			// replaceResetArray(file,file.getAbsolutePath());
			// System.out.println("bitti-" + file.getAbsolutePath());
			// writeToFile(select);

		}
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				// System.out.print("-");
				operate(file2);
			}
		}

	}

	private static void setPf(File file) {
		pfs = new ArrayList<>();
		System.out.println(file.getAbsolutePath());
		classContent = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;
		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			int i = 1;
			int selectStart = 0;
			while ((line = br.readLine()) != null) {

				classContent.add(line);
			}
			for (int j = 0; j < classContent.size(); j++) {
				line = classContent.get(j);

				if (line.contains("PF") && line.contains("ScreenIOLabel")) {
					System.out.println(line);
					classContent.remove(line);
					j--;
					String pfstr = line.split(",")[3].replaceAll("\"", "");

					pfs.add("registerPFKey(\"" + pfstr.split(":")[0] + "\", \":" + pfstr.split(":")[1] + "\", true, true, \"\", \"\");");
				}

			}

			for (int j = 0; j < classContent.size(); j++) {

				line = classContent.get(j);
				if (line.contains("unRegisterEnterKey")) {
					for (int j2 = 0; j2 < pfs.size(); j2++) {

						classContent.add(j + 1, pfs.get(pfs.size() - j2 - 1));
					}
				}
			}
			System.out.println("--------------------------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void addCallNat() {
		callnatparameters = new ArrayList<>();
		for (int i = 0; i < degiskenler.size(); i++) {
			String degisken = degiskenler.get(i);
			System.out.println(degisken);

			for (int j = 0; j < classContent.size() - 2; j++) {
				String line = classContent.get(j);
				String linenext = classContent.get(j + 1);
				String linenextnext = classContent.get(j + 2);
				if (linenext.contains(degisken) && linenextnext.contains(degisken)) {
					classContent.remove(j);
					classContent.remove(j);
					classContent.remove(j);
					callnatparameters.add("@CallNatParameter " + line);
					callnatparameters.add(" " + linenext);
					callnatparameters.add(" " + linenextnext);
					break;
				}

			}

		}

		for (int i = 0; i < classContent.size(); i++) {
			if (classContent.get(i).contains("naturalProgram")) {
				for (int j = 0; j < callnatparameters.size(); j++) {
					classContent.add(i - 1, callnatparameters.get(callnatparameters.size() - j - 1));

				}
				break;
			}
		}
		// System.out.println();

	}

	private static void storeFetchreturn(String string) {
		write(string);

	}

	private static void storefetch(String string) {
		write(string);

	}

	private static void changeFethreturn(File file) {
		classContent = new ArrayList<String>();
		degiskenler = new ArrayList<String>();
		getAutoInputekle = true;
		ekleniyor = true;
		BufferedReader br = null;
		FileReader fr = null;
		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			int i = 1;
			int selectStart = 0;
			while ((line = br.readLine()) != null) {
				classContent.add(line);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < classContent.size() - 1; i++) {
			String str = classContent.get(i);
			String strnext = classContent.get(i + 1);

			if (strnext.contains("unRegisterPFKeyAll") && getAutoInputekle) {
				classContent.add(i + 1, "getAutoInput=true;");
				getAutoInputekle = false;
			}
			if (!str.contains("ScreenIOLabel") && ekleniyor) {
				continue;
			}
			if (str.contains("ScreenIOLabel")) {
				ekleniyor = true;
				// new
				// ScreenIOLabel(0,0,IOModeType.AD_MI_,"PGIRISNO",PGIRISNO,XCoordinationTypes.EXACT
				// , XCoordinationTypes.EXACT,0,15),
				// new
				// ScreenIOLabel(0,15,IOModeType.AD_MI_,"PGIRISTARIH1",PGIRISTARIH1,XCoordinationTypes.EXACT
				// , XCoordinationTypes.EXACT,0,10),

				String degisken = str.split(",")[3];
				System.out.println(degisken);
				degiskenler.add(degisken);

			}
			if (!strnext.contains("ScreenIOLabel") && !ekleniyor) {
				return;
			}
			ekleniyor = false;
		}

	}

	private static void changeFeth(File file) {

		classContent = new ArrayList<String>();
		getAutoInputekle = true;
		ekleniyor = true;
		BufferedReader br = null;
		FileReader fr = null;
		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			int i = 1;
			int selectStart = 0;
			while ((line = br.readLine()) != null) {
				classContent.add(line);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < classContent.size() - 1; i++) {
			String str = classContent.get(i);
			String strnext = classContent.get(i + 1);

			if (strnext.contains("unRegisterPFKeyAll") && getAutoInputekle) {
				classContent.add(i + 1, "getAutoInput=true;");
				getAutoInputekle = false;
			}
			if (!str.contains("ScreenIOLabel") && ekleniyor) {
				continue;
			}
			if (str.contains("ScreenIOLabel")) {
				ekleniyor = true;

				// ScreenIOLabel(0,0,IOModeType.AD_MI_,"PGIRISNO",PGIRISNO,XCoordinationTypes.EXACT
				// , XCoordinationTypes.EXACT,0,15),
				// new
				// ScreenIOLabel(0,15,IOModeType.AD_MI_,"PGIRISTARIH1",PGIRISTARIH1,XCoordinationTypes.EXACT
				// , XCoordinationTypes.EXACT,0,10),

				String degisken = str.split(",")[3];
				if (!degisken.contains("\"")) {
					str = str.replaceAll(degisken, "\"" + degisken + "\"," + degisken);
					classContent.set(i, str);
				}

			}
			if (!strnext.contains("ScreenIOLabel") && !ekleniyor) {
				return;
			}
			ekleniyor = false;

		}

	}

	private static void findfetchReturn(File file) {

		dosyaAdi = file.getName().replaceAll(".java", "").replaceAll(".txt", "");
		if (!file.getAbsolutePath().toString().contains("target")) {
			BufferedReader br = null;
			FileReader fr = null;
			try {

				fr = new FileReader(file);
				br = new BufferedReader(fr);
				br = new BufferedReader(new FileReader(file));
				String line = br.readLine();
				int i = 1;
				int selectStart = 0;
				while ((line = br.readLine()) != null) {
					if (line.contains("fetchReturn") && !line.contains("new Parameter[]{}")) {
						// if (line.contains("fetchReturn")) {
						System.out.println(file.getName() + " " + line.trim());
						String fetchreturn = line.split("\"")[1].split("\"")[0];
						System.out.println(fetchreturn);
						fetchReturnList.add(fetchreturn);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private static void findfetch(File file) {
		dosyaAdi = file.getName().replaceAll(".java", "").replaceAll(".txt", "");
		if (!file.getAbsolutePath().toString().contains("target")) {
			BufferedReader br = null;
			FileReader fr = null;
			try {

				fr = new FileReader(file);
				br = new BufferedReader(fr);
				br = new BufferedReader(new FileReader(file));
				String line = br.readLine();
				int i = 1;
				int selectStart = 0;
				while ((line = br.readLine()) != null) {
					if (line.contains("fetch") && !line.contains("turn") && !line.contains("new Parameter[]{}") && !line.contains("new Parameter[] {}") && !line.contains("null")) {
						// if (line.contains("fetchReturn")) {
						System.out.println(file.getName() + " " + line.trim());
						String fetch = line.split("\"")[1].split("\"")[0];
						System.out.println(fetch);
						fetchList.add(fetch);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void findmaps(File file) {
		dosyaAdi = file.getName().replaceAll(".java", "").replaceAll(".txt", "");
		if (file.getAbsolutePath().toString().contains("Map") && !file.getAbsolutePath().toString().contains("target") && !ignoreMap.contains(dosyaAdi)) {
			System.out.println(dosyaAdi);
			move(file, dosyaAdi);
		}
	}

	private static void move(File file, String dosyaAdi2) {
		File tar = new File("C:/Users/Asligul/Desktop/AAA/maps/" + dosyaAdi2 + ".txt");
		int i = 2;

		try {
			Files.copy(file.toPath(), tar.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void find(File file) {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			int i = 1;
			int selectStart = 0;
			while ((line = br.readLine()) != null) {
				if (line.contains(",ZZ9.99") && !line.contains("EM=ZZ,ZZZ,ZZ9.99") && file.getAbsolutePath().toString().contains("Map")) {
					System.out.println(file.getName() + " " + line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void replaceResetArray(File file, String target) {
		classContent = new ArrayList<String>();
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			int i = 1;
			int selectStart = 0;
			while ((line = br.readLine()) != null) {
				i++;
				if (line.contains("FCU.resetArray") && !line.contains("=")) {
					System.out.println(line);
					String[] split = line.split("\\(");
					String degisken = split[1].replaceAll("\\)", "").replaceAll(";", "").trim();
					line = degisken + "=FCU.resetArray(" + degisken + ",0);";
					System.out.print(" -> " + line);
					// System.out.println();
				}

				classContent.add(line);

			}
			write(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void write(String target) {
		try {
			PrintWriter writer = null;
			writer = new PrintWriter(target, "UTF-8");

			for (int i = 0; i < classContent.size(); i++) {
				writer.println(classContent.get(i));

			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void select(File file) {

		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			int i = 1;
			int selectStart = 0;
			while ((line = br.readLine()) != null) {
				i++;
				if (line.contains("SELECT") && !line.contains("END-SELECT")) {
					System.out.println(line);
					ekle = true;
					selectStart = i;
					select.add("*C**" + dosyaAdi + "_" + i);
				}
				if (ekle) {
					select.add(line);
				}
				if (line.contains("END-SELECT")) {
					System.out.println(line);

					ekle = false;
				}
				i++;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void writeToFile(ArrayList<String> select) {
		try {
			PrintWriter writer = null;
			writer = new PrintWriter("C:/Users/Asligul/Desktop/rpg/" + dosyaAdi + ".txt", "UTF-8");

			for (int i = 0; i < select.size(); i++) {
				writer.println(select.get(i));

			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
