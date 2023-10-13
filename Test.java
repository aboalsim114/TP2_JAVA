import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Test {

	/**
	 * Vérifie que le résultat donné d'une expression booléenne est vraie et
	 * affiche dans la console le bilan de cette vérification.
	 * @param result le résultat d'une expression booléenne à vérifier
	 * @param description la description du test
	 */
	static void assertTrue(boolean result, String description) {
		try {
			throw new AssertionError(description);
		}
		catch (AssertionError error) {
			printResult(result, description);
		}
	}

	/**
	 * Vérifie que le résultat donné d'une expression booléenne est faux et
	 * affiche dans la console le bilan de cette vérification.
	 * @param result le résultat d'une expression booléenne à vérifier
	 * @param description la description du test
	 */
	static void assertFalse(boolean result, String description) {
		try {
			throw new AssertionError(description);
		}
		catch (AssertionError error) {
			printResult(!result, description);
		}
	}

	/**
	 * Vérifie que le résultat obtenu est égal au résultat attendu et affiche
	 * dans la console le bilan de cette vérification.
	 * 
	 * Le test d'égalité utilise la méthode "egale" si elle est définie dans la
	 * classe dont les deux résultats sont instances, ou la méthode "equals"
	 * sinon.
	 * 
	 * L'affichage utilise la méthode "versChaine" si elle est définie dans la
	 * classe dont les deux résultats sont instances, ou la méthode "toString"
	 * sinon.
	 * 
	 * @param result le résultat obtenu
	 * @param expectedResult le résultat attendu
	 * @param description la description du test
	 */
	static void assertEquals(Object result, Object expectedResult, String description) {
		try {
			throw new AssertionError(description);
		} catch (AssertionError error) {
			// case when both result and expected result are null
			boolean passed = (result == null && expectedResult == null) || ((result != null) && (expectedResult != null) && equals(result, expectedResult));
			if (!passed) {
				description = description + " (result is " + toString(result) + " but " + toString(expectedResult) + " is expected)";
			}
			printResult(passed, description);
		}
	}

	/**
	 * Vérifie que le résultat obtenu n'est pas égal au résultat attendu et affiche
	 * dans la console le bilan de cette vérification.
	 * 
	 * Le test d'égalité utilise la méthode "egale" si elle est définie dans la
	 * classe dont les deux résultats sont instances, ou la méthode "equals"
	 * sinon.
	 * 
	 * L'affichage utilise la méthode "versChaine" si elle est définie dans la
	 * classe dont les deux résultats sont instances, ou la méthode "toString"
	 * sinon.
	 * 
	 * @param result le résultat obtenu
	 * @param expectedResult le résultat attendu
	 * @param description la description du test
	 */
	static void assertNotEquals(Object result, Object expectedResult, String description) {
		try {
			throw new AssertionError(description);
		}
		catch (AssertionError error) {
			// case when both result and expected result are null
			boolean passed = (result == null && expectedResult==null) || ((result != null) && (expectedResult != null) && !equals(result, expectedResult));
			if (!passed) {
				description = description + " (result is " + toString(result) + " and is equal to " + toString(expectedResult) + ")";
			}
			printResult(passed, description);
		}
	}
	
	/**
	 * Vérifie que le résultat obtenu n'est pas nul et afficheString
	 * dans la console le bilan de cette vérification.
	 * 
	 * L'affichage utilise la méthode "versChaine" si elle est définie dans la
	 * classe dont les deux résultats sont instances, ou la méthode "toString"
	 * sinon.
	 * 
	 * @param result le résultat obtenu
	 * @param description la description du test
	 */
	static void assertNotNull(Object result, String description) {
		try {
			throw new AssertionError(description);
		}
		catch (AssertionError error) {
			// case when both result and expected result are null
			boolean passed = result != null;
			printResult(passed, description);
		}
	}

	/**
	 * Vérifie que l'exécution d'un bloc d'instructions conduit à une erreur et
	 * affiche dans la console le bilan de cette vérification.
	 * @param runnable le bloc d'instructions à exécuter
	 * @param description la description du test
	 */
	static void assertError(Runnable runnable, String description) {
		try {
			runnable.run();
			printResult(false, description);
		} catch (Error error) {
			printResult(true, description);
		}
	}
	
	/**
	 * Vérifie que l'exécution d'un bloc d'instructions conduit à une erreur, 
	 * que le message d'erreur n'est pas le généric fourni dans le sujet et
	 * affiche dans la console le bilan de cette vérification.
	 * @param runnable le bloc d'instructions à exécuter
	 * @param description la description du test
	 */
	static void assertErrorMessageChanged(Runnable runnable, String description) {
		try {
			runnable.run();
			printResult(false, description);
		} catch (Error error) {
			if(!"message d'erreur".equals(error.getMessage())) {
				printResult(true, description);
			}else {
				printResult(false, description);
			}
		}	
	}
	
	/**
	 * Vérifie que l'exécution d'un bloc d'instructions ne conduit pas à une erreur et
	 * affiche dans la console le bilan de cette vérification. Cette méthode vérifie que le
	 * code est "protégé" des levées d'exceptions.
	 * @param runnable le bloc d'instructions à exécuter
	 * @param description la description du test
	 */
	static void assertNoError(Runnable runnable, String description) {
		try {
			runnable.run();
			printResult(true, description);
		}
		catch (Exception exception) {
			printResult(false, description);
			exception.printStackTrace();
		}
	}
	
	static void assertAttributPresent(String memberName, String type, Class clazz, String description) {
		try {
			throw new AssertionError(description);
		} catch (AssertionError error) {
			
			// case when both result and expected result are null
			boolean passed = findField(memberName,type,clazz);
			if (!passed) {
				description = description + " (no member " + memberName + " of type " + type + " found)";
			}
			printResult(passed, description);
		}
	}
	
	static void assertConstructeurPresent(int numParam, Class clazz, String description) {
		try {
			throw new AssertionError(description);
		} catch (AssertionError error) {
			
			// case when both result and expected result are null
			boolean passed = findConstructor(numParam,clazz);
			if (!passed) {
				description = description + " (no constructor with " + numParam + " parameters found)";
			}
			printResult(passed, description);
		}
	}
	
	static void assertConstructeurParams(String[] params, Class clazz, String description) {
		try {
			throw new AssertionError(description);
		} catch (AssertionError error) {
			
			// case when both result and expected result are null
			boolean passed = findConstructorParams(params,clazz);
			if (!passed) {
				description = description + " (no constructor with given parameters found)";
			}
			printResult(passed, description);
		}
	}
	
	static void assertMethodePresenteNbFixeParams(String methodName, int numParam, String returnType, Class clazz, String description) {
		try {
			throw new AssertionError(description);
		} catch (AssertionError error) {
			
			// case when both result and expected result are null
			boolean passed = findMethod(methodName,numParam,returnType,clazz);
			if (!passed) {
				description = description + " (no method " + methodName + " with " + numParam + " parameters and with "+ returnType + " as return type found)";
			}
			printResult(passed, description);
		}
	}
	
	static void assertMethodePresenteNbMinParams(String methodName, int numParam, String returnType, Class clazz, String description) {
		try {
			throw new AssertionError(description);
		} catch (AssertionError error) {
			
			// case when both result and expected result are null
			boolean passed = findMethodMin(methodName,numParam,returnType,clazz);
			if (!passed) {
				description = description + " (no method " + methodName + " with " + numParam + " parameters and with "+ returnType + " as return type found)";
			}
			printResult(passed, description);
		}
	}
	
	static void assertNbAttributs(int num, Class clazz, String description) {
		try {
			throw new AssertionError(description);
		} catch (AssertionError error) {
			
			// case when both result and expected result are null
			boolean passed = clazz.getDeclaredFields().length == num;
			if (!passed) {
				description = description + " (found more attributes than expected)";
			}
			printResult(passed, description);
		}
	}

	// ====================================================
	// | Méthodes internes volontairement non documentées |
	// ====================================================

	static boolean equals(Object object1, Object object2) {
		try {
			Class<?>[] parameterTypes = { object2.getClass() };
			Method egale = object1.getClass().getDeclaredMethod("egale", parameterTypes);
			return (Boolean) egale.invoke(object1, object2);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassCastException e) {
			return object1.equals(object2);
		}
	}

	static String toString(Object object) {
		try {
			Method versChaine = object.getClass().getDeclaredMethod("versChaine", new Class<?>[0]);
			return (String) versChaine.invoke(object);
		} catch (NullPointerException npe) {
			return "null";
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassCastException e) {
			return object.toString();
		}
	}

	static int testCount = 0;

	static void printResult(boolean passed, String message) {
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		int index = stack.length - 1;
		int i = 0;
		boolean found = false;
		while (i < stack.length - 1 && !found) {
			if (stack[i].getMethodName().startsWith("assert")) {
				index = i + 1;
				found = true;
			} else {
				i++;
			}
		}
		// DO NOT CLOSE this stream of it will close System.out and System.err...
		PrintStream stream = (passed?System.out:System.err);
		StackTraceElement trace = stack[index];
		stream.printf("%s : %d : %s : %s\n",trace.getFileName(),
				trace.getLineNumber(),
				(passed?"passed":"error"),
				message);
		stream.flush();
		try {
			Thread.sleep(10); // Avoid out and err streams messages to mix on the console
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		testCount++;
	}
	
	static boolean findField(String name, String type, Class clazz) {
		boolean found = false;
		try {
			found = Arrays.asList(clazz.getDeclaredFields()).stream().anyMatch(f -> f.getName().equals(name) && f.getType().getSimpleName().equals(type));
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return found;
	}
	
	static boolean findConstructor(int numParams, Class clazz) {
		boolean found = false;
		try {
			found = Arrays.asList(clazz.getDeclaredConstructors()).stream().anyMatch(c -> c.getParameterCount() == numParams);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return found;
	}
	
	private static boolean findConstructorParams(String[] params, Class clazz) {
		List<Constructor> constructors = Arrays.asList(clazz.getDeclaredConstructors()); 
		boolean found = true && !constructors.isEmpty();
		for (Constructor constructor : clazz.getDeclaredConstructors()) {
			List<String> parameters = Arrays.asList(constructor.getParameterTypes()).stream().map((p)->p.getSimpleName()).collect(Collectors.toList());
			List<String> inParams = Arrays.asList(params);
			found &= parameters.size()==inParams.size() && parameters.containsAll(inParams);
		}
		return found;
	}
	
	static boolean findMethod(String methodName, int numParams, String returnType, Class clazz) {
		boolean found = false;
		try {
			found = Arrays.asList(clazz.getDeclaredMethods()).stream().anyMatch(m -> m.getName().equals(methodName) && m.getParameterCount() == numParams && m.getReturnType().getSimpleName().equals(returnType));
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return found;
	}
	
	static boolean findMethodMin(String methodName, int numParams, String returnType, Class clazz) {
		boolean found = false;
		try {
			found = Arrays.asList(clazz.getDeclaredMethods()).stream().anyMatch(m -> m.getName().equals(methodName) && m.getParameterCount() >= numParams && m.getReturnType().getSimpleName().equals(returnType));
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return found;
	}
}
