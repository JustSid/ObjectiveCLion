package com.widerwille.ObjectiveCL;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.psi.codeStyle.DisplayPriority;
import com.intellij.psi.codeStyle.DisplayPrioritySortable;
import com.jetbrains.cidr.lang.OCLanguage;
import com.jetbrains.cidr.lang.OCLanguageKind;
import com.jetbrains.cidr.lang.editor.colors.OCFileHighlighter;
import com.jetbrains.cidr.lang.editor.colors.OCHighlightingKeys;
import com.jetbrains.cidr.lang.parser.OCTokenTypes;
import com.jetbrains.cidr.lang.settings.OCCustomOption;
import com.jetbrains.cidr.lang.settings.OCCustomOptionObjC;
import com.jetbrains.cidr.lang.settings.OCLanguageCodeStyleSettingsProvider;
import gnu.trove.THashMap;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Map;

public class OCLColorSettingsPage implements ColorSettingsPage, DisplayPrioritySortable
{
	public static final OCCustomOption CUSTOM_OPTION = new OCCustomOptionObjC();

	@NotNull
	public String getDisplayName()
	{
		return "Objective-C/C++";
	}

	public Icon getIcon()
	{
		return null;
	}

	public DisplayPriority getPriority()
	{
		return DisplayPriority.KEY_LANGUAGE_SETTINGS;
	}

	@NotNull
	public SyntaxHighlighter getHighlighter()
	{
		return new OCFileHighlighter(OCLanguageKind.OBJ_CPP, false);
	}

	@NotNull
	public String getDemoText()
	{
		return OCLanguageCodeStyleSettingsProvider.getCodeSample("Colors", "mm");
	}


	@NotNull
	public AttributesDescriptor[] getAttributeDescriptors()
	{
		return CUSTOM_OPTION.getAttributeDescriptors();
	}

	@NotNull
	public ColorDescriptor[] getColorDescriptors()
	{
		return new ColorDescriptor[]{};
	}


	public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap()
	{
		THashMap map = new THashMap();
		map.put("kw", OCHighlightingKeys.SELFSUPERTHIS);
		map.put("evar", OCHighlightingKeys.EXTERN_VARIABLE);
		map.put("gvar", OCHighlightingKeys.GLOBAL_VARIABLE);
		map.put("lvar", OCHighlightingKeys.LOCAL_VARIABLE);
		map.put("par", OCHighlightingKeys.PARAMETER);
		map.put("fun", OCHighlightingKeys.FUNCTION);
		map.put("op", OCHighlightingKeys.OVERLOADED_OPERATOR);
		map.put("prop", OCHighlightingKeys.PROPERTY);
		map.put("prop_attr", OCHighlightingKeys.PROPERTY_ATTRIBUTE);
		map.put("sfield", OCHighlightingKeys.STRUCT_FIELD);
		map.put("sel", OCHighlightingKeys.MESSAGE_ARGUMENT);
		map.put("ifdef", OCHighlightingKeys.CONDITIONALLY_NOT_COMPILED);
		map.put("macro", OCHighlightingKeys.MACRONAME);
		map.put("macro_par", OCHighlightingKeys.MACRO_PARAMETER);
		map.put("ivar", OCHighlightingKeys.INSTANCE_VARIABLE);
		map.put("struct", OCHighlightingKeys.STRUCT_LIKE);
		map.put("cls", OCHighlightingKeys.CLASS_REFERENCE);
		map.put("prt", OCHighlightingKeys.PROTOCOL_REFERENCE);
		map.put("enum", OCHighlightingKeys.ENUM_CONST);
		map.put("label", OCHighlightingKeys.LABEL);
		map.put("def", OCHighlightingKeys.TYPEDEF);
		map.put("fmt", OCHighlightingKeys.OC_FORMAT_STRING_TOKEN);
		map.put("templt", OCHighlightingKeys.TEMPLATE_TYPE);
		map.put("templv", OCHighlightingKeys.TEMPLATE_VALUE);
		map.put("ns", OCHighlightingKeys.NAMESPACE_LIKE);
		map.put("generic", OCHighlightingKeys.GENERIC_PARAMETER);

		return map;
	}
}
