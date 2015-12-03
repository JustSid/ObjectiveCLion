package com.widerwille.ObjectiveCL;

import com.intellij.openapi.components.ApplicationComponent;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.jetbrains.cidr.lang.CLanguageKind;
import com.jetbrains.cidr.lang.OCLanguageKind;
import com.jetbrains.cidr.lang.editor.colors.OCColorsSettingsPage;
import org.jetbrains.annotations.NotNull;

public class OCLApplicationComponent implements ApplicationComponent
{
	public OCLApplicationComponent()
	{}

	public void initComponent()
	{
		Class cls = OCLanguageKind.class;
		Field[] fields = cls.getDeclaredFields();

		for(int i = 0; i < fields.length; i ++)
		{
			Field field = fields[i];

			try
			{
				switch(field.getName())
				{
					case "CPP":
						setFinalStatic(field, OCLanguageKind.OBJ_CPP);
						break;
					case "C":
						setFinalStatic(field, OCLanguageKind.OBJ_C);
						break;
				}

				System.out.println("Field " + field);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public void disposeComponent()
	{}

	@NotNull
	public String getComponentName()
	{
		return "ObjectiveCLion";
	}

	void setFinalStatic(Field field, Object newValue) throws Exception
	{
		field.setAccessible(true);

		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

		field.set(null, newValue);
	}
}
