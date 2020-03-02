package tr.com.oyak.muhasebe.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonArray;

import tr.com.oyak.muhasebe.model.BootstrapTableModel;
import tr.com.oyak.muhasebe.model.ButtonModel;
import tr.com.oyak.muhasebe.model.DataModel;
import tr.com.oyak.muhasebe.model.ExecutableModels;
import tr.com.oyak.muhasebe.model.ScreenModel;
import tr.com.oyak.muhasebe.model.UpdateModal;
import tr.com.oyak.muhasebe.util.AppConstants;
import tr.com.oyak.muhasebe.util.CommandType;
import tr.com.oyak.muhasebe.util.FieldType;
import tr.com.oyak.muhasebe.util.Redefine;

public abstract class AbstractCommand implements Command {

	private static final Logger logger = LoggerFactory.getLogger(AbstractCommand.class);

	private CommandType commandType;
	public ArrayList<DataModel> matris = new ArrayList();
	public HashMap sql_param = new HashMap<String, Object>();
	public HashMap callParamaters = new HashMap<String, Object>();
	public ScreenModel screenModel = new ScreenModel();
	public VaadinFeatures vaadinFeatures = new VaadinFeatures(AppConstants.XS, AppConstants.XL);
	public JsonArray jsonArray = new JsonArray();
	public BootstrapTableModel bootstrapTableModel = new BootstrapTableModel();
	private ArrayList<ButtonModel> buttonModelList = new ArrayList<>();

	public AbstractCommand(CommandType commandType) {
		super();
		this.commandType = commandType;
	}

	public Object execute(ScreenModel screenModel, int count) throws MuhException {
		logger.warn("Unimplemented Command Execute Method");
		return null;
	}

	public Object execute(ScreenModel screenModel, String mode) throws MuhException {
		logger.warn("Unimplemented Command Execute Method");
		return null;
	}

	public CommandType getCommandType() {
		return commandType;
	}

	public void addTableButton(FieldType fieldType, String call, ArrayList<UpdateModal> updateFields) {
		buttonModelList.add(new ButtonModel(fieldType, call, updateFields));
		bootstrapTableModel.setButtonModelList(buttonModelList);
	}

	protected void mainEnder(String programName) {
		screenModel.setCallList(new ArrayList<>());
	}

	protected void callEnder(String programName) {
		ArrayList<ExecutableModels> callList = screenModel.getCallList();
		for (int i = 0; i < callList.size(); i++) {
			ExecutableModels executableModels = callList.get(i);
			if (executableModels.getCallProgramName().equals(programName)) {
				executableModels.setCallProgramName(null);
				callList.set(i, executableModels);
				break;
			}
		}
	}

	protected void copyParameters(HashMap<String, Object> paramaters) {
		if (paramaters != null) {
			Iterator it = paramaters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				try {
					Field declaredField = this.getClass().getDeclaredField((String) pair.getKey());
					Object value = pair.getValue();// setlenecek value
					Class<?> type = declaredField.getType();

					if (type.getSimpleName().equals("Redefine")) {
						Method method = type.getMethod("setValueString", String.class);
						declaredField.setAccessible(true);
						Object value1 = declaredField.get(this);// setlenecek value
						method.invoke(value1, pair.getValue().toString());
						continue;
					}

					if (int.class.isAssignableFrom(type))
						value = Integer.parseInt(pair.getValue().toString());

					if (String.class.isAssignableFrom(type))
						value = String.valueOf(((String) pair.getValue()).toString());

					if (BigDecimal.class.isAssignableFrom(type))
						value = new BigDecimal(pair.getValue().toString());

					declaredField.set(this, value);

				} catch (Exception e) {
					e.printStackTrace();
					logger.debug(e.getMessage(), e);
				}
			}
		}
	}

	// bu metoda gerek kalmadı
//	protected void copyParameters(HashMap<String, ?> paramaters, Redefine... redifs) {
//		if (paramaters != null) {
//			Iterator it = paramaters.entrySet().iterator();
//			while (it.hasNext()) {
//				Map.Entry pair = (Map.Entry) it.next();
//				try {
//					Field declaredField = this.getClass().getDeclaredField((String) pair.getKey());
//					Object value = pair.getValue();
//					Class<?> type = declaredField.getType();
//
//					if (Redefine.class.isAssignableFrom(type)) {
//						for (Redefine redif : redifs) {
//							if (declaredField.getName().trim().equalsIgnoreCase(redif.getRedefineVariableName())) {
//								Method method = type.getMethod("setValueString", String.class);
//								method.invoke(redif, pair.getValue().toString());
//								// value = pair.getValue().toString();
//							}
//						}
//					} else {
//						if (int.class.isAssignableFrom(type))
//							value = Integer.parseInt((String) pair.getValue());
//
//						if (String.class.isAssignableFrom(type))
//							value = String.valueOf(((String) pair.getValue()).toString());
//
//						if (BigDecimal.class.isAssignableFrom(type))
//							value = new BigDecimal(pair.getValue().toString());
//
//						declaredField.set(this, value);
//					}
//
//				} catch (Exception e) {
//					e.printStackTrace();
//					logger.debug(e.getMessage(), e);
//				}
//			}
//		}
//	}

	protected void copyFields(Object object) {
		if (object != null) {
			Method[] methods = object.getClass().getMethods();
			Field[] declaredFields = this.getClass().getDeclaredFields();
			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				if (method.getName().startsWith("get")) {
					for (int j = 0; j < declaredFields.length; j++) {
						Field field = declaredFields[j];
						if (method.getName().equalsIgnoreCase("get" + field.getName())) {
							try {

								Class<?> type = field.getType();
								if (type.getSimpleName().equals("Redefine")) {
									Method setValueString = type.getMethod("setValueString", String.class);
									field.setAccessible(true);
									Object value1 = field.get(this);
									setValueString.invoke(value1, method.invoke(object.toString()));
									continue;
								}

								this.getClass().getDeclaredField(field.getName()).set(this, method.invoke(object));
							} catch (Exception e) {
								e.printStackTrace();
								logger.debug(e.getMessage(), e);
							}
						}
					}
				}
			}
		}
	}

	protected Object callProgram(String mainProgramName, String mainNextPartName, String callProgramName, HashMap<String, Object> callParamaters) {
		screenModel.setCallParamaters(callParamaters);
		screenModel.getCallList().add(new ExecutableModels(mainProgramName, mainNextPartName, callProgramName, "part1"));
		throw new ThrowCall(screenModel);
	}

	// protected void callProgram(String programName, HashMap callParams) throws
	// Exception {
	// Class<?> clazz = Class.forName("tr.com.oyak.muhasebe.command." +
	// programName);
	// Constructor<?> constructor = null;
	// Object instance = null;
	// constructor = clazz.getConstructor(HashMap.class);
	// instance = constructor.newInstance(callParams);
	// try {
	// Object execute = ((Command) instance).execute(screenModel, null);
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// throw e;
	// }
	// Field declaredField = instance.getClass().getDeclaredField("callParamaters");
	// declaredField.setAccessible(true);
	// Object value1 = declaredField.get(instance);
	// copyFields(value1);
	// }

}
