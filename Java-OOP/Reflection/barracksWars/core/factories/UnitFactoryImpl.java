package Reflection.barracksWars.core.factories;

import Reflection.barracksWars.interfaces.Unit;
import Reflection.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"Reflection.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		try {
			return (Unit) Class.forName (UNITS_PACKAGE_NAME + unitType)
					.getConstructor ().newInstance ();
		}
		catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException |InstantiationException e){
			throw new IllegalStateException(e);
		}
	}
}
