/*
import java.util.ArrayList;
import java.util.List;

public class CsvOutPutFormatPreprocessor<Row> {
    public Column[] flattenNestedStructure(Dataset<Row> dataset) {
        StructType type = dataset.schema();
        System.out.println(dataset.schema());
        List<String> list = new ArrayList<String>();
        List<String> listOfSimpleType = new ArrayList<String>();
        for (StructField structField : type.fields()) {
            if (structField.dataType().toString().startsWith("StructType")) {
                String prefix = structField.name();
                Matcher match = Pattern.compile("(\\w+\\(([A-Z_a-z_0-9]+),\\w+,\\w+\\))+")
                        .matcher(structField.dataType().toString());
                while (match.find()) {
                    list.add(prefix + "." + match.group(2));
                }
            } else {
                listOfSimpleType.add(structField.name());
            }
        }
        int i = 0;
        Column[] column = new Column[list.size() + listOfSimpleType.size()];
        for (String columnName : listOfSimpleType) {
            column[i] = col(columnName);
            i++;
        }
        for (String column_name : list) {
            column[i] = col(column_name).alias(column_name);
            i++;
        }
        return column;
    }
}
*/
