package fr.aelion.repositories;

import fr.aelion.helpers.CaseConverter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public abstract class Repository<T> {
    private Class<T> model;
    private String simpleName;
    protected Repository(Class<T> className){
        this.model = className;
        simpleName=model.getSimpleName().toLowerCase();
    }
    public String getTableName(){
        return simpleName.toLowerCase();
    }

    public String getAliasedTableName(){
        return simpleName.toLowerCase()+" "+simpleName.substring(0,1).toLowerCase();
    }

    public String[] getFields() {
        var current = model;
        var stringFields = new ArrayList<String>();
        while(current.getSuperclass() != null) {
            // Let's do stuff
            stringFields.addAll(
                    Arrays.asList(
                            Arrays.stream(current.getDeclaredFields())
                                    .map(f -> f.getName())
                                    .collect(Collectors.toSet())
                                    .toArray(new String[0])
                    )
            );
            current = (Class<T>) current.getSuperclass();
        }

        return stringFields.toArray(new String[0]);
    }

    public String getCommaSeparatedColumns() {
        String tableNameLetter = getTableName().substring(0,1);

        String[] fields = getFields();
        String returnString="";

        Arrays.sort(fields);
        int i =0;
        for ( String field : fields){
            returnString+= tableNameLetter+".";
            returnString+= CaseConverter.camelToSnake(field) ;
            i++;
            if (i!=fields.length){
                returnString+=",";
            }
        }

    return returnString;
    }

    public String getSelectQuery() {
        return "SELECT "+getCommaSeparatedColumns()+" FROM "+simpleName+" "+simpleName.substring(0,1)+";";
    }
}
