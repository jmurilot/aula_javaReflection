package processadorxml;

import java.lang.reflect.Field;

public class XMLProcessor {

    public static String generateXMLBody(Object o) throws Exception {

        StringBuilder str = new StringBuilder();


        str.append("<"+o.getClass().getSimpleName()+">\n");

        Field[] atributos = o.getClass().getDeclaredFields();

        for (Field atr: atributos) {
            if (!atr.canAccess(o)){
                atr.setAccessible(true);
            }
            switch (atr.getType().getName()) {
                case "int", "double", "float", "java.lang.String" ->
                        str.append("<" + atr.getName() + ">" + atr.get(o) + "</" + atr.getName() + ">\n");
                default -> //se ele é um objeto eu uso a definição recursiva do processador xml
                        str.append(generateXMLBody(atr.get(o)));
            }

        }

        str.append("</"+o.getClass().getSimpleName()+">\n");


        return str.toString();
    }

    public static String generateXML(Object o) throws Exception{
        return "<xml version=\"1.0\">\n"+generateXMLBody(o)+"</xml>";
    }
}
